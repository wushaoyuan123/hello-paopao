<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>        
<!doctype html>
<html>
<head>
	<%--包含页面头部 --%>
	<jsp:include page="../../inc/head.jsp"/>
</head>

<body>
	<%--包含标题栏 --%>
	<jsp:include page="../../inc/title.jsp"/>

   	<%--包含页菜单栏 --%>
	<jsp:include page="../../inc/menu.jsp">
		<jsp:param value="doc" name="module"/>
	</jsp:include>
    
    <div id="wrap">
    	<div id="submenu">
        	<ul>
            	<li><a href="index.html" id="fst">文档管理</a></li>            	
            	
            	<%--判断，如果当前登录员工具有公司管理权限(1)--%>
            	<c:if test="${fn:contains(sessionScope.emp.docPrivs,'1')}">
            		<li><a href="add.html?scope=1" ${documentForm.scope==1?"class='cur'":""}>添加公司的文档</a></li>
            	</c:if>
            	
            	<%--判断，如果当前登录员工具有部门分类管理权限 --%>
            	<c:if test="${fn:contains(sessionScope.emp.docPrivs,'2') || fn:contains(sessionScope.emp.docPrivs,'3')}">
	            	<%--如果session中没有部门对象，则不显示为部门添加分类的超链接--%>
	            	<c:if test="${sessionScope.dept!=null}">                
	            		<li><a href="add.html?scope=2" ${documentForm.scope==2?"class='cur'":""}>添加${sessionScope.dept.name}的文档</a></li>                
	            	</c:if>
            	</c:if>
            	
            	<li><a href="add.html?scope=3" ${documentForm.scope==3?"class='cur'":""}>添加我的文档</a></li>                                    
            </ul>
        </div>
        
        <c:if test="${documentForm.scope==1}">
        	<div class="form_title">为<span>公司</span>添加文档</div>        
        </c:if>
        <c:if test="${documentForm.scope==2}">
        	<div class="form_title">为<span>${sessionScope.dept.name}</span>添加文档</div>        
        </c:if>
        <c:if test="${documentForm.scope==3}">
        	<div class="form_title">为<span>${sessionScope.emp.realName}</span>添加文档</div>        	        
        </c:if>     
           
        <form:form modelAttribute="documentForm" method="post" enctype="multipart/form-data">
        <div class="field">
            <div class="lab">标题:</div>
            <div class="ctrl">
            	<form:input path="title" cssClass="txt4" id="txtTitle"/>
            </div>
            <div class="msg">
            	<form:errors path="title"/>
            </div>
        </div>       
        
        <div class="field">
            <div class="lab">分类:</div>
            <div class="ctrl">
            	<form:select path="cid" cssClass="sel">
            		<form:option value="">未指定</form:option>
            		<form:options items="${categorys}" itemValue="id" itemLabel="name"/>		
            	</form:select>            	
            </div>
            <div class="msg">
            	<form:errors path="cid"/>
            </div>
        </div>    
        
        <div class="field">
            <div class="lab">说明:</div>
            <div class="ctrl">
            	<form:input path="note" cssClass="txt3"/>                
            </div>
            <div class="msg">
            	<form:errors path="note"/>
            </div>
        </div>  
            
        <div class="field">
            <div class="lab">文件:</div>
            <div class="ctrl">
                <input type="file" name="upload" class="txt"/>
            </div>
            <div class="msg">
            	<form:errors path="upload"/>
            </div>
        </div>     
        
        <div class="btns">
			<input type="submit" value="上传" class="btn"/>
            <input type="reset" value="重置" class="btn"/>
        </div>
        </form:form>
    
    </div>    
    
    
</body>
</html>

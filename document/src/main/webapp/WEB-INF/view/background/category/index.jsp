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
	<script>
		function changeDept(){
			document.getElementById("frmSwitch").submit();			
		}
	</script>
</head>

<body>
	<%--包含标题栏 --%>
	<jsp:include page="../../inc/title.jsp"/>

    <%--包含页菜单栏 --%>
	<jsp:include page="../../inc/menu.jsp">
		<jsp:param value="category" name="module"/>
	</jsp:include>
    
    <div id="wrap">
    	<div id="submenu">
        	<ul>
            	<%--判断，如果当前登录员工具有公司管理权限(1)--%>
            	<c:if test="${fn:contains(sessionScope.emp.catPrivs,'1')}">
            		<li><a href="index.html?scope=1" ${categorySearchForm.scope==1?"class='cur'":""} id="fst">公司分类</a></li>
            	</c:if>
            	
            	<%--判断，如果当前登录员工具有部门分类管理权限 --%>
            	<c:if test="${fn:contains(sessionScope.emp.catPrivs,'2') || fn:contains(sessionScope.emp.catPrivs,'3')}">
	            	<%--如果session中没有部门对象，则不显示为部门添加分类的超链接--%>
	            	<c:if test="${sessionScope.dept!=null}">                
	            		<li><a href="index.html?scope=2" ${categorySearchForm.scope==2?"class='cur'":""}>${sessionScope.dept.name}分类</a></li>                	            		
	            	</c:if>
            	</c:if>
            	
            	<li><a href="index.html?scope=3" ${categorySearchForm.scope==3?"class='cur'":""}>我的分类</a></li>               
            
            	<c:if test="${categorySearchForm.scope==2}">
            		<c:if test="${fn:contains(sessionScope.emp.catPrivs,'3')}">
	            	<li id="sub_right">
	            		<form:form action="switch.html" modelAttribute="switchDeptForm" method="post" id="frmSwitch">
	            			<form:select path="did" items="${depts}" itemValue="id" itemLabel="name" cssClass="sel2" id="selDept" onchange="changeDept()"/>	                	
	                	</form:form>
	                </li>   
	                </c:if>
            	</c:if>
            
            
            </ul>
        </div>
        <div class="list">
        	<div class="l_item l_head">
            	<div class="col_1">分类名称</div>
				<div class="col_2">操作</div>
                <div class="col_5">
                	<input type="button" value="+添加分类" class="btn" onClick="location='add.html?scope=${categorySearchForm.scope}'"/>
                </div> 
            </div>
            
            <c:forEach items="${categorys}" var="cat">
            <div class="l_item">
            	<div class="col_1">${cat.name}</div>
				<div class="col_2">
                	<a href="add.html">编辑</a>
                	<a href="#">删除</a>                    
                </div>
            </div>
            </c:forEach>
           
            <div class="l_foot">
            	<div class="search">    
            		<form:form modelAttribute="categorySearchForm" method="post">
            			<form:input path="name" cssClass="txt2"/>            	                    
                    	<input type="submit" value="搜索" class="btn"/>
                    </form:form>
                </div>                
            </div>
        </div>
    
    </div>    
    
    
</body>
</html>
    
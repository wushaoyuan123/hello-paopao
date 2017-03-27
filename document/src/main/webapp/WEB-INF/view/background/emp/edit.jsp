<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
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
		<jsp:param value="emp" name="module"/>
	</jsp:include>
    
    <div id="wrap">
    	<div id="submenu">
        	<ul>
            	<li><a href="index.html" id="fst" class="cur">员工管理</a></li>            	
            </ul>
        </div>
        
        <div class="form_title">修改员工</div>     
           
        <form:form modelAttribute="empForm" method="post">
        
        <form:hidden path="id"/>
        
        <div class="field">
            <div class="lab">用户名:</div>
            <div class="ctrl">
            	<form:input path="userName" cssClass="txt"/>
            </div>
            <div class="msg">
            	<form:errors path="userName"/>
            </div>
        </div>
        
        <div class="field">
            <div class="lab">姓名:</div>
            <div class="ctrl">
            	<form:input path="realName" cssClass="txt"/>
            </div>
            <div class="msg">
            	<form:errors path="realName"/>
            </div>
        </div>
        
        <div class="field">
            <div class="lab">所属部门:</div>
            <div class="ctrl">
            	<%--<form:select path="did" cssClass="sel" items="${depts}" itemValue="id" itemLabel="name"/> --%>
            	
            	<form:select path="did" cssClass="sel">
            		<form:option value="" label="请选择部门"/>
            		<form:options items="${depts}" itemValue="id" itemLabel="name"/>            	
            	</form:select>
            	
            	
            	
            	            
            </div>
            <div class="msg">
            	<form:errors path="did"/>
            </div>
        </div>
        
        <div class="field">
            <div class="lab">系统权限:</div>
            <div class="ctrl">
            	<form:checkbox path="sysPrivsArray" value="1" label="部门管理" cssClass="ckb"/>
            	<form:checkbox path="sysPrivsArray" value="2" label="员工管理" cssClass="ckb"/>
            	<form:checkbox path="sysPrivsArray" value="3" label="日志管理" cssClass="ckb"/>                                           
            </div>
            <div class="msg">
            	<form:errors path="sysPrivsArray"/>
            </div>
        </div>
        
        <div class="field">
            <div class="lab">分类权限:</div>
            <div class="ctrl">
                <form:checkbox path="catPrivsArray" value="1" label="公司分类" cssClass="ckb"/>
            	<form:checkbox path="catPrivsArray" value="2" label="所属部门分类" cssClass="ckb"/>
            	<form:checkbox path="catPrivsArray" value="3" label="其他部门分类" cssClass="ckb"/>                                                  
            </div>
            <div class="msg">
            	<form:errors path="catPrivsArray"/>
            </div>
        </div>
        
		<div class="field">
            <div class="lab">文档权限:</div>
            <div class="ctrl">
                <form:checkbox path="docPrivsArray" value="1" label="公司文档" cssClass="ckb"/>
            	<form:checkbox path="docPrivsArray" value="2" label="所属部门文档" cssClass="ckb"/>
            	<form:checkbox path="docPrivsArray" value="3" label="其他部门文档" cssClass="ckb"/>                                                                                        
            </div>
            <div class="msg">
            	<form:errors path="docPrivsArray"/>
            </div>
        </div>
        
        <div class="btns">
			<input type="submit" value="更新" class="btn"/>
            <input type="reset" value="重置" class="btn"/>
        </div>
        </form:form>
    
    </div>    
    
    
</body>
</html>

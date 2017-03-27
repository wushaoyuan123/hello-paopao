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
		<jsp:param value="dept" name="module"/>
	</jsp:include>
    
    <div id="wrap">
    	<div id="submenu">
        	<ul>
            	<li><a href="index.html" id="fst" class="cur">部门管理</a></li>            	
            </ul>
        </div>
        
        <div class="form_title">添加部门</div>     
           
        <form:form modelAttribute="deptForm" method="post">
        
        <div class="field">
            <div class="lab">部门名称:</div>
            <div class="ctrl">
            	<form:input path="name" cssClass="txt"/>
            </div>
            <div class="msg">
            	<form:errors path="name"/>
            </div>
        </div>
        
        <div class="btns">
			<input type="submit" value="添加" class="btn"/>
            <input type="reset" value="重置" class="btn"/>
        </div>
        
        </form:form>
    
    </div>    
    
    
</body>
</html>

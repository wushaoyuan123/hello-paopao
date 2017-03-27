<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!doctype html>
<html>
<head>
<%-- 包含页面头部 --%>
<jsp:include page="inc/head.jsp"/>
</head>

<body>

	<div id="panLog">
    	<div id="log_title"><h1>青鸟企业文档管理系统</h1></div>
        
        <form:form modelAttribute="loginForm"  method="post">
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
        	<div class="lab">密码:</div>
            <div class="ctrl">
            	<form:password path="password" cssClass="txt"/>
            </div>
            <div class="msg">
            	<form:errors path="password"/>
            </div>
        </div>
        
        
        <div class="field mul">
        	<div class="lab">验证码:</div>
            <div class="ctrl">
            	<form:input path="vcode" cssClass="txt"/>            	
                <img src="images/vcode.jpg" class="imgVcode"/>
            </div>
            <div class="msg">
            	<form:errors path="vcode"/>
            </div>
        </div>
        
        <div class="btns">
			<input type="submit" value="登录" class="btn"/>
            <input type="reset" value="重置" class="btn"/>
        </div>
        </form:form>
        
    </div>
    
    
</body>
</html>

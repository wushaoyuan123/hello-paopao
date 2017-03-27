<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<% 
	String path=request.getContextPath();
%>   
<!doctype html>
<html>
<head>
<%--包含页面头部--%>
<jsp:include page="../inc/head.jsp"/>
</head>

<body>
	<%--包含标题栏 --%>
	<jsp:include page="../inc/title.jsp"/>
	<%--包含菜单栏 --%>
    <jsp:include page="../inc/menu.jsp"/>
    
    <div id="wrap">
    	<div class="message">
	    	
            <c:if test="${message.status==0}">
            	<span class="error">${message.content}</span>，
            	<a href="<%=path%>/background/${message.path}/index.html">返回${message.module}</a>
            </c:if>
            
            <c:if test="${message.status==1}">
            	<span class="success">${message.content}</span>，
            	<a href="<%=path%>/background/${message.path}/index.html">返回${message.module}</a>
            </c:if>
            
            <!--<br/>            
            <span class="error">你没有执行此操作的权限</span>     -->
        </div>

    </div>    
    
    
</body>
</html>

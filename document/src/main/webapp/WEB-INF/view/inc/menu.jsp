<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path=request.getContextPath();
%>    
<ul id="menu">
	<li><a href="<%=path%>/background/doc/index.html" ${param.module=="doc"?"class='cur'":""}>文档管理</a></li>
	<li><a href="<%=path%>/background/category/index.html" ${param.module=="category"?"class='cur'":""}>分类管理</a></li>
	<li><a href="<%=path%>/background/dept/index.html" ${param.module=="dept"?"class='cur'":""}>部门管理</a></li>
	<li><a href="<%=path%>/background/emp/index.html" ${param.module=="emp"?"class='cur'":""}>员工管理</a></li>
	<li><a href="log/index.html">日志管理</a></li>
	<li><a href="recycle/index.html">回收站</a></li>
</ul>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!doctype html>
<html>
<head>
	<%--包含页面头部 --%>
	<jsp:include page="../../inc/head.jsp"/>
	<script>
		function del(id,name){
			if(confirm("确定要删除部门["+name+"]吗？")){
				location="delete_"+id+".html";
			}
		}
	</script>
	
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
        <div class="list">
        	<div class="l_item l_head">
            	<div class="col_1">部门名称</div>
				<div class="col_2">操作</div>
                <div class="col_5">
                	<input type="button" value="+添加部门" class="btn" onClick="location='add.html'"/>
                </div> 
            </div>
            
            <c:forEach items="${depts}" var="dept">
            <div class="l_item">
            	<div class="col_1">${dept.name}</div>
				<div class="col_2">
                	<a href="edit_${dept.id}.html">编辑</a>
                	<a href="javascript:del(${dept.id},'${dept.name}')">删除</a>                    
                </div>
            </div>
            </c:forEach>
         
            <div class="l_foot">
            	<div class="search">          
            	    <form:form modelAttribute="deptSearchForm" method="post">
           	      		<form:input path="name" cssClass="txt2"/>
		                <input type="submit" value="搜索" class="btn"/>
                    </form:form>
                </div>                
            </div>
            
        </div>
    
    </div>    

</body>
</html>

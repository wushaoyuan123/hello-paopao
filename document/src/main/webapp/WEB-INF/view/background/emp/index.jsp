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
	function toPage(i){
		document.getElementById("hidPageIndex").value=i;
		document.getElementById("frmPage").submit();		
	}
	
	function del(id,name){
		if(confirm("确定要删除员工["+name+"]吗？")){
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
		<jsp:param value="emp" name="module"/>
	</jsp:include>
    
    <div id="wrap">
    	<div id="submenu">
        	<ul>
            	<li><a href="index.html" id="fst" class="cur">员工管理</a></li>            	
            </ul>    
        </div>
        <div class="list">
        	<div class="l_item l_head">
            	<div class="col_1">姓名</div>
            	<div class="col_3">部门</div>                
				<div class="col_2">操作</div>
                <div class="col_5">
                	<input type="button" value="+添加员工" class="btn" onClick="location='add.html'"/>
                </div> 
            </div>
           
            
            <c:forEach items="${p.results}" var="emp">
            	<c:if test="${emp.admin==true}">
		            <div class="l_item">
		            	<div class="col_1">${emp.realName}</div>
		            	<div class="col_3">----</div>                  
						<div class="col_2">----</div>
		            </div>
            	</c:if>
            	<c:if test="${emp.admin==false}">
            		<div class="l_item">
		            	<div class="col_1">${emp.realName}</div>
		            	<div class="col_3">${emp.dname}</div>                  
						<div class="col_2">
		                	<a href="edit_${emp.id}.html">编辑</a>
		                    <a href="reset_${emp.id}.html">重置密码</a>
		                	<a href="javascript:del(${emp.id},'${emp.realName}')">删除</a>                    
		                </div>
		            </div>	            	
            	</c:if>            
            </c:forEach>
            
            <div class="l_foot">
            	<div class="search">
            		<form:form modelAttribute="empSearchForm" method="post">            		
	                	<form:select path="did">
		            		<form:option value="" label="所有部门"/>
		            		<form:options items="${depts}" itemValue="id" itemLabel="name"/>            	
		            	</form:select>		            	
		            	<form:input path="realName" cssClass="txt2"/>		            	
	                    <input type="submit" value="搜索" class="btn"/>
                    </form:form>
                    <!-- 分页辅助表单 -->
                    <form:form modelAttribute="empSearchForm" method="post" id="frmPage">
                    	<input type="hidden" name="pageIndex" id="hidPageIndex"/>
                    	<form:hidden path="did"/>
                    	<form:hidden path="realName"/>
                    </form:form>
                    
                </div>
                <div class="pagination">
                	<c:if test="${p.pageIndex>1}">
                	<a href="javascript:toPage(1)">首页</a>
                	<a href="javascript:toPage(${p.pageIndex-1})">上页</a>
                	</c:if>
                	
                	<c:if test="${p.pageIndex<p.pageCount}">
                	<a href="javascript:toPage(${p.pageIndex+1})">下页</a>
                	<a href="javascript:toPage(${p.pageCount})">末页</a>                                                            
                    </c:if>
                    
                    ${p.pageIndex}/${p.pageCount}
                </div>
            </div>
        </div>
    
    </div>    
    
    
</body>
</html>

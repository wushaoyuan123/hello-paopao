<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            	<%--判断，如果当前登录员工具有公司管理权限(1)--%>
            	<c:if test="${fn:contains(sessionScope.emp.docPrivs,'1')}">
            		<li><a href="index.html?scope=1" ${documentSearchForm.scope==1?"class='cur'":""}>公司文档</a></li>
            	</c:if>
            	
            	<%--判断，如果当前登录员工具有部门分类管理权限 --%>
            	<c:if test="${fn:contains(sessionScope.emp.docPrivs,'2') || fn:contains(sessionScope.emp.docPrivs,'3')}">
	            	<%--如果session中没有部门对象，则不显示为部门添加分类的超链接--%>
	            	<c:if test="${sessionScope.dept!=null}">                
	            		<li><a href="index.html?scope=2" ${documentSearchForm.scope==2?"class='cur'":""}>${sessionScope.dept.name}文档</a></li>                
	            	</c:if>
            	</c:if>
            	
            	<li><a href="index.html?scope=3" ${documentSearchForm.scope==3?"class='cur'":""}>我的文档</a></li>                            	                                
            </ul>    
        </div>
        <div class="list">
        	<div class="l_item l_head">
            	<div class="col_6">
                	<input type="checkbox"/>                
                </div>
            	<div class="col_1">文档标题</div>
            	<div class="col_3">上传员工</div>                
            	<div class="col_3">分类</div>                             
				<div class="col_2">操作</div>
                <div class="col_5">
                	<!--
                	<input type="button" value="+上传文档" class="btn" onClick="location='add.html'"/>
                    <input type="button" value="-删除所选" class="btn" />
                    -->
                </div> 
            </div>
            
            <c:forEach items="${p.results}" var="doc">
            <div class="l_item">
            	<div class="col_6">
					<input type="checkbox" name="id" value="${doc.id}"/> 
                </div>            
            	<div class="col_1"><a href="detail.html">${doc.title}</a></div>
            	<div class="col_3">${doc.ename}</div>
            	<div class="col_3">${doc.cname}</div>                                
				<div class="col_2">
                	<a href="#">下载</a> 
                	<a href="dump.html">转存</a>                                     
                </div>
            </div>
            </c:forEach>
            
            
            <div class="l_foot">
            	<div class="search">               
                	<select name="dept.id" class="sel2">
                        <option value="">所有分类</option>
                        <option value="1">规章制度</option>
                        <option value="2">企业文化</option>
                        <option value="3">文件模板</option>
                        <option value="4">影音资料</option>
                        <option value="5">拓展活动</option>                                                                                                                        
                        <option value="6">业务培训</option>                                                                                                                      
                	</select>
                    <input type="text" name="keyword" class="txt2"/>
                    <input type="button" value="搜索" class="btn"/>
                </div>
                <div class="pagination">
                	<a href="#">首页</a>
                	<a href="#">上页</a>
                	<a href="#">下页</a>
                	<a href="#">末页</a>                                                            
                    1/5
                </div>
            </div>
        </div>
    
    </div>    
 
</body>
</html>

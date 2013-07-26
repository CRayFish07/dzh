<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>用户角色列表</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>用户角色列表</h2></div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title"><td>用户ID</td><td>用户名</td><td>真实姓名</td><td>角色</td><td>操作</td></tr>
            
            <c:forEach items="${userinfolist}" var="item" varStatus="status">
            	<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
            		<td>${item.userid}</td>
            		<td>${item.user.name}</td>
            		<td><a href='userinfo!update.do?userinfo.id=${item.id}'>${item.user.username}</a></td>
            		<td><c:forEach items="${item.rolselist}" var="it" varStatus="sta">${it.rolse}|</c:forEach></td>
            		<td><a href='#' onclick='showconfirm(${item.id})'>删除</a></td>
            	</tr>
            
			</c:forEach>
			
            </tbody>
        </table>
    </div>
</div>
<script>
	function showconfirm(id) {
		if (confirm("确定删除吗?") == true) {
			window.location.href="userinfo!del.do?userinfo.id="+id;
		}		
	}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>角色列表</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>角色列表</h2></div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title"><td>ID</td><td>角色名</td><td>备注</td><td width="75%">权限</td></tr>
            
            <c:forEach items="${rolselist}" var="item" varStatus="status">
	    		<tr class=''>
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${item.id}</td>
	    			<td><a href='rolse!update.do?rolse.id=${item.id}'>${item.rolse}</a></td>
	    			<td>${item.info}</td>
	    			<td><c:forEach items="${item.modulelist}" var="modu" varStatus="status2">${modu.name}|</c:forEach></td>
	    		</tr>
			</c:forEach>
			
        </table>
    </div>
</div>
</body>
</html>
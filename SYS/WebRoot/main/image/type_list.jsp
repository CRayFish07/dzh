<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta charset="utf-8" />
<title>相册列表</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>相册列表</h2></div>
        <table class="GF-listTab">
            <tbody><tr id="title">
                <td>ID</td><td>相册名</td><td>介绍</td><td>添加子目录</td>
            </tr>
            <tr class="trstyle1">
	            	<td>0</td>
	            	<td>/根目录</td>
	            	<td>顶级目录</td>
	            	<td><a href="imgtype!add.do?type.parentid=0">添加</a></td>
	        <tr>
            <c:forEach items="${list}" var="item" varStatus="status">
	            <tr class='<c:if test="${status.index % 2==1}">trstyle1</c:if><c:if test="${status.index % 2==0}">trstyle2</c:if>'>
	            	<td>${item.id}</td>
	            	<td><a href="imgtype!update.do?type.id=${item.id}">${item.fullname}</a></td>
	            	<td>${item.info}</td>
	            	<td><a href="imgtype!add.do?type.parentid=${item.id}">添加</a></td>
	            <tr>
			</c:forEach>
			
			</tbody>
			</table>
    </div>
</div>
</body>
</html>
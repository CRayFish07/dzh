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
        <div id="gamefeatures"><h2>选择相册</h2></div>
        <table class="GF-listTab">
            <tbody><tr id="title">
                <td>ID</td><td>相册名</td><td>相册数</td><td>照片数</td><td>操作</td>
            </tr>
            <c:forEach items="${typelist}" var="item" varStatus="status">
	            <tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	            	<td>${item.id}</td>
	            	<td>${item.fullname}</td>
	            	<td><c:if test="${item.sub>0}"><a href="?img.type=${item.id}">${item.sub}个子相册</a></c:if></td>
	            	<td><a href="images!list.do?img.type=${item.id}">${item.photo}张照片</a></td>
	            	<td><a href="images!add2.do?img.type=${item.id}">上传照片</a> <a href="upload.do?img.type=${item.id}">批量上传照片</a></td>
	            <tr>
			</c:forEach>
			
			</tbody>
			</table>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta charset="utf-8" />
<title>照片管理</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        
        <div id="gamefeatures"><h2>照片上传</h2></div>
        <table class="GF-listTab">
        <form action="images!addup.do" method="post" enctype="multipart/form-data">
            <tbody>
            	<tr id="title"><td>照片集</td><td><input type="text" name="img.type" value="${img.type}"></td></tr>
                <tr id="title"><td>日期</td><td><input type="text" name="img.date" value="${img.date}"></td></tr>
                <tr id="title"><td>上传文件:</td><td>
                <img src="images!show.do?img.id=${img.id}" height="150" border="0" title="${img.name}" alt="${img.info}"/>
                <input type="hidden" name="img.id" value="${img.id}">
                <input name="image" type="file" size="20" >
                </td></tr>
                <tr id="title"><td colspan="2"><input class="sub-btn" type="submit" id="sub" value="提交" name="sub"></td></tr>
			</tbody>
		</table>
		</form>
    </div>
</div>
</body>
</html>

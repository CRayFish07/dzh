<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>展示</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
    <a href="images!show.do?img.type=${img.type}&img.id=${next.id}">
    <img src="images!img.do?img.id=${img.id}" border="0" width="600" title="${img.name}" alt="${img.info}"/>
    </a>
    </div>
</div>
</body>
</html>
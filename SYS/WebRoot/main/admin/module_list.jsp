<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块列表</title>
<link rel="StyleSheet" href="/css/admin/style.css" type="text/css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>模块列表</h2></div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title">
                <td>ID</td>
                <td>模块名</td>
                <td>URL</td><td>模块类型</td><td>状态</td><td>操作</td>
            </tr>
            <c:forEach items="${modulelist}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${item.id}</td>
	    			<td align="left"><a href='module!update.do?module.id=${item.id}'>${item.name}</a></td>
					<td>${item.url}</td>
					<td><c:if test="${item.type==1}">目录</c:if><c:if test="${item.type==2}">文件</c:if></td>
					<td><c:if test="${item.state==1}">开启</c:if><c:if test="${item.state==-1}">禁用</c:if></td>
					<td><a href='module!upstate.do?module.id=${item.id}&module.state=<c:if test="${item.state==-1}">1</c:if><c:if test="${item.state==1}">-1</c:if>'><c:if test="${item.state==-1}">开启</c:if><c:if test="${item.state==1}">禁用</c:if></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
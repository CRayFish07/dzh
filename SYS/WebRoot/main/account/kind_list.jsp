<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类列表</title>
<link rel="StyleSheet" href="/css/admin/style.css" type="text/css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>分类列表</h2></div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title">
                <td>ID</td>
                <td>分类名</td>
                <td>介绍</td>
                <td>上级</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${item.id}</td>
	    			<td align="left"><a href='kind!update.do?type=update&kind.id=${item.id}'>${item.title}</a></td>
					<td>${item.note}</td>
					<td>${item.parentId}</td>
					<td>删除</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
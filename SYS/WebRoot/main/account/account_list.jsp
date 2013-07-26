<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css" />
<script language="javascript" type="text/javascript" src="../js/Calendar3.js" ></script>
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>账目列表</h2></div>
        <div id="gamemain">
        <form action="acc!list.do">
       	 查询时间:
       	<input type="text" name="beginDate" value="${beginDate}" size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/>
       	至
       	<input type="text" name="endDate" value="${endDate}" size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/>
       	金额大于<input type="text" name="acc.money" value="0" size="10" maxlength="10" />
       	分类：<select id="acc.kindid" name="acc.kindid">
     			<option value="">全部</option>
     			<c:forEach items="${kindlist}" var="item" varStatus="status">
				<option value="${item.uid}" <c:if test="${item.uid==acc.kindid }">selected</c:if>>${item.title}</option>
				</c:forEach>
			</select>
       	<input type="submit" value="查询">
        </form>
        </div>
        <div></div>
        <table class="GF-listTab">
            <tbody>
            <tr id="title">
                <td>ID</td>
                <td>名称</td>
                <td>金额</td>
                <td>分类</td>
                <td>日期</td>
                <td>操作人</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
	    		<tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	    			<td>${item.id}</td>
	    			<td align="left"><a href='acc!update.do?type=update&acc.id=${item.id}'>${item.title}</a></td>
					<td>${item.money}</td>
					<td><c:forEach items="${kindlist}" var="it" varStatus="status2"><c:if test="${it.uid==item.kindid}">${it.title}</c:if></c:forEach></td>
					<td>${item.datetime}</td>
					<td>${item.username}</td>
					<td>删除</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
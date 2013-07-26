<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类</title>
<link rel="StyleSheet" href="/css/admin/style.css" type="text/css"/>
</head>
<body>

<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>分类<c:if test="${kind.id==0}">添加</c:if><c:if test="${kind.id>0}">修改</c:if></h2></div>
        <form method="post" action="kind!addup.do" name="form" id="form">
        	<input type="hidden" name="kind.id" value="${kind.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>标题:</b></td><td><input type="text" name="kind.title" value="${kind.title}" size=30></td></tr>
                    <tr><td class="title"><b>摘要:</b></td><td><input type="text" name="kind.note" value="${kind.note}" size=30></td></tr>
                    <tr>
                        <td class="title"><b>上级分类:</b></td>
                        <td>
						<select id="kind.parentId" name="kind.parentId">
						<c:forEach items="${list}" var="item" varStatus="status">
							<option value="${item.id}" <c:if test="${item.id==kind.id }">selected</c:if>>${item.title}</option>
						</c:forEach>
						</select>
	                    </td>
                    </tr>
                    <tr><td colspan="2"><input type="submit" value="提  交" name="submit" class="sub-btn"></td></tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
</body>

<script language="javascript" type="text/javascript" src="/js/jquery/jquery.js" ></script>
<script language="javascript" type="text/javascript" >
$(function() {
	$('input[name="submit"]').click(function() {
		var name = $('input[name="kind.title"]').val();
		if(name == ''){
			alert('模块名不能为空!');
			$('input[name="kind.title"]').focus();
			return false;
		}

		$('form').submit();

	});
});
</script>

</html>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入库</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css"/>
<script language="javascript" type="text/javascript" src="../js/Calendar3.js" ></script>
</head>
<body>

<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>日记<c:if test="${diary.id==0}">添加</c:if><c:if test="${diary.id>0}">修改</c:if></h2></div>
        <form method="post" action="diary!addup.do" name="form" id="form">
        	<input type="hidden" name="diary.id" value="${diary.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>名称:</b></td><td><input type="text" name="diary.title" value="${diary.title}"></td></tr>
                    <tr><td class="title"><b>内容:</b></td><td><input type="text" name="diary.content" value="${diary.content}"></td></tr>
                    <tr><td class="title"><b>日期:</b></td><td><input type="text" name="diary.datetime" value="${diary.datetime}"  size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"></td></tr>
                    <tr><td class="title"><b>操作人:</b></td><td>${user.name}</td></tr>
                    <tr><td colspan="2"><input type="submit" value="提  交" name="submit" class="sub-btn"></td></tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
</body>

<script language="javascript" type="text/javascript" src="../js/jquery/jquery.js" ></script>
<script language="javascript" type="text/javascript" >
$(function() {
	$('input[name="submit"]').click(function() {
		var name = $('input[name="diary.title"]').val();
		if(name == ''){
			alert('名称不能为空!');
			$('input[name="diary.title"]').focus();
			return false;
		}
		
		var jg = $('input[name="diary.content"]').val();
		if(jg == ''){
			alert('内容不能为空!');
			$('input[name="diary.content"]').focus();
			return false;
		}

		$('form').submit();

	});
});
</script>

</html>
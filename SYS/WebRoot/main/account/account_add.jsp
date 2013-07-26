<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入账入库</title>
<link rel="StyleSheet" href="../css/admin/style.css" type="text/css"/>
<script language="javascript" type="text/javascript" src="../js/Calendar3.js" ></script>
</head>
<body>

<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>账目<c:if test="${acc.id==0}">添加</c:if><c:if test="${acc.id>0}">修改</c:if></h2></div>
        <form method="post" action="acc!addup.do" name="form" id="form">
        	<input type="hidden" name="acc.id" value="${acc.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>名称:</b></td><td><input type="text" name="acc.title" value="${acc.title}"></td></tr>
                    <tr><td class="title"><b>价格:</b></td><td><input type="text" name="acc.money" value="${acc.money}"></td></tr>
                    <tr><td class="title"><b>类别:</b></td>
                    <td>
                    <select id="acc.kindid" name="acc.kindid">
						<c:forEach items="${kindlist}" var="item" varStatus="status">
							<option value="${item.uid}" <c:if test="${item.uid==acc.kindid }">selected</c:if>>${item.title}</option>
						</c:forEach>
					</select>
                    </td>
                    </tr>
                    <tr><td class="title"><b>日期:</b></td><td><input type="text" name="acc.datetime" value="${acc.datetime}"  size="10" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"></td></tr>
                    <tr><td class="title"><b>操作人:</b></td><td>${user.name}</td></tr>
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
		var name = $('input[name="acc.title"]').val();
		if(name == ''){
			alert('名称不能为空!');
			$('input[name="acc.title"]').focus();
			return false;
		}
		
		var jg = $('input[name="acc.money"]').val();
		if(jg == ''){
			alert('价格不能为空!');
			$('input[name="acc.money"]').focus();
			return false;
		}

		var jg = $('input[name="acc.datetime"]').val();
		if(jg == ''){
			alert('日期不能为空!');
			$('input[name="acc.datetime"]').focus();
			return false;
		}
		$('form').submit();

	});
});
</script>

</html>
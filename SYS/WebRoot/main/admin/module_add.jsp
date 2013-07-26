<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="/css/admin/style.css" type="text/css"/>
</head>
<body>

<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>模块<c:if test="${module.id==0}">添加</c:if><c:if test="${module.id>0}">修改</c:if></h2></div>
        <form method="post" action="module!addup.do" name="add">
        	<input type="hidden" name="module.id" value="${module.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>模块名:</b></td><td><input type="text" name="module.name" value="${module.name}" size=30></td></tr>
                    <tr><td class="title"><b>模块链接:</b></td><td><input type="text" name="module.url" value="${module.url}" size=30></td></tr>
                    <tr><td class="title"><b>模块类型:</b></td>
                    <td>
                    <input type="radio" id="1" value="1" name="module.type" <c:if test="${module.type==1}">checked</c:if>/><label for="1">目录</label>
                    <input type="radio" id="2" value="2" name="module.type" <c:if test="${module.type==2}">checked</c:if>/><label for="2">文件</label>
                    </td>
                    </tr>
                    <tr>
                        <td class="title"><b>上级模块:</b></td>
                        <td>
						<select name="module.parentid">
						<option value="0">根目录
					    <c:forEach items="${modulelist}" var="item" varStatus="status">
					    	<option value='${item.id}' <c:if test="${module.parentid==item.id}">selected="selected"</c:if>>${item.name}
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
		var name = $('input[name="module.name"]').val();
		if(name == ''){
			alert('模块名不能为空!');
			$('input[name="module.name"]').focus();
			return false;
		}

		var type = $('input[name="module.type"]:checked').val();
		//alert(type) ;
		if(type != 1 && type != 2){
			alert('请选择类型!');
			return false;
		}
		$('form').submit();

	});
});
</script>

</html>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>角色添加</title>
<link rel="StyleSheet" href="/css/admin/style.css" type="text/css"/>

</head>
<body>
<div class="content">
    <div id="main" class="main">
        <!--<h5>角色添加</h5><br>-->
        <div id="gamefeatures"><h2>角色<c:if test="${rolse.id==0}">添加</c:if><c:if test="${rolse.id>0}">修改</c:if></h2></div>
        <form method="post" action="rolse!addup.do">
        <input type="hidden" name="rolse.id" value="${rolse.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                        <tr><td class="title"><b>角色名:</b></td><td><input type="text" name="rolse.rolse" value="${rolse.rolse}"></td></tr>
                        <tr><td class="title"><b>备注:</b></td><td><input type="text" name="rolse.info" value="${rolse.info}"></td></tr>
                        <tr>
                            <td class="title">
                                <b>权限:</b>
                            </td>
                            <td>
                                <table>
	                                <tr>
	                                <tbody>
	                                <fieldset id='all'>
		                                
		                                <c:forEach items="${modulelist}" var="item" varStatus="status">
		                                	<legend>
			                                	<input type='checkbox' name='rolse.moduleid' value='${item.id}' id='${item.id}' <c:if test="${item.checked}">checked</c:if> >
			                                	<label for='${item.id}'>${item.name}</label>
			                                </legend>
			                                <legend>
			                                	<c:forEach items="${item.sublist}" var="item2" varStatus="status2">
			                                		
				                                	&nbsp;&nbsp;&nbsp;
				                                	<input type='checkbox' name='rolse.moduleid' value='${item2.id}' id='${item2.id}' <c:if test="${item2.checked}">checked</c:if> >
				                                	<label for='${item2.id}'>${item2.name}</label>
			                                		<legend>
			                                		<c:if test="${item2.type==1}">
				                                		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                                	<c:forEach items="${item2.sublist}" var="item3" varStatus="status3">
						                                	<input type='checkbox' name='rolse.moduleid' value='${item3.id}' id='${item3.id}' <c:if test="${item3.checked}">checked</c:if> >
							                                <label for='${item3.id}'>${item3.name}</label>
						                                	
														</c:forEach>
													</c:if>
													</legend>
												</c:forEach>
		                                	
						    				</legend>
										</c:forEach>
										
									</fieldset>
	                                </tbody>
	                                </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <table>
                                <tr><td class="RoleOfAdd-btn"><input type="submit" value="提  交" name="submit"></td></tr>
                            </table>
                        </tr>
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
		var rolse = $('input[name="rolse.rolse"]').val();
		if(rolse == ''){
			alert('角色名不能为空!');
			$('input[name="rolse.rolse"]').focus();
			return false;
		}
		
		var rolse = $('input[name="rolse.info"]').val();
		if(rolse == ''){
			alert('角色介绍不能为空!');
			$('input[name="rolse.info"]').focus();
			return false;
		}
		
		$('form').submit();

	});
});
</script>

</html>
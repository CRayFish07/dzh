<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta charset="utf-8" />
<title>相册管理</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <!--<h5>用户添加</h5><br>-->
        <div id="gamefeatures"><h2>相册<c:if test="${type.id==0}">添加</c:if><c:if test="${type.id>0}">修改</c:if></h2></div>
        <form action="imgtype!addup.do" method="post">
        <input type="hidden" name="type.id" value="${type.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>相册名:</b></td><td><input type="text" name="type.name" value="${type.name}"></td></tr>
                    <tr><td class="title"><b>介绍:</b></td><td><input type="text" name="type.info" value="${type.info}"></td></tr>
                    <tr><td class="title"><b>上级目录:</b></td><td>
                       <table class="RoleOfAdd-listTab">
                           <tbody>
                               <tr>
                               <select name="type.parentid">
								<option value="0">根目录
							    <c:forEach items="${list}" var="item" varStatus="status">
							    	<option value='${item.id}' <c:if test="${type.parentid==item.id}">selected="selected"</c:if>>${item.name}
		    					</c:forEach>
			                    </select>
                               </tr>
                           </tbody>
                       </table>
                    </td></tr>
                    <tr><td colspan="2"><input class="sub-btn" type="submit" id="sub" value="提交" name="sub"></td></tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>

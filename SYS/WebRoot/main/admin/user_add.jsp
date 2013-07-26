<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>用户添加</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <!--<h5>用户添加</h5><br>-->
        <div id="gamefeatures"><h2>用户<c:if test="${u.id==0}">添加</c:if><c:if test="${u.id>0}">修改</c:if></h2></div>
        <form action="user!addup.do" method="post">
        <input type="hidden" name="u.id" value="${u.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>登录名:</b></td><td><input type="text" name="u.name" value="${u.name}"></td></tr>
                    <tr><td class="title"><b>显示名:</b></td><td><input type="text" name="u.username" value="${u.username}"></td></tr>
                    <tr><td class="title"><b>邮箱:</b></td><td><input type="text" name="u.email" value="${u.email}"></td></tr>
                    <tr><td class="title"><b>密码:</b></td><td><input type="text" name="u.password" value="${u.password}"></td></tr>
                    <tr><td colspan="2"><input class="sub-btn" type="submit" id="sub" value="提交" name="sub"></td></tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>

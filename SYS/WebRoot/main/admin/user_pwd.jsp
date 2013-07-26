<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>用户密码修改</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <!--<h5>用户添加</h5><br>-->
        <div id="gamefeatures"><h2>用户密码修改</h2></div>
        <form action="user!pwdup.do" method="post">
        <input type="hidden" name="u.id" value="${u.id}">
            <div id="gamemain">
                <table>
                    <tbody>
                    <tr><td class="title"><b>登录名:</b></td><td>${u.name}</td></tr>
                    <tr><td class="title"><b>显示名:</b></td><td>${u.username}</td></tr>
                    <tr><td class="title"><b>邮箱:</b></td><td>${u.email}</td></tr>
                    <tr><td class="title"><b>新密码:</b></td><td><input type="text" name="u.password" value=""></td></tr>
                    <tr><td colspan="2"><input class="sub-btn" type="submit" id="sub" value="提交" name="sub"></td></tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>

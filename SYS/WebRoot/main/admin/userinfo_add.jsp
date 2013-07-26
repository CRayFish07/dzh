<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>用户角色添加</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>用户角色<c:if test="${userinfo.id==0}">添加</c:if><c:if test="${userinfo.id>0}">修改</c:if></h2></div>
        <form method="post" action="userinfo!addup.do">
        <input type="hidden" name="userinfo.id" value="${userinfo.id}">
            <div id="gamemain">
                <table>
                    <tbody><tr>
                        <td class="title"><b>用户:</b></td>
                        <td>
                            <select name="userinfo.userid">
                            <c:forEach items="${userlist}" var="item" varStatus="status">
                            	<option value='${item.id}' <c:if test="${userinfo.userid==item.id}">selected</c:if>>${item.name}-${item.username}
                            </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="title"><b>角色:</b></td>
                        <td><table class="RoleOfAdd-listTab"><tbody><tr>
                        	<c:forEach items="${rolselist}" var="item" varStatus="status">
                        		<td><input type='checkbox' name='userinfo.rolsesid' value='${item.id}' id='${item.id}' 
                        		<c:forEach items="${userinfo.rolselist}" var="it" varStatus="status2"><c:if test="${it.id==item.id}">checked</c:if></c:forEach>
								><label for='${item.id}'>${item.rolse}</label></td>
                            	<c:if test="${(status.index+1) % 8==0}"><tr/><tr></c:if>
                            </c:forEach>
                        </tr></tbody>
                        </table></td>
                    </tr>
                    <tr><td colspan="2"><input class="sub-btn" type="submit" id="sub" value="提交" name="sub"></td></tr>
                    </tbody></table>
            </div>
        </form>
    </div>
</div>
</body>
</html>

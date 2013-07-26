<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>用户列表</title>
<link rel="stylesheet" href="/css/admin/style.css" />
</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>用户列表</h2></div>
        <table class="GF-listTab">
            <tbody><tr id="title">
                <td>用户ID</td><td>用户名</td><td>真实姓名</td><td>邮箱</td><td>注册日期</td><td>操作</td>
            </tr>
            <c:forEach items="${list}" var="item" varStatus="status">
	            <tr class='<c:if test="${status.index % 2==1}">trstyle2</c:if><c:if test="${status.index % 2==0}">trstyle1</c:if>'>
	            	<td>${item.id}</td>
	            	<td>${item.name}</td>
	            	<td><a href="user!update.do?u.id=${item.id}">${item.username}</a></td>
	            	<td>${item.email}</td>
	            	<td>${item.registDate}</td>
	            	<td> 
	            	<input type="button" class="sub-btn" value="修改密码" onclick="pwd(${item.id})"/>
	            	<a href="user!del.do?u.id=${item.id}">删除</a> 
	            	</td>
	            <tr>
			</c:forEach>
			
			</tbody>
			</table>
    </div>
</div>
</body>
<script language="javascript" type="text/javascript" >
function pwd(uid){
	var url = "user!pwd.do?u.id="+uid ;
	//window.open(url, "op", 'height=500,width=300,scrollbars=no,z-look=yes,resizable=no,menubar=yes,location=no,directories=no,alwaysRaised=yes,depended=yes') ;
	window.showModalDialog(url,"","dialogHeight=400px;dialogWidth=600px;dialogLeft=500;dialogTop=100;center=yes;help=no;resizable=no;scroll=no;status=no;") ;
	//window.showModalDialog(url,"","dialogWidth:500px;dialogHeight:300px;status:no;directories:yes;scrollbars:no;Resizable=no;location=no;location=no;titlebar=no;menubar=no") ;
	//window.showModalDialog(url,"",'height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') ;
	//window.showModelessDialog(url,"","dialogHeight=200px;dialogWidth=300px;dialogLeft=500;dialogTop=100;center=yes;help=no;resizable=no;status=no;scroll=no") ;
	document.location.reload();
}
</script>
</html>
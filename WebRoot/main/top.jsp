<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link href="css/frame.css" rel="stylesheet" type="text/css" />
</head>
<body class="showmenu">
<div class="pagemask"></div>
<iframe class="iframemask"></iframe>
<div class="head">
<div class="top">
<div class="top_logo">
	<img src="images/admin_top_logo.gif" width="170" height="37" />
</div>
<div class="top_link">
<ul>
	<li class="welcome">
	${user.username} ，您好！</li>
	<li><a href="index!loginout.do" target="_top">注销</a></li>
</ul>
</div>

<div class="topnav">
<div class="menuact">管理系统:</div>
<div class="nav" id="nav"></div>

<div class="sysmsg">
<h3>后台管理系统:</h3>
<div class="scroll">
<!-- ${systems} -->
<a href='#' target='_blank'>后台1</a>
<a href='#' target='_blank'>后台2</a>
<a href='#' target='_blank'>后台3</a>
<a href='#' target='_blank'>后台4</a>

</div>
</div>
</div>

</div>
</div>
</body>
</html>

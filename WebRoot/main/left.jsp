<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>左菜单</title>
	<link rel="StyleSheet" href="js/dtree/dtree.css" type="text/css" />
	<script type="text/javascript" src="js/dtree/dtree.js"></script>
</head>
<body bgcolor="#ffffff">
	<div class="dtree">
	<p><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部合并</a></p>
	<script type="text/javascript">
		var img_path = 'js/dtree/img/' ;
		var d = new dTree('d');
		d.add(0,-1,'系统管理');
		${modulelist}		
		document.write(d);
	</script>
	<br>
	
	</div>
</body>
</html>

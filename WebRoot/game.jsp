<%@ page language="java" import="com.gzb.game.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link href="css/comm.css" rel="stylesheet" type="text/css" />
<title>标题</title>
</head>
<body>
<div>

<jsp:include page="common/top.jsp"/>
<div style="float:left;">
a广告
</div>

<br/>
<br/>
<br/>
<br/>
<applet code="com.gzb.game.JinHua.class"  width=500 height=400 id="jh" CodeBase="." ARCHIVE="jar/game.jar"> </applet>

<applet code="com.gzb.game.encode.Encode.class" width=400 height=200 CodeBase="." ARCHIVE="jar/game.jar"> </applet>

<applet code="com.gzb.game.evolution.Evolution.class" width=600 height=700 CodeBase="." ARCHIVE="jar/game.jar"> </applet>
==
<applet code="com.gzb.game.evolution.Main.class" width=500 height=400 CodeBase="." ARCHIVE="jar/game.jar"> </applet>
===
计算器<br/>
<APPLET CODE="com.gzb.game.JiSuanQi.class" id="JiSuanQi" codebase="." ARCHIVE = "jar/game.jar" WIDTH="500" HEIGHT="150"></APPLET>
<p><a href="#" onclick="openApp()">计算器</a></p>
<script type="text/javascript">
function openApp(){
  var JiSuanQi = document.getElementById("JiSuanQi");
  JiSuanQi.openApp();
}
</script>

<jsp:include page="common/botom.jsp"/>



</div>
</body>
</html>
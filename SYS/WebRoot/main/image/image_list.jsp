<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>相册列表</title>
<link rel="stylesheet" href="../css/admin/style.css" />
<script language="javascript" type="text/javascript" src="../js/jquery/jquery.js" ></script>

</head>
<body>
<div class="content">
    <div id="main" class="main">
        <div id="gamefeatures"><h2>
        	<c:if test="${img.type==0}">相册集</c:if>
        	<c:if test="${img.type>0}">
        		<c:forEach items="${typelist}" var="it" varStatus="sta"><c:if test="${it.id==img.type}">${it.fullname} 相册</c:if></c:forEach>
        	</c:if>
        </h2></div>
        <table class="GF-listTab">
        	<tr><td><ul>
            <c:forEach items="${list}" var="item" varStatus="status">
            	<c:if test="${status.index % 5==0}"></c:if>
            	<li style="float:left;" id="list_${status.index}">
            	<div>
            		<div>${status.index+1} . ${item.imgtype.fullname}</div>
            		<div>${item.date}</div>
            		<div><a href="images!show.do?img.type=${item.type}&img.id=${item.id}">
            			<img src="images!img.do?img.id=${item.id}" height="250" border="0" title="${item.imgtype.fullname}" alt="${item.info}"/></a>
            		</div>
            		<div>
            			<a href="images!img.do?img.id=${item.id}">原图</a>
            			<a href="images!update.do?img.id=${item.id}">修改</a>
            			<input type="button" value="删除" onclick="del(${item.id},${status.index})"/>
		            </div>
            	</div>
				</li>
			</c:forEach>
        	</ul></td></tr>
			</table>
    </div>
</div>
</body>
<script language="javascript" type="text/javascript" >
function del(id,xh){
	var url = "images!del.do" ;
	$.post(url, 
		{'img.id': id},
		function(data) {
			//alert(data) ;
			if(data==1){
				//alert("删除成功！") ;
				$("#list_"+xh).remove() ;
			}
		});
	
}
</script>
</html>
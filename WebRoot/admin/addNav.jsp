<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加新闻类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
	

  </head>
  
  <body>
  <div class="main-frame">
    <jsp:include page="top.jsp"></jsp:include> 
    <jsp:include page="left.jsp"></jsp:include>
    <div class="right">
   <div class="admin">
		    <h1 class="title">添加新闻类别<a href="admin/navList.jsp" class="back-btn">返回</a></h1>
		    <form action="admin/insertNav" id="frm" method="post">
	<table>
		    <tr><td>新闻类别：</td><td><input id="nav_name" name="nav_name" autocomplete="off" maxlength="50" type="text"/></td><td id="err_nav_name"></td></tr>
		    <tr><td>排序权重：</td><td><input id="nav_feight" name="nav_feight" autocomplete="off" maxlength="10" type="text"/></td><td id="err_nav_feight"></td></tr>
		    <tr><td></td><td><a class="btn" onclick="startPost();" href="javascript:void(0)">保存</a></td></tr>
    </table>
    </form>
    </div>
    </div>
    </div>
    <jsp:include page="../footer.jsp"></jsp:include> 
    <script type="text/javascript" src="<%=basePath%>js/nav.js"></script>
  </body>
</html>

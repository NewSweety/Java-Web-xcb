<%@page import="com.action.bean.ActionBean,com.entity.Nav"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ActionBean actionBean=new  ActionBean();
String nav_id=request.getParameter("nav_id");
if(nav_id==null||"".equals(nav_id)){
	 response.sendRedirect("navList.jsp");
	 return;
}
Nav nav=actionBean.queryNavById(nav_id);
 if(nav==null){
	 response.sendRedirect("navList.jsp");
	 return;
 }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改新闻类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/mlb/css/style.css">
	

  </head>
  
  <body>
   
    
   <div class="admin">
		    <form action="admin/editNav" id="frm" method="post">
		    <input type="hidden" value="<%=nav.getNav_id()%>" name="nav_id">
	<table>
		    <tr><td>新闻类别：</td><td><input id=nav_name name=nav_name autocomplete="off" maxlength="50" type="text" value="<%=nav.getNav_name()%>"/></td><td id="err_nav_name"></td></tr>
		    <tr><td>排序权重：</td><td><input id=nav_feight name=nav_feight autocomplete="off" maxlength="10" type="text" value="<%=nav.getNav_feight()%>"/></td><td id="err_nav_feight"></td></tr>
		    <tr><td></td><td><a class="btn" onclick="startPost();" href="javascript:void(0)">保存</a></td></tr>
    </table>
    </form>
    </div>
   
     <script type="text/javascript" src="<%=basePath%>js/nav.js"></script>
  </body>
</html>

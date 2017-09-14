<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <div class="left-menu">
    <h1 class="title">导航菜单</h1>
   <ul>
       <li><a href="admin/managerList.jsp">用户管理</a><li>
       <li><a href="admin/navList.jsp">类别管理</a><li>
       <li><a href="admin/articleList.jsp">新闻管理</a><li>
        <li><a href="admin/exit.jsp">退出系统</a><li>
   </ul>
 </div>
<%@page import="com.entity.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Article article=(Article)request.getAttribute("article");
if(article==null){
	response.sendRedirect("index.html");
	return;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=article.getArticle_title() %></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=article.getArticle_title() %>">
	<meta http-equiv="description" content="<%=article.getArticle_title() %>">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">

  </head>
  <body>
  <div>
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="nav.jsp"></jsp:include>
    </div>
    <div class="content-back">
      <div class="contentset">
          <a class="text-center"><h2 class="title"><%=article.getArticle_title() %></h2></a>
          <a class="text-center"><p class="date">发布时间:<%=article.getArticle_data()%></p></a>
          <div class="content">
                 <%=article.getArticle_content() %>
          </div>
      </div>
      </div>
      <div style="margin-top:200px;">
    		<jsp:include page="footer.jsp"></jsp:include> 
    </div>
  </body>
</html>

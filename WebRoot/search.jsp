<%@page import="com.entity.Nav"%>
<%@page import="com.entity.Article"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List <Article>lastArticles=(List)request.getAttribute("lastArticles");
List <Map>articles=(List)request.getAttribute("articles");
int rows=(Integer)request.getAttribute("rows");
int p=(Integer)request.getAttribute("p");
String searchTxt=request.getAttribute("searchTxt").toString();

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文章查询-<%=searchTxt%></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=searchTxt %>">
	<meta http-equiv="description" content="<%=searchTxt %>">
	<link rel="stylesheet" type="text/css" href="http://<%=searchTxt%>css/style.css">

  </head>
  <body>
    <jsp:include page="top.jsp"></jsp:include>
    <jsp:include page="nav.jsp"></jsp:include>
      <div class="w">
          <div class="left-box">
              <h2 style="color:white; text-align:center;">最新发布</h2>
              <ul>
              <%for(Article a:lastArticles){ %>
                 <li><a href="item.html?article_id=<%=a.getArticle_id() %>" target="_blank" title="<%=a.getArticle_title() %>"><%=a.getArticle_title() %></a></li>
                 <%} %>
              </ul>
          </div>
          <div class="right-box">
               <h2 style="text-align:center;">共为你找到<%=rows%>条记录</h2>
               <ul>
                <%
                int i=10*p;
                int totalPages=(rows%10==0?rows/10:(rows/10+1));
                for(Map map:articles){ %>
                 <li><a href="item.html?article_id=<%=map.get("article_id") %>" target="_blank" title="map.get(article_title)"><%=map.get("order_no")%>. <%=map.get("article_title") %></a><span><%=map.get("article_data") %></span></li>
                <%} %>
                </ul>
             <p class="page">
                    <span>共有<%=rows %>条记录</span><span>当前是第<%=p+1%>页</span>
		       <%if(p>0) {%>
		       <a href="javascript:void(0)" onclick="go2Page(0)">第一页</a>
		       <a href="javascript:void(0)" onclick="go2Page(<%=p-1 %>)">上一页</a>
		       <%} %>
		       <%if(p<totalPages-1){ %>
		       <a href="javascript:void(0)" onclick="go2Page(<%=p+1 %>)">下一页</a>
		       <a href="javascript:void(0)" onclick="go2Page(<%=totalPages-1 %>)">最后一页</a>
		       <%} %>
		       <span>共<%=totalPages%>页</span>
		       <%if(totalPages>1) { %>
		       <span>转到第
		            <select onchange="go2Page(this.value)">
		               <%for(int j=0;j<totalPages;j++){%>
		               <option value="<%=j%>"<%=j==p?"selected='selected'":""%>><%=j+1%></option>
		               <%} %>
		            </select>
		                   页
		       </span>
		       <%} %>
              </p>
                
              
          </div>
      </div>
    <jsp:include page="footer.jsp"></jsp:include>
    <script type="text/javascript">
    function go2Page(n){
    	document.getElementById("p").value=n;
    	document.getElementById("submit").click();
    };
    </script> 
  </body>
</html>

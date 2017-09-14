package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.entity.Nav;
import com.sql.SqlHelper;
import com.tools.MyFuns;

public class SearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  String searchTxt=request.getParameter("searchTxt");
		  searchTxt =MyFuns.convert2utf8(searchTxt);
		  if(searchTxt=="" || "".equals(searchTxt)){
			  response.sendRedirect("index.html");
			  return;
		  }
		  int p=MyFuns.string2Int(request.getParameter("p"));
		  SqlHelper sqlHelper=new SqlHelper();
		   //获取导航
		  java.util.List<Nav> list=sqlHelper.queryNavAll();
		   //获取最新发布的新闻信息
		  List <Article>lastArticles =sqlHelper.queryLastArticles();
		  //根据关键词做模糊查询
		  List <Map>articles=sqlHelper.queryArticleMapByPage(p, null,searchTxt );
		  //根据关键词查询出总的记录数
		  int rows=sqlHelper.queryArticleCount(null, searchTxt);
		  sqlHelper.desttroy();
		  request.setAttribute("navList",         list        );
		  request.setAttribute("lastArticles",    lastArticles);
		  request.setAttribute("articles",        articles    );
		  request.setAttribute("p",               p           );
		  request.setAttribute("rows",            rows        );
		  request.setAttribute("searchTxt",       searchTxt   );
		  request.getRequestDispatcher("search.jsp").forward(request, response);
		  
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

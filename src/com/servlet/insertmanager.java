package com.servlet;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.sql.SqlHelper;
import com.tools.MyFuns;
public class insertmanager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public insertmanager() {
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
		doPost(request,response);}
		/*8String manager_id=request.getParameter("manager_id");
		String manager_name=request.getParameter("manager_name");
		String manager_pwd=request.getParameter("manager_pwd");
		manager Manager=new manager();
		Manager.setManager_id(manager_id);
		Manager.setManager_name(manager_name);
		Manager.setManager_pwd(manager_pwd);
		if(Manager.getManager_id()==null||"".equals(Manager.getManager_id())
			||Manager.getManager_name()==null||"".equals(Manager.getManager_name())
			||Manager.getManager_pwd()==null||"".equals(Manager.getManager_pwd())
		 ){
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE></TITLE></HEAD>");
			out.println("  <BODY>");
			out.print("    璇锋妸淇℃伅杈撳叆瀹屾暣銆�a href=\"addmanager.jsp\">杩斿洖閲嶆柊杈撳叆銆�/a> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		response.setCharacterEncoding("utf-8");
		String manager_id=request.getParameter("manager_id");
		String manager_name=MyFuns.convert2utf8(request.getParameter("manager_name"));
		String manager_pwd=request.getParameter("manager_pwd");
		Manager manager = new Manager();
		manager.setManager_id(manager_id);
		manager.setManager_name(manager_name);
		manager.setManager_pwd(manager_pwd);
		if(manager.getManager_id()==null||"".equals(manager.getManager_id())
			||manager.getManager_name()==null||"".equals(manager.getManager_name())
			||manager.getManager_pwd()==null||"".equals(manager.getManager_pwd())
		 ){
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE></TITLE></HEAD>");
			out.println("  <BODY>");
			out.print(" <a href=\"addmanager.jsp\">返回</a> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		else{
			SqlHelper sqlHelper=new SqlHelper();
			if(sqlHelper.queryManagerById(manager.getManager_id())!=null){
				response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE></TITLE></HEAD>");
			out.println("  <BODY>");
			out.print(" <a href=\"addmanager.jsp\">添加成功</a> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			sqlHelper.desttroy();
			}else{
				boolean b=sqlHelper.insertmanager(manager);
				//sqlHelper.desttroy();
				if(b){
				response.sendRedirect("managerList.jsp");}
			}
			//boolean b=sqlHelper.insertmanager(manager);
			//System.out.println(b+"------------------");
			//if(b){
				//System.out.println("================");
				//response.sendRedirect("managerList.jsp");
			//}
			//sqlHelper.desttroy();//
		}
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

package com.sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Article;
import com.entity.ArticlePojo;
import com.entity.Manager;
import com.entity.Nav;


import DB.db;

public class SqlHelper {
	private Connection conn=null;
	private int perPage=10;
	public SqlHelper() {
		// TODO Auto-generated constructor stub
		 conn = db.getConnection();
	}
	public void desttroy(){
		if(conn!=null)
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	public Manager queryManagerById(String manager_id){
		String sql="select * from manager where manager_id=?";
		Manager manager=null;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,manager_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				manager=new Manager();
				manager.setManager_id(rs.getString("manager_id"));
				manager.setManager_name(rs.getString("manager_name"));
				manager.setManager_pwd(rs.getString("manager_pwd"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return manager;
	}
	public Manager queryManagerByIdAndPwd(Manager m){
		String sql="select * from manager where manager_id=? and manager_pwd=?";
		Manager manager=null;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,m.getManager_id());
			ps.setString(2,m.getManager_pwd());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				manager=new Manager();
				manager.setManager_id(rs.getString("manager_id"));
				manager.setManager_name(rs.getString("manager_name"));
				manager.setManager_pwd(rs.getString("manager_pwd"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return manager;
	}
	public boolean insertmanager(Manager manager){
		String sql="insert into manager( manager_id,manager_name,manager_pwd) values(?,?,?)";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getManager_id());
			ps.setString(2,manager.getManager_name());
			ps.setString(3,manager.getManager_pwd());
			ps.executeUpdate();
			a=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public boolean insertNav(Nav nav){
		String sql="insert into nav( nav_id,nav_name,nav_feight) values(?,?,?)";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,nav.getNav_id()    );
			ps.setString(2,nav.getNav_name()  );
			ps.setInt(3,nav.getNav_feight());
			ps.executeUpdate();
			a=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public boolean updatemanager_name(Manager manager){
		String sql="update manager set manager_name=? where manager_id=?";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getManager_name());
			ps.setString(2,manager.getManager_id());
			ps.executeUpdate();
			a=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
		
	}
	public boolean updatemanager_pwd(Manager manager){
		String sql="update manager set manager_pwd=? where manager_id=?";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getManager_pwd());
			ps.setString(2,manager.getManager_id());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
		
	}
	public boolean updatemanagerpwdAndname(Manager manager){
		String sql="update manager set manager_pwd=?,manager=? where manager_id=?,manager_name";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getManager_pwd());
			ps.setString(2,manager.getManager_name());
			ps.setString(3,manager.getManager_id());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public List<Manager>querymanagerAll(){
		List<Manager> list=new ArrayList();
		String sql="select manager_id,manager_name from manager";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Manager manager=new Manager();
				manager.setManager_id(rs.getString("manager_id"));
				manager.setManager_name(rs.getString("manager_name"));
				list.add(manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean  deleteManager(Manager manager) {
		String sql="delete from manager where manager_id=?";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, manager.getManager_id());
		    ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	   return a;
	}
	public List<Nav> queryNavAll() {
		List <Nav>list=new ArrayList();
		String sql="select nav_id,nav_name,nav_feight from nav order by nav_feight asc";
        try{
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ResultSet rs=ps.executeQuery();
        	while(rs.next()){
        		Nav nav=new Nav();
        		nav.setNav_id(rs.getString("nav_id"));
        		nav.setNav_name(rs.getString("nav_name"));
        		nav.setNav_feight(rs.getInt("nav_feight"));
        		list.add(nav);
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }	
        return list;
	}
	public Nav queryNavById(String nav_id) {
		String sql="select nav_id,nav_name,nav_feight from nav where nav_id=?";
		Nav nav=null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nav_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				nav=new Nav();
				nav.setNav_id(rs.getString("nav_id"));
				nav.setNav_name(rs.getString("nav_name"));
				nav.setNav_feight(rs.getInt("nav_feight"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nav;
	}
	public boolean updateNav(Nav nav) {
		String sql="update nav set nav_name=?,nav_feight=? where nav_id=?";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,nav.getNav_name());
			ps.setInt(2,nav.getNav_feight());
			ps.setString(3,nav.getNav_id());
			ps.executeUpdate();
			a=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public void deleteNav(Nav nav) {
		String sql="delete from nav where nav_id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nav.getNav_id());
		    ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public List<Article> queryArticleByNav_id(String nav_id) {
		String sql="select article_id,article_title,article_content,article_data,nav_id from article where nav_id=? order by article_data desc";
		List <Article>list=new ArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nav_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Article article=new Article();
				article.setArticle_content(rs.getString("article_content"));
				article.setArticle_data(rs.getString("article_data"));
				article.setArticle_title(rs.getString("article_title"));
				article.setArticle_id(rs.getString("article_id"));
				list.add(article);
			}
		}catch(Exception e){
		   e.printStackTrace();	
		}
	
		return list;
	}
	public List<Article> queryArticleByNav_id4Index(String nav_id) {
		String sql="select top 10 article_id,article_title,article_data,nav_id from article where nav_id=? order by article_data desc";
		List <Article>list=new ArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nav_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Article article=new Article();
				article.setArticle_data(rs.getString("article_data"));
				article.setArticle_title(rs.getString("article_title"));
				article.setArticle_id(rs.getString("article_id"));
				list.add(article);
			}
		}catch(Exception e){
		   e.printStackTrace();	
		}
	
		return list;
	}
	public boolean insertArticle(Article article) {
		String sql="insert into article(article_title,article_content,article_data,nav_id,article_id)values(?,?,?,?,?)";
		boolean a=false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getArticle_title());
			ps.setString(2,article.getArticle_content());
			ps.setString(3,article.getArticle_data());
			ps.setString(4,article.getNav_id());
			ps.setString(5,article.getArticle_id());
			ps.executeUpdate();
			a=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public List<ArticlePojo> queryArticle() {
		/*String sql="select article_id,article_title,article_data,nav_name from article,nav where article.nav_id = nav.nav_id order by article_data desc";*/
		String sql="select article.*,nav.* from article,nav where article.nav_id = nav.nav_id order by article_data desc";
		List <ArticlePojo>list=new ArrayList<ArticlePojo>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ArticlePojo art=new ArticlePojo();
				art.setArticle_title(rs.getString("article_title"));
				art.setArticle_data(rs.getString("article_data"));
				art.setArticle_id(rs.getString("article_id"));
				art.setNav_name(rs.getString("nav_name"));
				list.add(art);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryArticleMap() {
		/*String sql="select article_id,article_title,article_data,nav_name from article,nav where article.nav_id = nav.nav_id order by article_data desc";*/
		String sql="select article.*,nav.* from article,nav where article.nav_id = nav.nav_id order by article_data desc";
		List <Map>list=new ArrayList<Map>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap();
				map.put("article_title",rs.getString("article_title"));
				map.put("article_id",rs.getString("article_id"));
				map.put("article_data",rs.getString("article_data"));
				map.put("nav_name",rs.getString("nav_name"));
			 list.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryArticleMapByPage(int p) {
		int start=p*perPage;
		String sql="select  top "+perPage+"  article_id,article_title,article_data,nav_name from article,nav where article_id not in(select top "+ perPage*p+"  article_id from article)  and article.nav_id=nav.nav_id order by article_data desc";
		List <Map>list=new ArrayList<Map>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map map=new HashMap();
				map.put("article_title",rs.getString("article_title"));
				map.put("article_id",rs.getString("article_id"));
				map.put("article_data",rs.getString("article_data"));
				map.put("nav_name",rs.getString("nav_name"));
			 list.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<Map> queryArticleMapByPage(int p,String nav_id,String article_title) {
		int start = p*perPage;
		String sql="select  top "+perPage+"  article_id,article_title,article_data,nav_name from article,nav where article_id not in(select top "+ perPage*p+"  article_id from article)  and article.nav_id=nav.nav_id";
		if(nav_id!=null && !"".equals(nav_id)){
			sql+=" and nav.nav_id=? ";
		}
		if(article_title!=null && !"".equals(article_title)){
			sql+=" and article_title like ? ";
		}
		sql+=" order by article_data desc";
			List <Map>list = new ArrayList();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				int pos = 1;
				if(nav_id!=null && !"".equals(nav_id)){
					ps.setString(1, nav_id);
					pos=2;
				}
				if( article_title!=null && !"".equals(article_title)){
					ps.setString(pos, "%"+article_title+"%");
				}
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Map map=new HashMap();
					map.put("article_data", rs.getString("article_data"));
					map.put("article_title", rs.getString("article_title"));
					map.put("article_id", rs.getString("article_id"));
					map.put("nav_name", rs.getString("nav_name"));
					
					list.add(map);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	public int queryArticleCount(String nav_id,String article_title){
		String sql="select count(*) from article";
		int pos=0;
		boolean f1=nav_id!=null&&!"".equals(nav_id);
		if(f1){
			sql="select count(*) from article,nav "
			        + "where article.nav_id = nav.nav_id and nav.nav_id = ?";
			pos=1;
		}
		boolean f2=article_title!=null&&!"".equals(article_title);
		if(f2){
			sql+=(pos>0?" and ":" where ") +" article_title like ? ";
			pos+=1;
		}
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			if(f1){
				ps.setString(1, nav_id);
			}
			if(f2){
				ps.setString(pos, "%"+article_title+"%");
			}
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public int queryArticleCount(){
		String sql="select count(*) from article";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public Article queryArticleById(String article_id) {
		String sql="select article_id,article_title,article_data,article_content,nav_id " 
				+ "from article " 
				+ "where article_id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, article_id);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()){
		    	Article a=new Article();
		    	a.setArticle_content(rs.getString("article_content"));
		    	a.setArticle_data(rs.getString("article_data"));
		    	a.setArticle_title(rs.getString("article_title"));
		    	a.setArticle_id(article_id);
		    	a.setNav_id(rs.getString("nav_id"));
		    	return a;
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public boolean editArticle(Article article) {
		String sql="update article " 
				   + "set article_title=?,article_data=?,article_content=?,nav_id=? " 
				   + "where article_id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getArticle_title());
			ps.setString(2, article.getArticle_data());
			ps.setString(3, article.getArticle_content());
			ps.setString(4, article.getNav_id());
			ps.setString(5, article.getArticle_id());
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteNewsById(String article_id) {
		String sql="delete from article where article_id=?";
		try{
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1,article_id);
			 ps.executeUpdate();
			 return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public List<Article> queryLastArticles() {
		String sql="select article_id,article_title from article order by article_data desc limit 0,10";
		List list= new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Article a=new Article();
				a.setArticle_id(rs.getString("article_id"));
				a.setArticle_title(rs.getString("article_title"));
				list.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}


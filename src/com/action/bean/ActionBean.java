package com.action.bean;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Article;
import com.entity.ArticlePojo;
import com.entity.Manager;
import com.entity.Nav;
import com.sql.SqlHelper;

public class ActionBean {
  public String queryManagerAll(){
	  SqlHelper sqlHelper=new SqlHelper();
	  List <Manager>list=sqlHelper.querymanagerAll();
	  String tableHtml="";
	  int i=1;
	  for(Manager manager:list){
		  tableHtml+="<tr><td><input type=\"radio\" name=\"rad\" autocomplete=\"off\" value=\""+manager.getManager_id()+"\"/></td><td class=\"text-center\">"+(i++)+"</td><td class=\"text-center\">"+manager.getManager_id()+"</td><td>"+manager.getManager_name()+"</td></tr>";
	  }
	  sqlHelper.desttroy();
	  return  tableHtml;
  }
  public Manager queryManagerById(String manager_id){
	  SqlHelper sqlHelper=new SqlHelper();
	  Manager manager=sqlHelper.queryManagerById(manager_id);
	  sqlHelper.desttroy();
	  return manager;
  }
  public String queryNavAll(){
	  SqlHelper sqlHelper=new SqlHelper();
	  List <Nav>list=sqlHelper.queryNavAll();
	  String tableHtml="";
	  int i=1;
	  for(Nav nav:list){
		  tableHtml+="<tr><td><input type=\"radio\" name=\"rad\" autocomplete=\"off\" value=\""+nav.getNav_id()+"\"/></td><td class=\"text-center\">"+(i++)+"</td><td class=\"text-center\">"+nav.getNav_name()+"</td><td style='text-align:center'>"+nav.getNav_feight()+"</td></tr>";
	  }
	  sqlHelper.desttroy();
	  return  tableHtml;
  }
  public List<Nav> queryNavList(){
	  SqlHelper sqlHelper=new SqlHelper();
	  List <Nav>list=sqlHelper.queryNavAll();
	  sqlHelper.desttroy();
	  return  list;
  }
   public Nav queryNavById(String nav_id){
	   SqlHelper sqlHelper =new SqlHelper();
	   Nav nav=sqlHelper.queryNavById(nav_id);
	   sqlHelper.desttroy();
	   return nav;
   }
   public List<ArticlePojo> queryArticle(){
	   SqlHelper sqlHelper =new SqlHelper();
	   List<ArticlePojo> list=sqlHelper.queryArticle();
	   sqlHelper.desttroy();
	   return list;
   }
   public List<Map> queryArticleMap(){
	   SqlHelper sqlHelper =new SqlHelper();
	   List list=sqlHelper.queryArticleMap();
	   sqlHelper.desttroy();
	   return list;
  }
   public List<Map> queryArticleMapByPage(int p){
	   SqlHelper sqlHelper =new SqlHelper();
	   List list=sqlHelper.queryArticleMapByPage(p);
	   sqlHelper.desttroy();
	   return list;
  }
   public Map queryArticleByPage(int p){
	   Map map=new HashMap();
	   SqlHelper sqlHelper =new SqlHelper();
	   map.put("list", sqlHelper.queryArticleMapByPage(p));
	   map.put("rows",sqlHelper.queryArticleCount());
	   map.put("navList",sqlHelper.queryNavAll());
	   sqlHelper.desttroy();
	   return map;
  }
   public Map queryArticleByPage(int p,String nav_id,String article_title){
	   Map map=new HashMap();
	   SqlHelper sqlHelper =new SqlHelper();
	   map.put("list", sqlHelper.queryArticleMapByPage(p,nav_id,article_title));
	   map.put("rows",sqlHelper.queryArticleCount(nav_id,article_title));
	   map.put("navList",sqlHelper.queryNavAll());
	   sqlHelper.desttroy();
	   return map;
  }
   public Map queryArticleMap4Edit(String article_id){
	   Map map=new HashMap();
	   SqlHelper sqlHelper=new SqlHelper();
	   map.put("navList", sqlHelper.queryNavAll());
	   map.put("article", sqlHelper.queryArticleById(article_id));
	   sqlHelper.desttroy();
	   return map;
   }
}
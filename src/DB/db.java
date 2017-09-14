package DB;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class db {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/sweety_db?"
                + "user=sweety&password=tt736974&useUnicode=true&characterEncoding=UTF8";
	private static String user="sweety";
	private static String pwd="tt123456";

	@Test
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName(driver);
			System.out.println("成功加载MySQL驱动程序");
			conn=DriverManager.getConnection(url);
			System.out.println("连接数据库成功");
		}catch(Exception e){
			System.out.println("连接数据库失败");
			//e.printStackTrace();
			}
		return conn;
	}
}

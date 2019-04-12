package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JDBCutil2 {

	public static DataSource ds=null;
	
	static {
		try {
			Properties p=new Properties();
			//获取字节码目录
			String path = JDBCutil2.class.getClassLoader().getResource("db2.properties").getPath();
			FileInputStream in = new FileInputStream(path);
			System.out.println(path);
			p.load(in);
			ds=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return  ds;
	}
	
	//获取连接
	public static Connection getcon() {
		try {
			
			return ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}
	
	public static void close(Connection sqlconnection,Statement st,ResultSet Query)
	{
		if (Query != null) {

			try {
				Query.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sqlconnection != null) {
			try {
				sqlconnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

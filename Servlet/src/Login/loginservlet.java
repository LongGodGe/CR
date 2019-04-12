package Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.user;
import utils.JDBCutil2;


@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	    //连接数据库
		
		QueryRunner queryRunner = new QueryRunner(JDBCutil2.getDataSource());
		String sql="select * from user where name=? and pwd=?";
		user query=null;
		try {
			query = queryRunner.query(sql,new BeanHandler<user>(user.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(query !=null) {
			response.getWriter().write("Login Success ="+query.getName());
		}
		else {
			response.getWriter().write("Login fail");
		}
	}

}

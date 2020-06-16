package kr.or.kpc.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kpc.dao.MemberDao;
import kr.or.kpc.dto.MemberDto;
//http://localhost:8080/hello.kpc?id=syh1011&pwd=1234
@WebServlet("/member.kpc")

public class MemberServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) 
	throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>hello servlet</title>");
		out.println("	</head>");
		out.println("	<body>");
		MemberDao dao = MemberDao.getInstance();
		try {
			ArrayList<MemberDto> list = dao.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>");
		out.println("</tr>");
		
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		out.println("<h1>");
		out.println("id : "+id , " pwd : "+pwd);
		out.println("</h1>");
	
		
		
	}
	
}

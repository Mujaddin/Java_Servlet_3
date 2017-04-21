package serveltPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is a new sample servlet by Muhammad Jamaluddin", urlPatterns = { "/Servlet" })
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	List<Student> listStudents = new ArrayList<Student>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id")!=null){
			Integer id = Integer.parseInt(request.getParameter("id"));
			listStudents = listStudents.stream().filter(s->!s.getId().equals(id)).collect(Collectors.toList());
		}
		request.getSession().setAttribute("listStudent", listStudents);
		request.getRequestDispatcher("/hello.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(listStudents.size()==0){
			Student student= new Student(request.getParameter("name"), 1);
			listStudents.add(student);
		}else{
			Student student= new Student(request.getParameter("name"), listStudents.get(listStudents.size()-1).getId()+1);
			listStudents.add(student);
		}
		
		request.getSession().setAttribute("listStudent", listStudents);
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
		
	}
	
	
	

}

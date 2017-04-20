package serveltPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class ExerciseServlet
 */
@WebServlet(description = "This is exercise for get json object at get output", urlPatterns = { "/ExerciseServlet" })
@MultipartConfig
public class ExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	java.util.List<Student> students;
	java.util.List<Student> studentsfilter;
	String params;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		students.add(new Student("jamal", 20));
		students.add(new Student("uddin", 2));
		students.add(new Student("jamaluddin", 3));
		students.add(new Student("andy malarangen", 22));
		students.add(new Student("Budi sudarsono", 24));
		
		PrintWriter print = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < students.size(); i++) {
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("nameju", students.get(i).getName());
			jsonObject1.put("id", students.get(i).getId());
			jsonArray.add(jsonObject1);
		}

		jsonObject.put("data", jsonArray);
		jsonObject.put("Message", "Hello From Server");
		response.setContentType("Application/json");
		print.print(jsonObject.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		saveQuestion(request);
		students.add(new Student("jamal", 20));
		students.add(new Student("uddin", 2));
		students.add(new Student("jamaluddin", 3));
		students.add(new Student("andy malarangen", 22));
		students.add(new Student("Budi sudarsono", 24));
		studentsfilter=students.stream().filter(s->s.getName().contains(params)).collect(Collectors.toList());
		PrintWriter print = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < studentsfilter.size(); i++) {
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("nameju", studentsfilter.get(i).getName());
			jsonObject1.put("id", studentsfilter.get(i).getId());
			jsonArray.add(jsonObject1);
		}

		jsonObject.put("data", jsonArray);
		jsonObject.put("Message", "Hello From Server");
		response.setContentType("Application/json");
		print.print(jsonObject.toString());
	}

	public String saveQuestion(HttpServletRequest request) {
		String searchParams=request.getParameter("name");
		System.out.println(searchParams);
		this.params=searchParams;
		return searchParams;
	}
}

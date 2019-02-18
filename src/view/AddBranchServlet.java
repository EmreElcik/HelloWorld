package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BranchesController;
import entity.Branches;

/**
 * Servlet implementation class AddBranchServlet
 */
@WebServlet("/AddBranchServlet")
public class AddBranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBranchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				+"<body bgcolor=\"#C0C0C0\">"
				+ message
				+ "<form method='POST' action='AddBranchServlet'>"
				+ "<table align=\"center\" border=\"0\" style=\"width:80%\"> "
				+ "<tr>"
				+ "<td> BranchId: </td>"
				+ "<td> "+" <input type=\"text\" name=\"ID\">"+"</td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td> BranchName: </td>"
				+ "<td> "+" <input type=\"text\" name=\"BRANCH\">"+"</td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td></td>"
				+ "<td> "+" <input type=\"submit\" name=\"submit\" value=\"Ekle\" >"+"</td>"
				+ "</tr>");
		out.println("</table>"
				+ "</form>"
				+ "</body>"
				+ "</html>");		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Hi there!");
			int id = Integer.parseInt(request.getParameter("ID"));
			String branch = request.getParameter("BRANCH");
			
			System.out.println("ID: "+id);
			System.out.println("BRANCH: "+branch);
			
			BranchesController bc = new BranchesController();
			Branches b = new Branches();
			b.setBranchId(id);
			b.setBranchName(branch);			
			bc.saveBranch(b);
			message = "Baþarýlý!";
		} catch (Exception e) {
			message = "Hata Oluþtu!";
		}
		

		
		doGet(request, response);
	}

}

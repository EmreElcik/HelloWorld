package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BranchesController;
import entity.Branches;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BranchesController bc = new BranchesController();
		List<Branches> liste = bc.getAll();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				+"<body bgcolor=\"#C0C0C0\">"
				+ "<a href='AddBranchServlet'><img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfSQlnchZxsuNAbPKhA8wXukAPB6ANIoHLttHFmBGhbFQzQvSy'/></a>"
				+ "<table align=\"center\" border=\"1\" style=\"width:80%\"> "
				+ "<tr>"
				+ "<td> BranchId </td>"
				+ "<td> BranchName </td>"
				+ "<td> Op </td>"
				+ "</tr>");
		for (Branches b : liste) {
			/**out.println(b.getBranchId());
			out.println(b.getBranchName());*/
			
			out.println("<tr>"
					+ "<td>"
					+ b.getBranchId()
					+ "</td>"
					+ "<td>"
					+ b.getBranchName()
					+ "</td>"					
					+ "<td>"
					+ "U  D"
					+ "</td>"			
					+ "</tr>");
		}
		
		out.println("</table>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

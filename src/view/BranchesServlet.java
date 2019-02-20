package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BranchesController;
import entity.Branches;

/**
 * Servlet implementation class BranchesServlet
 */
@WebServlet("/BranchesServlet")
public class BranchesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BranchesController bc = new BranchesController();
		
		String process = request.getParameter("process");
		String branchId = request.getParameter("branchIdParam");
		
		if ("delete".equals(process)) {
			bc.deleteBranchesByBranchId(Integer.valueOf(branchId));
		}
		
		List<Branches> liste = bc.getAll();
		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				+"<body bgcolor=\"#C0C0C0\">"
				+ "<a href='AddBranchServlet'><img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfSQlnchZxsuNAbPKhA8wXukAPB6ANIoHLttHFmBGhbFQzQvSy'/></a>"
				+ "<table align=\"center\" border=\"1\" style=\"width:80%\"> "
				+ "<tr>"
				+ "<td> BranchId </td>"
				+ "<td> BranchName </td>"
				+ "<td> OP </td>"
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
						+ "<table>"
						+ "<tr>"
						+ "<td align=\"left\">"
						+"<form method=\"GET\" action=\"http://localhost:8080/HelloWorld/UpdateBranchServlet\">"
						+ "<input type=\"hidden\" name=\"branchIdParam\" value=\""+b.getBranchId()+"\">" 
						+ "<input type=\"submit\" value=\"U\">" 
						+ "</form>"
						+ "</td>"
						+ "<td align=\"right\">"
						+"<form method=\"POST\" action=\"http://localhost:8080/HelloWorld/BranchesServlet\">"
						+ "<input type=\"hidden\" name=\"branchIdParam\" value=\""+b.getBranchId()+"\">"
						+ "<input type=\"hidden\" name=\"process\" value=\"delete\">"
						+ "<input type=\"submit\" value=\"D\">" 
						+ "</form>"
						+ "</td>"
						+ "</tr>"
						+ "</table>"
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
		String branchIdParam = request.getParameter("branchIdParam");
		System.out.println(branchIdParam);
		doGet(request, response);
		
	}

}

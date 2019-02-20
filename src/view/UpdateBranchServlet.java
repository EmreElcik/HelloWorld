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
 * Servlet implementation class UpdateBranchServlet
 */
@WebServlet("/UpdateBranchServlet")
public class UpdateBranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBranchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BranchesController bc = new BranchesController();
		
		String branchId = request.getParameter("branchIdParam");
		
		
		Branches branch = new Branches();
		if (branchId != null &&  Integer.valueOf(branchId) > 0) {
			branch = bc.getBranchesByBranchId(Integer.valueOf(branchId));			
		}

		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				+"<body bgcolor=\"#C0C0C0\">"
				+ message
				+ "<form method='POST' action='UpdateBranchServlet'>"
				+ "<table align=\"center\" border=\"0\" style=\"width:80%\"> "
				+ "<tr>"
				+ "<td> BranchId: </td>"
				+ "<td> <input type=\"text\" name=\"ID\" value=\""+branchId+"\" readonly>" + "</td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td> BranchName: </td>"
				+ "<td> <input type=\"text\" name=\"BRANCH\" value=\""+branch.getBranchName()+"\">" + "</td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td></td>"
				+ "<td> "+" <input type=\"submit\" name=\"submit\" value=\"Güncelle\" >"+"</td>"
				+ "<input type=\"hidden\" name=\"process\" value=\"update\">"
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
			System.out.println("Hi there, Updating!");
			
			System.out.println("ID1: "+request.getParameter("ID"));
			
			int id = Integer.parseInt(request.getParameter("ID"));
			String branch = request.getParameter("BRANCH");
			
			System.out.println("ID2: "+id);
			System.out.println("BRANCH: "+branch);
			
			BranchesController bc = new BranchesController();
			Branches b = new Branches();
			b.setBranchId(id);
			b.setBranchName(branch);			
			bc.updateBranch(b);
			message = "Baþarýlý!";
			response.sendRedirect(request.getContextPath() + "/BranchesServlet?code=success");
		} catch (Exception e) {
			message = "Hata Oluþtu!";
		}
		

		
		doGet(request, response);
	}

}

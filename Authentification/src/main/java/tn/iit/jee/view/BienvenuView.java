package tn.iit.jee.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tn.iit.jee.model.Utilisateur;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BienvenuView
 */
public class BienvenuView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out= response.getWriter();
		out.println("Bienvuue Mr/Mme"+((Utilisateur) session.getAttribute("curentUser")).getNom()+" "+
		((Utilisateur) session.getAttribute("curentUser")).getPrenom()+"<br>");
		out.println("Vos paramètres sont : :<br>");
		out.println("Login :"+request.getParameter("login")+"<br>");
		out.println("Mot de passe :"+request.getParameter("pwd")+"<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

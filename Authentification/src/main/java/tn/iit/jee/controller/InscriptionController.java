package tn.iit.jee.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tn.iit.jee.model.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class InscriptionController
 */
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		Utilisateur u = new Utilisateur(nom, prenom, login, pwd);
		ServletContext application = getServletContext();
		List<Utilisateur> listUsers = (List<Utilisateur>) application.getAttribute("tabUsers");
		if (listUsers == null) {
			listUsers = new ArrayList<Utilisateur>();
		}
		listUsers.add(u);
		application.setAttribute("tabUsers", listUsers);
		response.sendRedirect("AuthView");

	}

}

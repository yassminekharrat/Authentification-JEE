package tn.iit.jee.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tn.iit.jee.model.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
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

		// response.sendRedirect("AuthView?error=");
		String login = request.getParameter("login");
		String mp = request.getParameter("pwd");
//		if (login.equals("admin") && mp.equals("123")) {
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/BienvenuView");
//			rd.forward(request, response);
//		} else {
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AuthView");
//			rd.forward(request, response);
//		}
		ServletContext application = getServletContext();
		boolean trouve = false;
		HttpSession session = request.getSession();
		List<Utilisateur> listUsers = (List<Utilisateur>) application.getAttribute("tabUsers");
		if (listUsers == null) {
			//Aucun utilisateur n'est inscrit
			request.setAttribute("erreur", "Aucun utilisateur n'est inscrit");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AuthView");
			rd.forward(request, response);
		}
		else
		{
			for (Utilisateur utilisateur : listUsers) {
				if(utilisateur.getLogin().equals(login)&&
						utilisateur.getPwd().equals(mp)) {
					trouve = true;
					session.setAttribute("curentUser", utilisateur);
					break;
					
				}
			}
			if(trouve) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/BienvenuView");
				rd.forward(request, response);
			}
			else
			{
				//erreur d'authentification
				request.setAttribute("erreur", "Erreur d'authentification");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AuthView");
				rd.forward(request, response);
			}
				
		}
		
	}

}

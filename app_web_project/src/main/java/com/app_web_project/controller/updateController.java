package com.app_web_project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.app_web_project.model.DAOService;

@WebServlet("/updateStudent")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!= null ) {
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");

			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
			rd.forward(request, response);

		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			if (session.getAttribute("email") != null) {
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");

				DAOService service = new DAOService();
				service.connectDb();
				service.updateRegistration(email, mobile);

				ResultSet result = service.getAllStudents();

				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}
}

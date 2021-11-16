package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mvc.bo.IUserBO;
import com.mvc.bo.UserBOImpl;
import com.mvc.exceptions.UserBusinessException;
import com.mvc.exceptions.UserExceptions;
import com.mvc.vo.RegisterVO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	IUserBO userBO = null;
	private static final Logger LOG = LogManager.getLogger(RegisterServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		userBO = new UserBOImpl();
		LOG.debug("From RegisterServlet Constructor");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.info("Inside of doPost Method");
		int userID = Integer.parseInt(request.getParameter("userid"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phoneNumber = request.getParameter("phoneno");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		RegisterVO registerVO = new RegisterVO();
		registerVO.setUserId(userID);
		registerVO.setFirstName(firstName);
		registerVO.setLastName(lastName);
		registerVO.setPhoneNumber(phoneNumber);
		registerVO.setEmail(email);
		registerVO.setPassword(password);

		try {
			boolean userRegistered = userBO.registerUser(registerVO);

			if (userRegistered) {
				dispatcher = request.getRequestDispatcher("./Home.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("./Failure.jsp");
				dispatcher.forward(request, response);
			}
		} catch (UserExceptions e) {
			dispatcher = request.getRequestDispatcher("./fatalError.jsp");
			request.setAttribute("error", e.getMessage());
			LOG.error("Error:" + e.getMessage());
			dispatcher.forward(request, response);
		} catch (UserBusinessException e) {
			dispatcher = request.getRequestDispatcher("./Register.jsp");
			request.setAttribute("error", e.getMessage());
			LOG.error("Error:" + e.getMessage());
			dispatcher.forward(request, response);
		}

	}

}

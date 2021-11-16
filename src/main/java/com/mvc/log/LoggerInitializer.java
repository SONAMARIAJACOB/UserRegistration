package com.mvc.log;

import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class LoggerInitializer Initializes the log4j logger.
 */
public class LoggerInitializer extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(LoggerInitializer.class);

	/**
	 * ServletConfig - servlet config object.
	 *
	 * @param config the config
	 * @throws ServletException the servlet exception
	 */

}

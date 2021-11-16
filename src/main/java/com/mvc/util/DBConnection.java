package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mvc.constants.SQLConstants;
import com.mvc.exceptions.UserExceptions;

/**
 * @author sona
 *
 */
public class DBConnection {

	private static Logger LOG = LogManager.getLogger(DBConnection.class);

	/**
	 * @return connection
	 * @throws UserExceptions
	 */
	public static Connection createConnection() throws UserExceptions {
		Connection con = null;
		final String METHOD_NAME = "createConnection()";

		LOG.info("Method Invoked:" + METHOD_NAME);

		try {
			Class.forName(SQLConstants.DRIVER_CLASS_NAME);
			con = DriverManager.getConnection(SQLConstants.DRIVER_URL, SQLConstants.DB_USER_NAME,
					SQLConstants.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			LOG.fatal(e.getMessage());
			throw new UserExceptions();
		} catch (SQLException e) {
			LOG.fatal(e.getMessage());
			throw new UserExceptions();
		}
		LOG.info("Response From The Method:" + METHOD_NAME + ":" + con);
		return con;

	}
}

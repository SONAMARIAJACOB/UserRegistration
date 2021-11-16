package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mvc.constants.SQLConstants;
import com.mvc.exceptions.UserExceptions;
import com.mvc.util.DBConnection;
import com.mvc.vo.RegisterVO;

/**
 * @author sona
 *
 */
public class RegisterDao implements IUserDAO {

	private static final Logger LOG = LogManager.getLogger(RegisterDao.class);

	@Override
	public boolean registerUser(RegisterVO registerVO) throws UserExceptions {
		final String METHOD_NAME = "registerUser";
		boolean userRegFlag = false;
		LOG.info("Method Invoked : " + METHOD_NAME + registerVO);

		try (Connection con = DBConnection.createConnection();
				PreparedStatement preparedStatement = con.prepareStatement(SQLConstants.USER_INSERT_QUERY);) {
			preparedStatement.setInt(1, registerVO.getUserId());
			preparedStatement.setString(2, registerVO.getFirstName());
			preparedStatement.setString(3, registerVO.getLastName());
			preparedStatement.setString(4, registerVO.getPhoneNumber());
			preparedStatement.setString(5, registerVO.getEmail());
			preparedStatement.setString(6, registerVO.getPassword());

			int i = preparedStatement.executeUpdate();

			if (i != 0)
				userRegFlag = true;
		} catch (SQLException e) {
			throw new UserExceptions(e);
		}
		LOG.info("Response from the method : " + METHOD_NAME + ":" + userRegFlag);
		return userRegFlag;
	}

	@Override
	public RegisterVO getUser(int userId) throws UserExceptions {
		final String METHOD_NAME = "getUser";
		LOG.info("Method Invoked From DAO:" + METHOD_NAME + ":" + userId);

		final String METHOD_NAME1 = "getEmployeeDetails";
		System.out.println("Method Invoked From DAO:" + METHOD_NAME1 + ":" + userId);
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		RegisterVO registerVO = null;
		try {
			connection = DBConnection.createConnection();
			pstStatement = connection.prepareStatement(SQLConstants.USER_FIND_QUERY);
			pstStatement.setInt(1, userId);
			resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				registerVO = new RegisterVO();
				registerVO.setUserId(resultSet.getInt(1));
				registerVO.setFirstName(resultSet.getString(2));
				registerVO.setLastName(resultSet.getString(3));
				registerVO.setPhoneNumber(resultSet.getString(4));
				registerVO.setEmail(resultSet.getString(5));
				registerVO.setPassword(resultSet.getString(6));

			}
		} catch (SQLException e) {
			throw new UserExceptions(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				LOG.fatal(e.getMessage());
			}
		}
		System.out.println("Response From The DAO Method:" + METHOD_NAME1 + ":" + registerVO);
		return registerVO;

	}

	@Override
	public boolean removeUser(int userId) throws UserExceptions, SQLException {
		boolean userRemoved = false;
		try (Connection con = DBConnection.createConnection();
				PreparedStatement preparedStatement = con.prepareStatement(SQLConstants.DELETE_USERS);) {

			preparedStatement.setInt(1, userId);
			userRemoved = preparedStatement.executeUpdate() > 0;
		}
		return userRemoved;
	}

	@Override
	public boolean editUserDetails(RegisterVO registerVO) throws UserExceptions, SQLException {
		boolean userUpdated = false;
		try (Connection con = DBConnection.createConnection();
				PreparedStatement preparedStatement = con.prepareStatement(SQLConstants.UPDATE_USERS);) {

			preparedStatement.setInt(1, registerVO.getUserId());
			preparedStatement.setString(2, registerVO.getFirstName());
			preparedStatement.setString(3, registerVO.getLastName());

			preparedStatement.setString(5, registerVO.getPhoneNumber());
			preparedStatement.setString(6, registerVO.getEmail());
			preparedStatement.setString(7, registerVO.getPassword());
			userUpdated = preparedStatement.executeUpdate() > 0;
		}
		return userUpdated;
	}

}

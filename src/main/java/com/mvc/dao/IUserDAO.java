package com.mvc.dao;

import java.sql.SQLException;

import com.mvc.exceptions.UserExceptions;
import com.mvc.vo.RegisterVO;

/**
 * @author sona
 *
 */
public interface IUserDAO {
	/**
	 * @param registerVO
	 * @return user details
	 * @throws UserExceptions adding users to database
	 */

	public abstract boolean registerUser(final RegisterVO registerVO) throws UserExceptions;

	/**
	 * @param userId
	 * @return getUser
	 * @throws UserExceptions getting details of a user
	 */
	public abstract RegisterVO getUser(final int userId) throws UserExceptions;

	/**
	 * @param userId
	 * @return removeUser
	 * @throws UserExceptions
	 * @throws SQLException   deleting a user
	 */
	public abstract boolean removeUser(final int userId) throws UserExceptions, SQLException;

	/**
	 * @param registerVO
	 * @return editUserDetails
	 * @throws UserExceptions
	 * @throws SQLException   Changing the user details
	 */
	public abstract boolean editUserDetails(final RegisterVO registerVO) throws UserExceptions, SQLException;
}

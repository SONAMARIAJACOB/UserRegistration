package com.mvc.bo;

import java.sql.SQLException;

import com.mvc.exceptions.UserBusinessException;
import com.mvc.exceptions.UserExceptions;
import com.mvc.vo.RegisterVO;

/**
 * @author sona
 *
 */
public interface IUserBO {
	/**
	 * @param registerVO
	 * @return user registered
	 * @throws UserExceptions
	 * @throws UserBusinessException
	 */
	public abstract boolean registerUser(RegisterVO registerVO) throws UserExceptions, UserBusinessException;

	/**
	 * @param userId
	 * @return getUser
	 * @throws UserExceptions
	 * @throws UserBusinessException
	 */
	public abstract RegisterVO getUser(final int userId) throws UserExceptions, UserBusinessException;

	/**
	 * @param userId
	 * @return removeUser
	 * @throws UserExceptions
	 * @throws SQLException
	 * @throws UserBusinessException
	 */
	public abstract boolean removeUser(final int userId) throws UserExceptions, SQLException, UserBusinessException;

	/**
	 * @param registerVO
	 * @return editUserDetails
	 * @throws UserExceptions
	 * @throws SQLException
	 * @throws UserBusinessException
	 */
	public abstract boolean editUserDetails(final RegisterVO registerVO)
			throws UserExceptions, SQLException, UserBusinessException;
}

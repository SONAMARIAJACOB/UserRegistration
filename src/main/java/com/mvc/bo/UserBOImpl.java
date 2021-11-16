package com.mvc.bo;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mvc.dao.IUserDAO;
import com.mvc.dao.RegisterDao;
import com.mvc.exceptions.UserBusinessException;
import com.mvc.exceptions.UserExceptions;
import com.mvc.vo.RegisterVO;

/**
 * @author sona
 *
 */
public class UserBOImpl implements IUserBO {

	private IUserDAO iUserDao = null;
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(UserBOImpl.class);

	/**
	 * Instantiating DAO instance
	 */
	public UserBOImpl() {
		iUserDao = new RegisterDao();
	}

	@Override
	public boolean registerUser(RegisterVO registerVO) throws UserExceptions, UserBusinessException {
		final String METHOD_NAME = "registerUser";
		boolean userRegFlag = false;
		LOG.info("Method Invoked:" + METHOD_NAME + registerVO);

		if (validateAllBusinessConditions(registerVO)) {
			userRegFlag = iUserDao.registerUser(registerVO);
		}
		LOG.info("Response From The Method:" + METHOD_NAME + ":" + userRegFlag);
		return userRegFlag;
	}

	private boolean validateAllBusinessConditions(final RegisterVO registerVO)
			throws UserBusinessException, UserExceptions {
		String METHOD_NAME = "validateAllBusinessConditions";
		LOG.info("Method Entry:" + METHOD_NAME + ":" + registerVO);

		boolean validationsFlag = false;
		String methodName = "validateAllBusinessConditions";
		System.out.println("Method Invoked From :" + this.getClass().getName() + ":" + methodName + ":" + registerVO);

		boolean result1 = validateFirstName(registerVO.getFirstName());
		boolean result2 = validateLastName(registerVO.getLastName());
		boolean result3 = validatePhoneNumber(registerVO.getPhoneNumber());
		boolean result4 = validateEmailId(registerVO.getEmail());
		boolean result5 = validatePassword(registerVO.getPassword());

		if (result1 && result2 && result3 && result4 && result5) {
			validationsFlag = true;
		}
		LOG.info("Method Exit:" + METHOD_NAME + ":" + validationsFlag);
		return validationsFlag;
	}

	private boolean validateFirstName(String firstName) throws UserBusinessException {
		boolean firstNameFlag = false;
		final String METHOD_NAME = "validateFirstName";
		LOG.info("Method Entry:" + METHOD_NAME + ":" + firstName);
		String pattern = "^[a-zA-Z]+$";
		Pattern myPattren = Pattern.compile(pattern);
		Matcher matcher = myPattren.matcher(firstName);
		if (!matcher.matches()) {

			throw new UserBusinessException("First Name Violation Error");
		} else {
			firstNameFlag = true;
		}
		LOG.info("Method Exit:" + METHOD_NAME + ":" + firstNameFlag);
		return firstNameFlag;
	}

	private boolean validateLastName(String lastName) throws UserBusinessException {
		boolean lastNameFlag = false;
		final String METHOD_NAME = "validateLastName";
		LOG.info("Method Entry:" + METHOD_NAME + ":" + lastName);
		String pattern = "^[a-zA-Z]+$";
		Pattern myPattren = Pattern.compile(pattern);
		Matcher matcher = myPattren.matcher(lastName);
		if (!matcher.matches()) {

			throw new UserBusinessException("Last Name Violation Error");
		} else {
			lastNameFlag = true;
		}
		LOG.info("Method Exit:" + METHOD_NAME + ":" + lastNameFlag);
		return lastNameFlag;
	}

	private boolean validatePhoneNumber(String phoneNumber) throws UserBusinessException {
		boolean phoneNumberFlag = false;
		final String METHOD_NAME = "validatePhoneNumber";
		LOG.info("Method Entry:" + METHOD_NAME + ":" + phoneNumber);
		String pattern = "[6-9]{1}[0-9]{9}";
		Pattern myPattren = Pattern.compile(pattern);
		Matcher matcher = myPattren.matcher(phoneNumber);
		if (!matcher.matches()) {

			throw new UserBusinessException("Phone Number Violation Error");
		} else {
			phoneNumberFlag = true;
		}
		LOG.info("Method Exit:" + METHOD_NAME + ":" + phoneNumberFlag);
		return phoneNumberFlag;
	}

	private boolean validateEmailId(String email) throws UserBusinessException {
		boolean emailFlag = false;
		final String METHOD_NAME = "validateEmailId";
		LOG.info("Method Entry:" + METHOD_NAME + ":" + email);
		String pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$";
		Pattern myPattren = Pattern.compile(pattern);
		Matcher matcher = myPattren.matcher(email);
		if (!matcher.matches()) {

			throw new UserBusinessException("Email Violation Error");
		} else {
			emailFlag = true;
		}
		LOG.info("Method Exit:" + METHOD_NAME + ":" + emailFlag);
		return emailFlag;
	}

	private boolean validatePassword(String password) throws UserBusinessException {
		boolean passwordFlag = false;
		final String METHOD_NAME = "validateEmailId";
		LOG.info("Method Entry:" + METHOD_NAME + ":" + password);
		String pattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
		Pattern myPattren = Pattern.compile(pattern);
		Matcher matcher = myPattren.matcher(password);
		if (!matcher.matches()) {

			throw new UserBusinessException("Password Violation Error");
		} else {
			passwordFlag = true;
		}
		LOG.info("Method Exit:" + METHOD_NAME + ":" + passwordFlag);
		return passwordFlag;
	}

	@Override
	public RegisterVO getUser(int userId) throws UserExceptions, UserBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(int userId) throws UserExceptions, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUserDetails(RegisterVO registerVO) throws UserExceptions, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

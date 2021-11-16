package com.mvc.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mvc.exceptions.UserBusinessException;
import com.mvc.exceptions.UserExceptions;
import com.mvc.vo.RegisterVO;

/**
 * @author sona
 *
 */
public class UserBOImplTest {
	private static IUserBO userBO;

	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		userBO = new UserBOImpl();
	}

	/**
	 * 
	 */
	@AfterClass
	public static void destroy() {
		userBO = null;
	}

	/**
	 * 
	 */
	@Test
	public void testRegisterUser() {
		try {
			RegisterVO registerVO = new RegisterVO();
			registerVO.setUserId(100);
			registerVO.setFirstName("Sona");
			registerVO.setLastName("Jacob");
			registerVO.setPhoneNumber("8775643245");
			registerVO.setEmail("sonajacob@gmail.com");
			registerVO.setPassword("Sona@1234");
			boolean userRegFlag = userBO.registerUser(registerVO);
			assertEquals(userRegFlag, true);
		} catch (UserExceptions e) {
			fail();
		} catch (UserBusinessException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	@Test(timeout = 300)
	public void testRegisterUser2() {
		try {
			RegisterVO registerVO = new RegisterVO();
			registerVO.setUserId(100);
			registerVO.setFirstName("Sona");
			registerVO.setLastName("Jaco12b");
			registerVO.setPhoneNumber("8775643245");
			registerVO.setEmail("sonajacob@gmail.com");
			registerVO.setPassword("Sona@1234");
			boolean userRegFlag = userBO.registerUser(registerVO);
		} catch (UserExceptions e) {
			fail();
		} catch (UserBusinessException e) {
			System.out.println(e.getMessage());
		}

	}
}

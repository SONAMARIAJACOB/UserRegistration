package com.mvc.constants;

/**
 * @author sona
 *
 */
public final class SQLConstants {

	private SQLConstants() {

	}

	/**
	 * BOSS_CODE_CHECK_QUERY
	 */
	public static final String BOSS_CODE_CHECK_QUERY = "SELECT userid FROM users WHERE userid=?";

	/**
	 * User Insert Query
	 */
	public static final String USER_INSERT_QUERY = "INSERT INTO users VALUES(?,?,?,?,?,?)";
	/**
	 * DB URL
	 */
	public static final String DRIVER_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	/**
	 * DB User Name
	 */
	public static final String DB_USER_NAME = "Sona_Workspace";

	/**
	 * DB Password
	 */
	public static final String DB_PASSWORD = "database";
	/**
	 * Driver Class Name
	 */
	public static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

	/**
	 * to select user with userId
	 */
	public static final String USER_FIND_QUERY = "SELECT * FROM users WHERE userid=?";

	/**
	 * to delete a user
	 */
	public static final String DELETE_USERS = "DELETE FROM users WHERE userid=?";

	/**
	 * to update the details of a user
	 */
	public static final String UPDATE_USERS = "UPDATE users SET firstname = ?,lastname = ?,phonenumber = ?email= ?, password =? WHERE userid = ?;";

}

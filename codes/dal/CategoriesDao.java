/* by Yiyang Bu */

package review.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import review.model.Categories;

/**
 * Data access object (DAO) class to interact with the underlying Users table in
 * your MySQL instance. This is used to store {@link Users} into your MySQL
 * instance and retrieve {@link Users} from MySQL instance.
 */
public class CategoriesDao {
	// Single pattern: instantiation is limited to one object.
	private static CategoriesDao instance = null;

	public static CategoriesDao getInstance() {
		if (instance == null) {
			instance = new CategoriesDao();
		}
		return instance;
	}

	protected ConnectionManager connectionManager;

	protected CategoriesDao() {
		connectionManager = new ConnectionManager();
	}

	/**
	 * Save the {@link Categories} instance by storing it in your MySQL instance. This
	 * runs a INSERT statement.
	 *
	 * @throws SQLException
	 */
	public Categories create(Categories category) throws SQLException {
		String insertUser = "INSERT INTO Categories(CategoryId, Title, Assignable) VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);
			insertStmt.setString(1, category.getCategoryId().toString());
			insertStmt.setString(2, category.getTitle());
			insertStmt.setString(3, category.getAssignable().toString());

			insertStmt.executeUpdate();

			return category;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
		}
	}

	/**
	 * Delete the {@link Categories} instance. This runs a DELETE statement.
	 *
	 * @throws SQLException
	 */
	public Categories delete(Categories category) throws SQLException {
		String deleteCategory = "DELETE FROM Categories WHERE CategoryId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteCategory);
			deleteStmt.setString(1, category.getCategoryId().toString());
			deleteStmt.executeUpdate();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	/**
	 * Get the {@link Categories} record by fetching it from your MySQL instance. This runs a
	 * SELECT statement and returns a single {@link Categories} instance.
	 *
	 * @throws SQLException
	 */
	public Categories getCategoryByCategoryId(Integer CategoryId) throws SQLException {
		String selectCategory = "SELECT CategoryId, CategoryName FROM Categories WHERE CategoryId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCategory);
			selectStmt.setString(1, CategoryId.toString());

			results = selectStmt.executeQuery();

			if (results.next()) {
				String title = results.getString("Title");
				Boolean Assignable = Boolean.parseBoolean(results.getString("Assignable"));
				Categories category = new Categories(CategoryId, title, Assignable);
				return category;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

}
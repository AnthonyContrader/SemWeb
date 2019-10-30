package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Dictionary;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class DictionaryDAO {

	private final String QUERY_ALL = "SELECT * FROM dictionary";
	private final String QUERY_CREATE = "INSERT INTO dictionary (name) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM dictionary WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE dictionary SET name=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM dictionary WHERE id=?";

	public DictionaryDAO() {

	}

	public List<Dictionary> getAll() {
		List<Dictionary> dictionariesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Dictionary dictionary;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				dictionary = new Dictionary(name);
				dictionary.setId(id);
				dictionariesList.add(dictionary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dictionariesList;
	}

	public boolean insert(Dictionary dictionaryToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, dictionaryToInsert.getName());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Dictionary read(int dictionaryId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, dictionaryId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;

			name = resultSet.getString("name");
			Dictionary dictionary = new Dictionary(name);
			dictionary.setId(resultSet.getInt("id"));

			return dictionary;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Dictionary dictionaryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (dictionaryToUpdate.getId() == 0)
			return false;

		Dictionary dictionaryRead = read(dictionaryToUpdate.getId());
		if (!dictionaryRead.equals(dictionaryToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (dictionaryToUpdate.getName() == null || dictionaryToUpdate.getName().equals("")) {
					dictionaryToUpdate.setName(dictionaryRead.getName());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, dictionaryToUpdate.getName());
				preparedStatement.setInt(2, dictionaryToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}

package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Research;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class ResearchDAO {

	private final String QUERY_ALL = "SELECT * FROM research";
	private final String QUERY_CREATE = "INSERT INTO research (keyWord) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM research WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE research SET keyWord=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM research WHERE id=?";

	public ResearchDAO() {

	}

	public List<Research> getAll() {
		List<Research> researchesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Research research;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String keyWord = resultSet.getString("keyWord");
				research = new Research(keyWord);
				research.setId(id);
				researchesList.add(research);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return researchesList;
	}

	public boolean insert(Research researchToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, researchToInsert.getKeyWord());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Research read(int researchId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, researchId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String keyWord;

			keyWord = resultSet.getString("keyWord");
			Research research = new Research(keyWord);
			research.setId(resultSet.getInt("id"));

			return research;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Research researchToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (researchToUpdate.getId() == 0)
			return false;

		Research researchRead = read(researchToUpdate.getId());
		if (!researchRead.equals(researchToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (researchToUpdate.getKeyWord() == null || researchToUpdate.getKeyWord().equals("")) {
					researchToUpdate.setKeyWord(researchRead.getKeyWord());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, researchToUpdate.getKeyWord());
				preparedStatement.setInt(2, researchToUpdate.getId());
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

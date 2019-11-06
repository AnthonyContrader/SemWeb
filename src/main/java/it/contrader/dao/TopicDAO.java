package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Topic;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class TopicDAO {

	private final String QUERY_ALL = "SELECT * FROM topic";
	private final String QUERY_CREATE = "INSERT INTO topic (name) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM topic WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE topic SET name=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM topic WHERE id=?";

	public TopicDAO() {

	}

	public List<Topic> getAll() {
		List<Topic> topicsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Topic topic;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				topic = new Topic(name);
				topic.setId(id);
				topicsList.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topicsList;
	}

	public boolean insert(Topic topicToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, topicToInsert.getName());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Topic read(int topicId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, topicId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;

			name = resultSet.getString("name");
			Topic topic = new Topic(name);
			topic.setId(resultSet.getInt("id"));

			return topic;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Topic topicToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (topicToUpdate.getId() == 0)
			return false;

		Topic topicRead = read(topicToUpdate.getId());
		if (!topicRead.equals(topicToUpdate)) {
			try {
				// Fill the topicToUpdate object
				if (topicToUpdate.getName() == null || topicToUpdate.getName().equals("")) {
					topicToUpdate.setName(topicRead.getName());
				}

				// Update the topic
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, topicToUpdate.getName());
				preparedStatement.setInt(2, topicToUpdate.getId());
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
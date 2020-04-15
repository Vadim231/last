package kz.itstep.dao;
import kz.itstep.entity.Task;
import kz.itstep.entity.Language;
import kz.itstep.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao extends AbstractDao<Task> {
    private Logger logger = Logger.getLogger(TaskDao.class);

    private static final String SQL_SELECT_ALL = "select * from tasks";
    private static final String SQL_SELECT_BY_ID = "select * from tasks where id=?";
    private static final String SQL_SELECT_BY_USER_ID = "select * from tasks where userId=?";
    private static final String INSERT = "insert into tasks (name) values(?)";

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Task task) {
        return false;
    }

    @Override
    public boolean insert(Task task) {
        return false;
    }

    @Override
    public boolean update(Task task) {
        return false;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)){
            while (resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setTitle(resultSet.getString("title"));
                task.setDate(resultSet.getDate("date"));
                task.setDescription(resultSet.getString("description"));
                task.setUserId(resultSet.getInt("userId"));
                task.setProjectId(resultSet.getInt("projectId"));
                tasks.add(task);
            }
        } catch (SQLException e){
            logger.error(e.getMessage());
        } finally {
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
        return tasks;
    }

    @Override
    public Task findById(int id) {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            Task task = new Task();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task = setTaskParameters(resultSet);
                }
            }
            return task;
        } catch (SQLException e){
            logger.error(e.getMessage());
            return null;
        } finally {
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
    }


    public List<Task> findByUserId(int userId) {
        List<Task> tasks = new ArrayList<>();
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Task task = new Task();
                    task = setTaskParameters(resultSet);
                    tasks.add(task);
                }
            }
            return tasks;
        } catch (SQLException e){
            logger.error(e.getMessage());
            return null;
        } finally {
            ConnectionPool.getConnectionPool().releaseConnection(connection);
        }
    }


    private Task setTaskParameters(ResultSet resultSet){
        Task task = new Task();
        try {
            task.setId(resultSet.getInt("id"));
            task.setTitle(resultSet.getString("title"));
            task.setDescription(resultSet.getString("description"));
            task.setDate(resultSet.getDate("date"));

            task.setUserId(resultSet.getInt("userId"));
            task.setProjectId(resultSet.getInt("projectId"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return task;
    }
}
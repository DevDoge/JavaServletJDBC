package com.example.javaservletjdbc.dao;

import com.example.javaservletjdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //Connection
    Connection connectionSQL = null;
    PreparedStatement pstm = null;

    //Create
    private static final String INSERT_SQL = "INSERT INTO users (nome, email, country) VALUES (?,?,?);";

    //Read
    private static final String SELECT_USER_BY_ID_SQL = "select id,nome,email,country from users where id = ?;";
    private static final String SELECT_ALL_USERS_SQL = "select * from users;";

    //Update
    private static final String UPDATE_BY_ID_SQL = "update users set nome=?, email=?, country=? where id=?;";

    //Delete
    private static final String DELETE_BY_ID_SQL = "delete from users where id=?;";

    //Constrctor
    public UserDAO() { }

    public void insertUser(User user) {
        try {
            connectionSQL = ConnectionFactory.getConnection();
            pstm = connectionSQL.prepareStatement(INSERT_SQL);

            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getCountry());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connectionSQL != null) {
                    connectionSQL.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public User selectUserById(int id) {
        User user = null;
        try {
            connectionSQL = ConnectionFactory.getConnection();
            pstm = connectionSQL.prepareStatement(SELECT_USER_BY_ID_SQL);

            pstm.setInt(1, id);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String nomeRS = resultSet.getString("nome");
                String emailRS = resultSet.getString("email");
                String countryRS = resultSet.getString("country");

                user = new User(id, nomeRS, emailRS, countryRS);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connectionSQL != null) {
                    connectionSQL.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> usersList = new ArrayList<>();

        try {
            connectionSQL = ConnectionFactory.getConnection();
            pstm = connectionSQL.prepareStatement(SELECT_ALL_USERS_SQL);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                int idRS = resultSet.getInt("id");
                String nomeRS = resultSet.getString("nome");
                String emailRS = resultSet.getString("email");
                String countryRS = resultSet.getString("country");
                usersList.add(new User(idRS, nomeRS, emailRS, countryRS));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connectionSQL != null) {
                    connectionSQL.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usersList;
    }

    public boolean updateUser(User user) {
        boolean rowUpdated = false;

        try {
            connectionSQL = ConnectionFactory.getConnection();
            pstm = connectionSQL.prepareStatement(UPDATE_BY_ID_SQL);

            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getCountry());
            pstm.setInt(4, user.getId());

            rowUpdated = pstm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connectionSQL != null) {
                    connectionSQL.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowUpdated;
    }

    public boolean deleteUser(int id) {
        boolean rowDeleted = false;

        try {
            connectionSQL = ConnectionFactory.getConnection();
            pstm = connectionSQL.prepareStatement(DELETE_BY_ID_SQL);

            pstm.setInt(1, id);
            rowDeleted = pstm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connectionSQL != null) {
                    connectionSQL.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }
}

package by.epamtc.library.dao;

import by.epamtc.library.model.User;

public interface UserDao {
    User authorization(String login, String password) throws DaoException;
    boolean registration(String login, String password, String firstName, String lastName,
                         String email, String userRole) throws DaoException;
}

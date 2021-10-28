package by.epamtc.library.dao;

import by.epamtc.library.model.User;

public interface UserDao {
    User authorization(String login, String password) throws DaoException;
}

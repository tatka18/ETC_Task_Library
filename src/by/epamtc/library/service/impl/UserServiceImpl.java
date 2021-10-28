package by.epamtc.library.service.impl;

import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.DaoProvider;
import by.epamtc.library.model.User;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(String login, String password) throws ServiceException{
        if (login == null || login.isEmpty()) {
            throw new RuntimeException("login has not right coming value");
        }
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("password has not right coming value");
        }

        User result;
        try{
            result = DaoProvider.getInstance().getUserDao().authorization(login, password);
        }catch (DaoException e) {
            throw new ServiceException("exception authorization", e);
        }
        return result;
    }
}

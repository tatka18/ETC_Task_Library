package by.epamtc.library.service.impl;

import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.DaoProvider;
import by.epamtc.library.dao.UserDao;
import by.epamtc.library.model.User;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(String login, String password) throws ServiceException{
        User result;
        try{
            if (login == null || login.isEmpty()) {
                throw new RuntimeException("login has not right coming value");
            }
            if (password == null || password.isEmpty()) {
                throw new RuntimeException("password has not right coming value");
            }

            result = DaoProvider.getInstance().getUserDao().findByLoginAndPassword(login, password);
        }catch (DaoException e) {
            throw new ServiceException("exception authorization", e);
        }catch (RuntimeException e){
            throw new ServiceException("WRONG INCOMING VALUE" ,e);
        }
        return result;
    }

    @Override
    public boolean registration(String login, String password, String firstName, String lastName,
                                String email, String userRole) throws ServiceException {
        boolean result;
        DaoProvider provider = DaoProvider.getInstance();
        UserDao userDao = provider.getUserDao();

        try {
            if (login == null || login.isEmpty() || password == null
                    || password.isEmpty()) {
                throw new NullPointerException("login or password has wrong incoming value");
            }
            result = userDao.registration(login, password, firstName, lastName, email, userRole);
        } catch (DaoException e) {
            throw new ServiceException("Error During registration", e);
        } catch (NullPointerException e){
            throw new ServiceException("incoming value is null or empty");
        }
        return result;
    }
}

package by.epamtc.library.service;

import by.epamtc.library.model.User;

public interface UserService {
    User authorization(String login, String password) throws ServiceException;
    boolean registration(String login, String password, String firstName,
                         String lastName, String email, String userRole) throws ServiceException;

}

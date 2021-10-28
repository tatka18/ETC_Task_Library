package by.epamtc.library.dao.impl;

import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.FillObject;
import by.epamtc.library.dao.UserDao;
import by.epamtc.library.model.User;
import by.epamtc.library.scaner.Scan;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final FillObject fillObject = new FillObjectImpl();

    @Override
    public User authorization(String login, String password) throws DaoException{
        User user = new User();
        try{
            List<String> stringList = Scan.readTextFromFile();
            for (String string : stringList) {
                user = fillObject.fillUser(string);
                if(user.getPassword().equals(password) && user.getLogin().equals(login)) return user;
            }
        }catch (IOException e){
            throw new DaoException("authorization has failed in DaoImpl", e);
        }
        return user;
    }
}

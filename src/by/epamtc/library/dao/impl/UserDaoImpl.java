package by.epamtc.library.dao.impl;

import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.FillObject;
import by.epamtc.library.dao.UserDao;
import by.epamtc.library.model.User;
import by.epamtc.library.scaner.Scan;
import by.epamtc.library.util.ListData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final FillObject fillObject = new FillObjectImpl();

    @Override
    public User authorization(String login, String password) throws DaoException{
        User user = new User();
        try{
            List<String> stringList = Scan.readTextFromFile(ListData.USERS);
            for (String string : stringList) {
                user = fillObject.fillUser(string);
                if(user.getPassword().equals(password) && user.getLogin().equals(login)) return user;
            }
        }catch (IOException e){
            throw new DaoException("authorization has failed in DaoImpl", e);
        }
        return user;
    }

    @Override
    public boolean registration(String login, String password, String firstName,
                                String lastName, String email, String userRole) throws DaoException {
        try(FileWriter writer = new FileWriter(ListData.USERS, true);) {
            List<String> stringList = Scan.readTextFromFile(ListData.USERS);
            int lastId = stringList.size();

            int id = lastId + 1;
            String nextLine = "\r\n";
            String newString;

            newString = nextLine + "id=" + id + " login=" + login + " password=" + password +
                    " firstName=" + firstName + " lastName=" + lastName + " mail=" + email +
                    " userRole=" + userRole;
            writer.write(newString);

        } catch (IOException e) {
            throw new DaoException("Failed during registration", e);
        }
        return false;
    }
}

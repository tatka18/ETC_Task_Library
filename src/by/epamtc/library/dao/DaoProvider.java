package by.epamtc.library.dao;

import by.epamtc.library.dao.impl.UserDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    private DaoProvider(){};

    private UserDao userDao = new UserDaoImpl();

    public static DaoProvider getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        if (userDao == null) {
            synchronized (UserDao.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }
}

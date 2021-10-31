package by.epamtc.library.dao;

import by.epamtc.library.dao.impl.BookDaoImpl;
import by.epamtc.library.dao.impl.UserDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    private DaoProvider(){};

    private UserDao userDao = new UserDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

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
    public BookDao getBookDao(){
        if (bookDao == null) {
            synchronized (BookDao.class) {
                if (bookDao == null) {
                    bookDao = new BookDaoImpl();
                }
            }
        }
        return bookDao;
    }

}

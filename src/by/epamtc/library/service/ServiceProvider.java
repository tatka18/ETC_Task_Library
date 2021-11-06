package by.epamtc.library.service;

import by.epamtc.library.service.impl.BookServiceImpl;
import by.epamtc.library.service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private static UserService userService = new UserServiceImpl();
    private static BookService bookService = new BookServiceImpl();

    private ServiceProvider(){}

    public static ServiceProvider getInstance(){
        return instance;
    }

    public static UserService getUserService(){
        if (userService == null){
            synchronized (UserService.class){
                if(userService == null){
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }
    public BookService getBookService(){
        if (bookService == null){
            synchronized (BookService.class){
                if(bookService == null){
                    bookService = new BookServiceImpl();
                }
            }
        }
        return bookService;
    }

}

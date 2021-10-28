package by.epamtc.library.service;

import by.epamtc.library.service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private static UserService userService = new UserServiceImpl();

    public static ServiceProvider getInstance(){
        return instance;
    }

    public UserService getUserService(){
        if (userService == null){
            synchronized (UserService.class){
                if(userService == null){
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

}

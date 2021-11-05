package by.epamtc.library.controller;

public class CashClass {
    private static String userRole = "guest";

    public static void setCashedUserRole(String userRole){
        CashClass.userRole = userRole;
    }
    public static String getCashedUserRole(){
        return userRole;
    }
}

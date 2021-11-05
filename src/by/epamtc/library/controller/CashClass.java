package by.epamtc.library.controller;

public class CashClass {
    private static String userRole = "";

    public static void setCashedUserRole(String userRole){
        CashClass.userRole = userRole;
    }
    public static String getCashedUserRole(){
        return userRole;
    }
}

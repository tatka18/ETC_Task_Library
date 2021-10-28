package by.epamtc.library.dao;

import by.epamtc.library.model.Book;
import by.epamtc.library.model.User;

public interface FillObject {
    User fillUser(String string);
    Book fillBook(String string);
}

package com.kws;

public interface Manager {
    public void showMenu();
    public void showBookshelf();
    public Book addBook();
    public Book updateBook();
    public void removeBook();
    public Book[] searchBook();

}

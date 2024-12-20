package com.kws;

public class Bookshelf {
    public static final Bookshelf INSTANCE = new Bookshelf();
    private final Book[][] bookshelf = new Book[10][10];

    private Bookshelf() {}

    public static Bookshelf getInstance() {
        return INSTANCE;
    }

    public void showBookshelf() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bookshelf[i][j] != null) {
                    System.out.print("■");
                } else {
                    System.out.print("□");
                }

                if (j == 9) {
                    System.out.println();
                }
            }
        }
    }

    public void addBook(Book book) {
        System.out.println("책장을 확인합니다...");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bookshelf[i][j] == null) {
                    bookshelf[i][j] = book;
                    // i+1 줄 j+1번째 칸에 추가합니다
                    System.out.println("책장에 책을 추가했습니다. [" + (i+1) + "줄 " + (j+1) + "번째 칸]");
                    return;
                }
            }
        }
    }

    public Book getBookById(int bookId) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (bookshelf[i][j] != null && bookshelf[i][j].getBookId() == bookId) {
                    return bookshelf[i][j];
                }
            }
        }
        return null;
    }

    public void removeBookById(int bookId) {
        System.out.println("책장을 확인합니다...");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bookshelf[i][j] != null && bookshelf[i][j].getBookId() == bookId) {
                    bookshelf[i][j] = null;
                    System.out.println("책장에서 책을 제거했습니다.");
                    return;
                }
            }
        }
        System.out.println("해당하는 책이 책장에 없습니다.");
    }

    public void removeBookByTitle(String title) {

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (bookshelf[i][j] != null && bookshelf[i][j].getTitle().equals(title)) {
                    bookshelf[i][j] = null;
                    System.out.println("책장에서 책을 제거했습니다.");
                    return;
                }
            }
        }
        System.out.println("해당하는 책이 책장에 없습니다.");
    }

}

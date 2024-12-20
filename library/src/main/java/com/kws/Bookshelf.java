package com.kws;

import java.util.Scanner;

public class Bookshelf {
    public static final Bookshelf INSTANCE = new Bookshelf();
    private final Book[][] bookshelf = new Book[10][10];
    Scanner scanner = new Scanner(System.in);

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

    public Book addBook(Book book) {
        System.out.println("책장을 확인합니다...");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bookshelf[i][j] == null) {
                    bookshelf[i][j] = book;
                    // i+1 줄 j+1번째 칸에 추가합니다
                    System.out.println("책장에 책을 추가했습니다. [" + (i+1) + "줄 " + (j+1) + "번째 칸]");
                    return book;
                }
            }
        }
        return null;
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

    public Book updateBookById(int bookId) {
        Book book = null;
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (bookshelf[i][j] != null && bookshelf[i][j].getBookId() == bookId) {
                    System.out.println("수정할 책을 " + (i+1) + "줄 " + (j+1) + "번째 칸에서 찾았습니다.");
                    book = bookshelf[i][j];
                    System.out.println(book);
                    System.out.println("수정할 정보를 입력하세요.");
                    System.out.print(">>> 제목: ");
                    String title = scanner.nextLine();
                    book.setTitle(title);
                    System.out.print(">>> 글쓴이: ");
                    String author = scanner.nextLine();
                    book.setAuthor(author);
                    System.out.print(">>> 출판사: ");
                    String publisher = scanner.nextLine();
                    book.setPublisher(publisher);
                    System.out.print(">>> 출판년도: ");
                    int year = scanner.nextInt();
                    book.setYear(year);
                    return book;
                }
            }
        }
        System.out.println("해당하는 책이 책장에 없습니다.");
        return book;
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

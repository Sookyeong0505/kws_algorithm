package com.kws;

import java.util.Scanner;

public class LibraryManager {
    Book[][] bookshelf = Bookshelf.getInstance().getBookshelf();
    Scanner scanner = new Scanner(System.in);
    boolean continueFlag = true;

    public LibraryManager() {
        this.start();
    }

    public void start() {

        while (continueFlag) {
            showMenu();
            System.out.print("메뉴 선택: ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    showBookshelf();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    continueFlag = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void showMenu() {
        String menu = """
                메뉴를 선택하세요.
                1. 책장 보기
                2. 도서 추가
                3. 도서 정보 수정
                4. 도서 삭제
                5. 책 아이디로 도서 찾기
                6. 종료
                """;

        System.out.println(menu);
    }

    public void showBookshelf() {
        System.out.println("====================================");
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
        System.out.println("====================================");
    }

    public void addBook() {
        BOOK_STATUS status = BOOK_STATUS.BOOKSELF_IS_FULL;
        System.out.println("------ 도서 추가 ------");
        scanner.nextLine();
        System.out.print(">>> 제목: ");
        String title = scanner.nextLine();
        System.out.print(">>> 글쓴이: ");
        String author = scanner.nextLine();
        System.out.print(">>> 출판사: ");
        String publisher = scanner.nextLine();
        System.out.print(">>> 출판년도: ");
        int year = scanner.nextInt();

        Book book = new Book(title, author, publisher, year);
        System.out.println(book);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bookshelf[i][j] == null) {
                    bookshelf[i][j] = book;
                    // i+1 줄 j+1번째 칸에 추가합니다
                    System.out.println("책장에 책을 추가했습니다. [" + (i+1) + "줄 " + (j+1) + "번째 칸]");
                    status = BOOK_STATUS.SUCCESS;
                }
            }
        }

        printResult(status);
    }

    public void updateBook() {
        BOOK_STATUS status = BOOK_STATUS.BOOK_NOT_FOUND;
        System.out.println("------ 도서 정보 수정 ------");
        System.out.println("수정할 도서의 ID를 입력하세요.");
        System.out.print(">>> ");
        scanner.nextLine();
        int bookId = scanner.nextInt();
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
                }
            }
        }

        printResult(status);
    }

    public void removeBook() {
        BOOK_STATUS status = BOOK_STATUS.BOOK_NOT_FOUND;
        System.out.println("------ 도서 삭제 ------");
        System.out.println("삭제할 도서의 ID를 입력하세요.");
        System.out.print(">>> ");
        scanner.nextLine();
        int bookId = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bookshelf[i][j] != null && bookshelf[i][j].getBookId() == bookId) {
                    bookshelf[i][j] = null;
                    System.out.println("책장에서 책을 제거했습니다.");
                    status = BOOK_STATUS.SUCCESS;
                }
            }
        }

        printResult(status);
    }

    public void searchBook() {
        BOOK_STATUS status = BOOK_STATUS.BOOK_NOT_FOUND;
        System.out.println("------ 도서 검색 ------");
        System.out.println("검색할 도서의 ID를 입력하세요.");
        System.out.print(">>> ");
        scanner.nextLine();
        int bookId = scanner.nextInt();
        Book book = null;
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (bookshelf[i][j] != null && bookshelf[i][j].getBookId() == bookId) {
                    book = bookshelf[i][j];
                    System.out.println("책을 " + (i+1) + "줄 " + (j+1) + "번째 칸에서 찾았습니다.");
                }
            }
        }
        System.out.println(book);
        printResult(status);
    }

    public void printResult(BOOK_STATUS status) {
        switch (status) {
            case SUCCESS:
                System.out.println("성공!");
                break;
            case BOOKSELF_IS_FULL:
                System.out.println("실패. 책장에 책이 가득 찼습니다. 책장을 비워주세요.");
                break;
            case BOOK_NOT_FOUND:
                System.out.println("해당하는 책이 책장에 없습니다.");
                break;
            case BOOK_ALREADY_EXISTS:
                System.out.println("해당하는 책이 이미 책장에 있습니다.");
                break;
            case INVALID_ID:
                System.out.println("잘못된 ID입니다.");
                break;
        }
    }
}

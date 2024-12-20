package com.kws;

import java.util.Scanner;

public class LibraryManager implements Manager {
    Bookshelf bookshelf = Bookshelf.getInstance();
    Scanner scanner = new Scanner(System.in);
    boolean continueFlag = true;

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

    @Override
    public void showMenu() {
        String menu = """
                메뉴를 선택하세요.
                1. 책장 보기
                2. 도서 추가
                3. 도서 정보 수정
                4. 도서 삭제
                5. 책 아이디로 도서 찾기
                6. 종료
                """; // Java 13부터 지원

        System.out.println(menu);
    }

    @Override
    public void showBookshelf() {
        System.out.println("====================================");
        bookshelf.showBookshelf();
        System.out.println("====================================");
    }

    @Override
    public Book addBook() {
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

        book = bookshelf.addBook(book);
        if (book != null) {
            System.out.println("성공!");
        } else {
            System.out.println("실패. 책장에 책이 가득 찼습니다. 책장을 비워주세요.");
        }
        return book;
    }

    @Override
    public void updateBook() {
        System.out.println("------ 도서 정보 수정 ------");
        System.out.println("수정할 도서의 ID를 입력하세요.");
        System.out.print(">>> ");
        scanner.nextLine();
        int bookId = scanner.nextInt();

        Book book = bookshelf.updateBookById(bookId);

        if (book != null) {
            System.out.println("수정된 책 정보입니다.");
            System.out.println(book);
        }
    }

    @Override
    public void removeBook() {
        System.out.println("------ 도서 삭제 ------");
        System.out.println("삭제할 도서의 ID를 입력하세요.");
        System.out.print(">>> ");
        scanner.nextLine();
        int bookId = scanner.nextInt();
        bookshelf.removeBookById(bookId);

    }

    @Override
    public Book searchBook() {
        System.out.println("------ 도서 검색 ------");
        System.out.println("검색할 도서의 ID를 입력하세요.");
        System.out.print(">>> ");
        scanner.nextLine();
        int bookId = scanner.nextInt();

        Book book = bookshelf.getBookById(bookId);

        if (book == null) {
            System.out.println("해당하는 책이 책장에 없습니다.");
            return null;
        }
        System.out.println(book);
        return book;
    }
}

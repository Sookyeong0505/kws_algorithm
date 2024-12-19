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
                1. 전체 도서 목록 보기
                2. 도서 추가
                3. 도서 정보 수정
                4. 도서 삭제
                5. 도서 검색
                6. 종료
                """; // Java 13부터 지원

        System.out.println(menu);
    }

    @Override
    public void showBookshelf() {
        System.out.println("책장");
        System.out.println("====================================");


    }

    @Override
    public Book addBook() {
        return null;
    }

    @Override
    public Book updateBook() {
        return null;
    }

    @Override
    public void removeBook() {

    }

    @Override
    public Book[] searchBook() {
        return new Book[0];
    }
}

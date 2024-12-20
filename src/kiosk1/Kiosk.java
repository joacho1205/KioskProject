package kiosk1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
 *  main함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리한다.
 *  MenuItem을 관리하는 리스트가 필드로 존재한다.
 *  List<MenuItem>>menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당한다.
 *  -> Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨준다.
 */
public class Kiosk {
    // 1. 속성
    private List<Menu> category; // 여러 Menu 객체를 관리한다. == 카테고리 단위로 메뉴를 관리한다.
    private boolean running; // 프로그램 실행 상태를 속성으로 관리
    private Scanner scanner;

    // 2. 생성자
    public Kiosk() {
        this.category = new ArrayList<>();
        this.running = true; // 초기값
        this.scanner = new Scanner(System.in);
    }

    // 3. 기능
    public void addMenu(Menu menu) { // 카테고리(Menu) 추가 메서드
        category.add(menu);
    }

    public void start() { // 키오스크 프로그램 시작 메서드
        while (running) {
            displayCategory(); //전체 카테고리 출력 메서드

            System.out.print("카테고리 번호를 선택해주세요 (0 : 종료): ");
            if (scanner.hasNextInt()) { // scanner 객체에 입력값이 int일 때만 true를 반환해주는 메서드
                int categoryChoice = scanner.nextInt(); // 숫자 입력받기
                handleInput(categoryChoice); // 입력받은 숫자에 따른 로직 실행 메서드
            } else {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); // 숫자 이외의 입력을 받았을 때 나오는 문구
                scanner.next(); // 잘못된 입력 제거
            }
            System.out.println(); // 가독성을 위해 줄바꿈 한줄 추가
        }
    }

    public void displayCategory() { // 전체 카테고리 출력 메서드
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < category.size(); i++) { // 반복문을 활용해 List 안에 있는 카테고리를 하나씩 출력
            System.out.println((i + 1) + ". " + category.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 종료");
    }

    public void handleInput(int categoryChoice) {
        if (categoryChoice > 0 && categoryChoice <= category.size()) {
            Menu selectedCategory = category.get(categoryChoice - 1);
            selectedCategory.displayMenu(); // 선택된 카테고리 메뉴 출력

            // 사용자 입력 받기
            System.out.print("메뉴 번호를 선택해주세요 (0: 뒤로가기): ");

            if (scanner.hasNextInt()) {
                int itemChoice = scanner.nextInt();

                if (itemChoice == 0) {
                    System.out.println("카테고리 메뉴로 돌아갑니다.");
                    return; // 뒤로 가기
                }

                List<MenuItem> items = selectedCategory.getItems();
                if (itemChoice > 0 && itemChoice <= items.size()) {
                    MenuItem selectedItem = items.get(itemChoice - 1);
                    System.out.printf("선택한 메뉴: %s | 가격: W %.1f | 설명: %s%n",
                            selectedItem.getName(),
                            selectedItem.getPrice(),
                            selectedItem.getDescription());
                } else {
                    System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 선택해주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        } else if (categoryChoice == 0) {
            System.out.println("프로그램을 종료합니다.");
            running = false; // 프로그램 종료
        } else {
            System.out.println("잘못된 입력입니다. 카테고리 번호를 다시 선택해주세요.");
        }
    }

    public List<Menu> getCategory() {
        return category;
    }

    public void setCategory(List<Menu> category) {
        this.category = category;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
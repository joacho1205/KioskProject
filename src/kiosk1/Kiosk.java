package kiosk1;

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
    List<MenuItem> menuItems; // MenuItem을 관리하는 리스트가 필드로 존재한다.
    boolean running; // 프로그램 실행 상태를 속성으로 관리

    // 2. 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems; // 이 생성자를 통해 main 함수에서 객체를 생성할 때 값을 할당한다.
        this.running = true; // 초기값
    }

    // 3. 기능
    public void start() { // 키오스크 프로그램 시작 메서드
        Scanner scanner = new Scanner(System.in);

        while (running) {
            //메뉴 출력 메서드
            displayMenu();

            System.out.print("메뉴 번호를 선택해주세요: ");
            if (scanner.hasNextInt()) { // scanner 객체에 입력값이 int일 때만 true를 반환해주는 메서드
                int choice = scanner.nextInt(); // 숫자 입력받기
                handleInput(choice); // 입력받은 숫자에 따른 로직 실행 메서드
            } else {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); // 숫자 이외의 입력을 받았을 때 나오는 문구
                scanner.next(); // 잘못된 입력 제거
            }
            System.out.println(); // 가독성을 위해 줄바꿈 한줄 추가
        }
    }

    public void displayMenu() { // 메뉴 출력 메서드
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) { // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.println((i + 1) + ". " + menuItems.get(i).display());
        }
        System.out.println("0. 종료      | 종료");
    }

    public void handleInput(int choice) {
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
                MenuItem selectedItem = menuItems.get(choice - 1); // List에서 선택한 메뉴 가져오기
                System.out.printf("선택한 메뉴: %s | 가격: W %.1f | 설명: %s%n",
                        selectedItem.name,
                        selectedItem.price,
                        selectedItem.description);
                break;
            case 0:
                System.out.println("프로그램을 종료합니다.");
                running = false; // while루프 종료
                break; //프로그램 종료
            default:
                System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 선택해주세요.");
        }
    }
}
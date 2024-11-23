package kiosk1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>(); // MenuItem을 저장할 List 선언 및 초기화
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner scanner = new Scanner(System.in); // Scanner 선언
        boolean running = true; // 프로그램의 실행 상태를 제어하는 변수 running

        while (running) {
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i+1) + ". " + menuItems.get(i).display());
            }
            System.out.println("0. 종료      | 종료");
            System.out.print("메뉴 번호를 선택해주세요: ");

            if (scanner.hasNextInt()) { // scanner 객체에 입력값이 int일 때만 true를 반환해주는 메서드
                int choice = scanner.nextInt(); // 숫자 입력받기
                // 입력받은 숫자에 따른 로직 실행
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
            } else {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); // 숫자 이외의 입력을 받았을 때 나오는 문구
                scanner.next(); // 잘못된 입력 제거
            }
            System.out.println(); // 가독성을 위해 줄바꿈 한줄 추가
        }

        scanner.close();
    }
}

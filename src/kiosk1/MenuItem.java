package kiosk1;
/**
 * 개별 음식 항목을 관리하는 클래스
 * 이 클래스는 이름, 가격, 설명 필드를 갖는다.
 */
public class MenuItem {
    // 1. 속성
    String name; // 이름
    double price; // 가격
    String description; // 설명

    // 2. 생성자
    public MenuItem (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 3. 기능
    public String display() { //메뉴 출력 메서드 display()
        return String.format("%s   | W %.1f | %s", name, price, description);
    }

}

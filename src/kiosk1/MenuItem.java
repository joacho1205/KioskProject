package kiosk1;
/**
 * 개별 음식 항목을 관리하는 클래스
 * 이 클래스는 이름, 가격, 설명 필드를 갖는다.
 */
public class MenuItem {
    // 1. 속성
    private String name; // 이름
    private double price; // 가격
    private String description; // 설명

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

    // Getter , Setter 메서드
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price > 0) { // 유효성 검사
            this.price = price;
        } else {
            System.out.println("가격은 0보다 커야 합니다.");
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

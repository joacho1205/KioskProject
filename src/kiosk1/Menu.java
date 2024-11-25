package kiosk1;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 클래스를 List로 관리
 * List에 들어있는 MenuItem을 순차적으로 보여주는 함수
 * List를 리턴하는 함수
 */
public class Menu {
    // 1. 속성
    private String categoryName; // 메뉴 카테고리 이름
    private List<MenuItem> items; // 해당 카테고리의 MenuItem 리스트

    // 2. 생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.items = new ArrayList<>();
    }

    // 3. 기능
    public void addMenuItem(MenuItem item) { // 메뉴 아이템 추가
        items.add(item);
    }

    public void displayMenu() { // 메뉴 출력
        System.out.println("[" + categoryName + " MENU]");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).display());
        }
        System.out.println("0. 뒤로가기");
    }

    // Getter , Setter 메서드
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}

package kiosk1;

public class Main {
    public static void main(String[] args) {
        // Burgers 메뉴 생성
        String[][] burgerItems = {
                {"ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
                {"SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"},
                {"Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"},
                {"Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"}
        };
        Menu burgerMenu = new Menu("Burgers");
        for (String[] item : burgerItems) {
            burgerMenu.addMenuItem(new MenuItem(item[0], Double.parseDouble(item[1]), item[2]));
        }

        // Drinks 메뉴 생성
        String[][] drinkItems = {
                {"Coke", "2.5", "콜라"},
                {"Cider", "2.0", "사이다"},
                {"Fanta", "2.0", "환타"},
                {"Tonic", "1.5", "토닉워터"}
        };
        Menu drinksMenu = new Menu("Drinks");
        for (String[] item : drinkItems) {
            drinksMenu.addMenuItem(new MenuItem(item[0], Double.parseDouble(item[1]), item[2]));
        }

        // Desserts 메뉴 생성
        String[][] dessertItems = {
                {"Cake", "5.0", "케이크"},
                {"Donut", "5.0", "도넛"},
                {"Pie", "4.5", "파이"},
                {"Cookie", "3.0", "쿠키"}
        };
        Menu dessertsMenu = new Menu("Desserts");
        for (String[] item : dessertItems) {
            dessertsMenu.addMenuItem(new MenuItem(item[0], Double.parseDouble(item[1]), item[2]));
        }

        // Kiosk 객체 생성 및 start()메서드로 프로그램 시작
        Kiosk kiosk = new Kiosk();
        Menu[] menus = {burgerMenu, drinksMenu, dessertsMenu};
        for (Menu menu : menus) {
            kiosk.addMenu(menu);
        }

        // 키오스크 프로그램 실행
        kiosk.start();
    }
}

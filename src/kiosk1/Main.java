package kiosk1;

public class Main {
    public static void main(String[] args) {
        // Burgers 메뉴 생성
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Drinks 메뉴 생성
        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Coke", 2.5, "콜라"));
        drinksMenu.addMenuItem(new MenuItem("Cider", 2.0, "사이다"));
        drinksMenu.addMenuItem(new MenuItem("Fanta", 2.0, "환타"));
        drinksMenu.addMenuItem(new MenuItem("Tonic", 1.5, "토닉워터"));

        // Desserts 메뉴 생성
        Menu dessertsMenu = new Menu("Desserts");
        dessertsMenu.addMenuItem(new MenuItem("Cake", 5.0, "케이크"));
        dessertsMenu.addMenuItem(new MenuItem("Donut", 5.0, "도넛"));
        dessertsMenu.addMenuItem(new MenuItem("Pie", 4.5, "파이"));
        dessertsMenu.addMenuItem(new MenuItem("Cookie", 3.0, "쿠키"));

        // Kiosk 객체 생성 및 start()메서드로 프로그램 시작
        Kiosk kiosk = new Kiosk();
        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinksMenu);
        kiosk.addMenu(dessertsMenu);

        // 키오스크 프로그램 실행
        kiosk.start();
    }
}

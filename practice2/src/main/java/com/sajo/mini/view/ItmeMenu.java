package com.sajo.mini.view;

import com.sajo.mini.member.controller.ProductController;
import com.sajo.mini.model.dto.ItemDTO;

import java.util.*;

public class ItmeMenu {
    ProductController productController = new ProductController();
    MemberMenu memberMenu = new MemberMenu();
    public void displayMainMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*•.¸✨¸.•*” 페이지 선택 *•.¸✨¸.•*”");
            System.out.println("1. 상인관리페이지");
            System.out.println("2. 구매자 페이지");
            System.out.println("3. 프로그램 종료");
            System.out.print("이용할 서비스를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    productview();
                    break;
                case 2:
                    memberMenu.MemberMainMenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("잘못된 메뉴를 성택하셨습니다.");
                    break;
            }


        }

    }

    public void productview() {
        List<ItemDTO> itemDTOList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*•.¸✨¸.•*” 메뉴 선택 *•.¸✨¸.•*”");
            System.out.println("1. 아이템 등록");
            System.out.println("2. 아이템 조회");
            System.out.println("3. 아이템 삭제");
            System.out.println("4. 메인페이지로");
            System.out.print("번호를 입력해주세요 : ");
            int num1 = sc.nextInt();
            sc.nextLine();
            switch (num1) {
                case 1:
                    productController.insertItem(insert());
                    break;
                case 2:
                    productController.productList();
                    break;
                case 3:
                    productController.productDelete(delete());
                    break;
                case 4:
                    return;

            }
        }
    }

    private static Map<String, String> delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*•.¸✨¸.•*” 아이템 삭제 *•.¸✨¸.•*”");
        System.out.println("삭제할 아이템 명을 입력하세요 : ");
        String Item_Name = sc.nextLine();
        Map<String, String> parameter = new HashMap<>();
        parameter.put("Item_Name", Item_Name);

        return parameter;

    }

    private static Map<String, String> insert() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("*•.¸✨¸.•*” 아이템 등록 *•.¸✨¸.•*”");
            System.out.print("아이템 명을 입력해주세요 : ");
            String productName = sc.nextLine();
            System.out.println("힐러 / 탱커 / 딜러");
            System.out.print("등록하시려는 아이템의 직업분류를 입력해주세요 : ");
            String job = sc.nextLine();
            System.out.print("아이템의 가격을 입력해주세요 : ");
            int price = sc.nextInt();
            System.out.print("아이템의 레벨을 입력해주세요 : ");
            int levelRestriction = sc.nextInt();
            sc.nextLine();
            System.out.print("아이템 이펙트를 입력해주세요 : ");
            String demonstration = sc.nextLine();
            System.out.print("계속 입력하겠습니까? (y/n) : ");
            char ch = sc.nextLine().toUpperCase().charAt(0);

            int jobNumber = 0;
            switch (job) {
                case "힐러":
                    jobNumber = 1;
                    break;
                case "탱커":
                    jobNumber = 2;
                    break;
                case "딜러":
                    jobNumber = 3;
                    break;
            }
            Map<String, String> parameter = new HashMap<>();
            parameter.put("productName", productName);
            parameter.put("jobNumber", String.valueOf(jobNumber));
            parameter.put("price", String.valueOf(price));
            parameter.put("levelRestriction", String.valueOf(levelRestriction));
            parameter.put("demonstration", demonstration);

            return parameter;
        }

    }
}

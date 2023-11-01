package com.sajo.mini.view;

import com.sajo.mini.member.controller.MemberController;
import com.sajo.mini.model.dto.MemberDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberMenu {
private final MemberController memberController;
public MemberMenu(){
    memberController = new MemberController();
}


    public void MemberMainMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("*•.¸✨¸.•*” 선택지 *•.¸✨¸.•*”");
            System.out.println("1. 회원 등록");
            System.out.println("2. 로그인");
            System.out.println("3. 물건 보기");
            System.out.println("4. 장바구니 확인");
            System.out.println("5. 구매하기");
            System.out.println("9. 메인 페이지로");
            System.out.print("번호를 입력해주세요 : ");

            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    memberController.insertMember(infoUser());
                    break;
                case 2:
                    memberController.searchMember(getUser());
                    break;
                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 9:
                    return;
                default:
                    System.out.println("존재하는 번호가 아닙니다.");
                    System.out.println("다시 입력해주세요");
                    break;

            }
        }
    }

    public String getUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력해주세요 : ");
        String username = sc.nextLine();

        return username;
    }


    public static Map<String, String> infoUser () {
            Scanner sc = new Scanner(System.in);
            System.out.print("아이디 입력해주세요 : ");
            String username = sc.nextLine();
            System.out.print("레벨을 입력해주세요 : ");
            int userlevel = sc.nextInt();
            System.out.print("직업을 입력해주세요 (힐러,탱커,딜러 중 선택): ");
            String userjob = sc.next();
            int userGold = 0;

            int jobNumber = 0;
            switch (userjob) {
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
            if(jobNumber == 1){
                userGold += userlevel * 1;

            }else if (jobNumber == 2){
                    userGold += userlevel * 2;

            }else if(jobNumber ==3){
                userGold += userlevel * 3;
            }
            Map<String, String> parameter = new HashMap<>();
            parameter.put("username", username);
            parameter.put("userlevel", String.valueOf(userlevel));
            parameter.put("userjob", userjob);
            parameter.put("userGold", String.valueOf(userGold));

            return parameter;
        }
    }


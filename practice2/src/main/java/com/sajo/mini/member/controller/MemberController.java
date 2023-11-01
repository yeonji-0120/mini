package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.MemberDTO;
import com.sajo.mini.service.MemberService;
import com.sajo.mini.view.ResultView;

import java.util.List;
import java.util.Map;

public class MemberController {
    private final MemberService memberService;
    private final ResultView resultView;

    public MemberController(){
        memberService = new MemberService();
        resultView = new ResultView();
    }
    public void insertMember(Map<String, String> insert) {
        String userId = insert.get("username");
        int userLevel = Integer.parseInt(insert.get("userlevel"));
        String userJob = insert.get("userjob");
        int userGold = Integer.parseInt(insert.get("userGold"));

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(userId);
        memberDTO.setUserLevel(userLevel);
        memberDTO.setUserJob(userJob);
        memberDTO.setUserGold(userGold);
        System.out.println("memberDTO = " + memberDTO);

        if(memberService.insertMember(memberDTO)){
            resultView.success();
        }else {
            resultView.failed();
        }

    }


    public void searchMember(String user) {
        List<MemberDTO> memberDTO = memberService.selectMember();
        if(memberDTO != null){
            resultView.printMemberList(memberDTO);
        }else {
            resultView.failed();
        }
    }
}

package com.sajo.mini.view;

import com.sajo.mini.model.dto.ItemDTO;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    public static void printItemList(List<ItemDTO> itemDTOList) {
        for(ItemDTO itemDTO : itemDTOList){
            System.out.println(itemDTO);
        }
    }



    public static void failed() {
        System.out.println("실패~~~~~~~");
    }

    public static void success() {
        System.out.println("성공~~~~~~~");

    }
    //사용자한테 결과 출력하는 화면


}

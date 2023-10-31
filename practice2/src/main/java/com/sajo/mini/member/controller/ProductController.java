package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;
import com.sajo.mini.service.ProductService;
import com.sajo.mini.view.ResultView;

import java.util.List;
import java.util.Map;

public class ProductController {
private final ProductService productService;
private final ResultView resultView;

public ProductController(){
    productService = new ProductService();
    resultView = new ResultView();
}
    public void productList() {
        List<ItemDTO> itemDTOList = productService.selectAllitem();
        if(itemDTOList != null){
            resultView.printItemList(itemDTOList);
        }else {
            resultView.failed();
        }
    }

    public void insertItem(Map<String, String> insert) {
        String itemName = insert.get("productName");
        String itemJob = insert.get("jobNumber");
        int itemPrice = Integer.parseInt(insert.get("price"));
        int itemLevel = Integer.parseInt(insert.get("levelRestriction"));
        String effect = insert.get("demonstration");

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemName(itemName);
        itemDTO.setItemJob(itemJob);
        itemDTO.setItemPrice(itemPrice);
        itemDTO.setItemLevel(itemLevel);
        itemDTO.setEffect(effect);
        System.out.println("itemDTO = " + itemDTO);

        if(productService.insertItem(itemDTO)){
            resultView.success();
        }else {
            resultView.failed();
        }
    }

    public void productDelete(Map<String, String> delete) {

        String Item_Name = delete.get("Item_Name");
        if(productService.deleteMenu(Item_Name)){
            resultView.success();
        }else {
            resultView.failed();
        }
    }
}

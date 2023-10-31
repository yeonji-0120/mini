package com.sajo.mini.service;

import com.sajo.mini.model.dao.ItemDAO;
import com.sajo.mini.model.dto.ItemDTO;

import java.sql.Connection;
import java.util.List;

import static com.sajo.mini.common.JDBCTemplate.*;

public class ProductService {
    private final ItemDAO itemDAO;

    public ProductService() {
        itemDAO = new ItemDAO();
    }

    public boolean deleteMenu(String itemName) {
        Connection con = getConnection();
        int result = itemDAO.deleteItem(con, itemName);
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result > 0 ? true : false;
    }

    public boolean insertItem(ItemDTO itemDTO) {
        Connection con = getConnection();
        int result = itemDAO.insertItem(con, itemDTO);
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result > 0 ? true : false;
    }

    public List<ItemDTO> selectAllitem() {
        //Connection 생성
        Connection con = getConnection();
        //DAO의 모든 카테고리 조회용 ㅔㅁ소드를 호춯하여 결과 리턴 받기
        List<ItemDTO> itemDTOList = itemDAO.selectAllItem(con);
        //커넥션 닫기
        close(con);
        //리턴
        return itemDTOList;
    }


}

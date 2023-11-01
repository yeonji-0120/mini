package com.sajo.mini.model.dao;

import com.sajo.mini.common.JDBCTemplate;
import com.sajo.mini.model.dto.ItemDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemDAO {

    private Properties prop = new Properties();
    public ItemDAO(){
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/sajo/mini/mapper/order-query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ItemDTO> selectAllItem(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<ItemDTO> itemDTOList = null;
        String query = prop.getProperty("selectAllCategory");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            itemDTOList = new ArrayList<>();

            while (rset.next()){
                ItemDTO item = new ItemDTO();
                item.setItemName(rset.getString("Item_Name"));
                item.setItemJob(rset.getString("JobCode"));
                item.setItemPrice(rset.getInt("Item_Price"));
                item.setItemLevel(rset.getInt("Item_Level"));
                item.setEffect(rset.getString("Item_Effect"));

                itemDTOList.add(item);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);

        }
    return itemDTOList;
    }


    public int insertItem(Connection con, ItemDTO itemDTO) {

        PreparedStatement pstmt1 = null;
        int result = 0;
        String query2 = prop.getProperty("insertItem");

        try {
            pstmt1 = con.prepareStatement(query2);
            pstmt1.setString(1, itemDTO.getItemName());
            pstmt1.setString(2, itemDTO.getItemJob());
            pstmt1.setInt(3, itemDTO.getItemPrice());
            pstmt1.setInt(4, itemDTO.getItemLevel());
            pstmt1.setString(5, itemDTO.getEffect());


            result = pstmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt1);
        }
        return result;

    }

    public int deleteItem(Connection con, String itemName) {
        PreparedStatement pstmt2 = null;
        int result = 0;
        String query3 = prop.getProperty("deleteItem");
        try {
            pstmt2 = con.prepareStatement(query3);
            pstmt2.setString(1, itemName);

            result = pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt2);
        }
        return result;

    }

}

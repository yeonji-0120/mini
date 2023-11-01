package com.sajo.mini.model.dao;

import com.sajo.mini.common.JDBCTemplate;
import com.sajo.mini.model.dto.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemberDAO {
    private Properties prop = new Properties();
    public MemberDAO(){
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/sajo/mini/mapper/member-query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int insertMember(Connection con, MemberDTO memberDTO) {
        PreparedStatement pstmt1 = null;
        int result = 0;
        String query1 = prop.getProperty("insertMember");

        try {
            pstmt1 = con.prepareStatement(query1);
            pstmt1.setString(1, memberDTO.getUserId());
            pstmt1.setInt(2, memberDTO.getUserLevel());
            pstmt1.setInt(3, memberDTO.getUserGold());
            pstmt1.setString(2, memberDTO.getUserJob());

            result = pstmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt1);
        }
        return  result;

    }

    public List<MemberDTO> selectMember(Connection con) {
        PreparedStatement pstmt2 = null;
        ResultSet rset1 = null;
        List<MemberDTO> memberDTOList = null;
        String query1 = prop.getProperty("selectMember");

        try {
            pstmt2 = con.prepareStatement(query1);
            rset1 = pstmt2.executeQuery();
            memberDTOList = new ArrayList<>();

            while (rset1.next()){
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setUserId("u");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

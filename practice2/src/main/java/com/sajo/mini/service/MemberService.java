package com.sajo.mini.service;

import com.sajo.mini.model.dao.MemberDAO;
import com.sajo.mini.model.dto.MemberDTO;

import java.sql.Connection;
import java.util.List;

import static com.sajo.mini.common.JDBCTemplate.*;

public class MemberService {
    private final MemberDAO memberDAO;

    public MemberService(){ memberDAO = new MemberDAO();}
    public boolean insertMember(MemberDTO memberDTO) {
        Connection con = getConnection();
        int result = memberDAO.insertMember(con, memberDTO);
        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result > 0 ? true : false;
    }

    public List<MemberDTO> selectMember() {
        Connection con = getConnection();
        List<MemberDTO> memberDTOList = memberDAO.selectMember(con);
        close(con);
        return memberDTOList;
    }
}

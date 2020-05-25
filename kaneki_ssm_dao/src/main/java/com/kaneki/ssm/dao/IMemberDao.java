package com.kaneki.ssm.dao;

import com.kaneki.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findById(int id) throws Exception;
}

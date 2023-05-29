package com.wingliberty.authorization.domain.aggregateauth.repository.mappeer;

import com.wingliberty.authorization.domain.aggregateauth.entity.AuthEntity;
import org.apache.ibatis.annotations.Param;

public interface AuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthEntity record);

    int insertSelective(AuthEntity record);

    AuthEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthEntity record);

    int updateByPrimaryKey(AuthEntity record);

    AuthEntity findByUserName(@Param("userName") String userName);
}
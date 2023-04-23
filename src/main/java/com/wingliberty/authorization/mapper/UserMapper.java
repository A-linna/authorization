package com.wingliberty.authorization.mapper;

import com.wingliberty.authorization.db.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO row);

    int insertSelective(UserDO row);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO row);

    int updateByPrimaryKey(UserDO row);

    /**
     * 根据手机号查询
     *
     * @param phone
     * @return
     */
    UserDO selectByPhone(@Param("phone") String phone);
}
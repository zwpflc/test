package com.zwp.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zwp.common.entity.User;

/**
 * 
 * @author wezhao
 *
 */
@Mapper
public interface UserMapper {

	@Insert("INSERT INTO t_user(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertByUser(User user);

    @Select("SELECT * FROM t_user WHERE PHONE = #{phone}")
    @Results(id = "userResult",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "password",column = "password"),
            @Result(property = "phone",column = "phone")
    })
    User findUserByPhone(@Param("phone") String phone);

    @Update("UPDATE t_user SET NAME = #{name}, PASSWORD = #{password} WHERE PHONE = #{phone}")
    void update(User user);

    @Delete("DELETE FROM t_user WHERE ID = #{id}")
    void delete(Integer id);

    @ResultMap("userResult")
    @Select("SELECT * FROM t_user")
    List<User> findAll();


}

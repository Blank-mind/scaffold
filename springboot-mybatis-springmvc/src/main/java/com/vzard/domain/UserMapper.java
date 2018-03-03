package com.vzard.domain;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 用户的Mapper
 */

@Mapper
@Component

public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE name = #{name} limit 0,1")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    @Select("SELECT name,age FROM t_user")
    List<User> findAll();

    @Insert("INSERT INTO t_user(name,age) VALUES (#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE t_user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    void delete(Long id);

    @Insert("INSERT INTO t_user(name,age) VALUES(#{name},#{age})")
    int insertByUser(User user);



    @Insert("INSERT INTO t_user(name,age) VALUE(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);




}

package com.xiaoyao.mapstruct.demo.mapper;

import com.xiaoyao.mapstruct.demo.entity.Dog;
import com.xiaoyao.mapstruct.demo.entity.DogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DogMapper {
    int deleteByExample(DogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dog record);

    int insertSelective(Dog record);

    List<Dog> selectByExample(DogExample example);

    Dog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByExample(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByPrimaryKeySelective(Dog record);

    int updateByPrimaryKey(Dog record);
}
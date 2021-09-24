package com.xiaoyao.multiple.datasources.demo.mapper.one;

import com.xiaoyao.multiple.datasources.demo.entity.one.Dog;
import com.xiaoyao.multiple.datasources.demo.entity.one.DogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DogMapper {
    int countByExample(DogExample example);

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
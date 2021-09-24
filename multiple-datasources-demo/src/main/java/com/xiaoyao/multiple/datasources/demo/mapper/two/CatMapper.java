package com.xiaoyao.multiple.datasources.demo.mapper.two;

import com.xiaoyao.multiple.datasources.demo.entity.two.Cat;
import com.xiaoyao.multiple.datasources.demo.entity.two.CatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatMapper {
    int countByExample(CatExample example);

    int deleteByExample(CatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cat record);

    int insertSelective(Cat record);

    List<Cat> selectByExample(CatExample example);

    Cat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cat record, @Param("example") CatExample example);

    int updateByExample(@Param("record") Cat record, @Param("example") CatExample example);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);
}
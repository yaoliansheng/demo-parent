package com.xiaoyao.mapstruct.demo.mapper;

import com.xiaoyao.mapstruct.demo.entity.Cat;
import com.xiaoyao.mapstruct.demo.entity.CatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatMapper {
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
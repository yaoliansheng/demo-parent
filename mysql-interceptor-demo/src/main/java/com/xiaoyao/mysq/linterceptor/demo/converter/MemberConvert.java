package com.xiaoyao.mysq.linterceptor.demo.converter;

import com.xiaoyao.mysq.linterceptor.demo.entity.Member;
import com.xiaoyao.mysq.linterceptor.demo.response.MemberDTO;
import org.mapstruct.Mapper;

/**
 * @author yls
 * @ClassName MemberConvert
 * @Description
 * @Date 2021/4/15 14:34
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public abstract class MemberConvert implements BaseConverter<MemberDTO, Member>{
}

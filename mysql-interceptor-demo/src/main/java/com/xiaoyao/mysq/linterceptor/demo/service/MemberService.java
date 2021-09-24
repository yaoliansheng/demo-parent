package com.xiaoyao.mysq.linterceptor.demo.service;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.xiaoyao.mysq.linterceptor.demo.converter.MemberConvert;
import com.xiaoyao.mysq.linterceptor.demo.entity.Member;
import com.xiaoyao.mysq.linterceptor.demo.entity.MemberExample;
import com.xiaoyao.mysq.linterceptor.demo.mapper.MemberMapper;
import com.xiaoyao.mysq.linterceptor.demo.request.AddMemberParam;
import com.xiaoyao.mysq.linterceptor.demo.response.MemberDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author yls
 * @ClassName MemberService
 * @Description
 * @Date 2021/4/15 14:18
 * @Version 1.0
 */
@Service
public class MemberService {

  @Autowired
  private MemberMapper memberMapper;
  @Autowired
  private IdGenerator idGenerator;
  @Autowired
  MemberConvert memberConvert;

  public String add(AddMemberParam param) {
    long id = idGenerator.generateId().longValue();
    Assert.isTrue(StringUtils.isNotBlank(param.getMobile()),"手机号码不能为空");
    Assert.isTrue(StringUtils.isNotBlank(param.getName()),"姓名不能为空");
    Member member = new Member();
    member.setId(id);
    member.setName(param.getName());
    member.setAge(param.getAge());
    member.setMobile(param.getMobile());
    memberMapper.insert(member);
    return member.getId().toString();
  }

  public MemberDTO get(String id) {
    Member member = memberMapper.selectByPrimaryKey(Long.parseLong(id));
    return memberConvert.toDTO(member);
  }

  public List<MemberDTO> query() {
    List<Member> members = memberMapper.selectByExample(new MemberExample());
    return memberConvert.toDTOList(members);
  }
}

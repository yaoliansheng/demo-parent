package com.xiaoyao.mysq.linterceptor.demo.conttroller;

import com.xiaoyao.mysq.linterceptor.demo.request.AddMemberParam;
import com.xiaoyao.mysq.linterceptor.demo.response.MemberDTO;
import com.xiaoyao.mysq.linterceptor.demo.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yls
 * @ClassName DemoController
 * @Description
 * @Date 2021/4/15 13:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

  @Autowired
  private MemberService memberService;

   @PostMapping("/add")
   @ApiOperation("新增")
   public String add(@RequestBody AddMemberParam param){
     return memberService.add(param);
   }

   @GetMapping("/get/{id}")
   public MemberDTO get(@PathVariable("id") String id){
     return memberService.get(id);
   }

  @PostMapping("/query")
  public List<MemberDTO> query(){
    return memberService.query();
  }

}

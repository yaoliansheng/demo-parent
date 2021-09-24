package com.xiaoyao.redisson.lock.controller;

import com.xiaoyao.redisson.lock.utils.RedissonLockUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yls
 * @ClassName TestController
 * @Description
 * @Date 2021/9/22 17:29
 * @Version 1.0
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    RedissonLockUtil redissonLockUtil;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ApiOperation("测试上锁、解锁过程")
    public String test() throws Exception{
        String lockKey = "only_id";
        try{
            //超过10S自动释放锁
            redissonLockUtil.lock(lockKey, 10L);
            System.out.println(Thread.currentThread().getName()+"---上锁了1");
            //业务处理
            System.out.println(ex());
            Thread.sleep(5000);
        } finally{
            redissonLockUtil.unlock(lockKey);  //释放锁
            System.out.println(Thread.currentThread().getName()+"---释放锁了2");
        }
        return "SUCCESS";
    }

    public String ex(){
        return "处理业务逻辑。。。。。";
    }
}

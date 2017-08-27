package com.eocchain.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Haben
 * @Description:
 * @Date: 2017-08-25 11:10
 * @Version: 1.0
 **/
@RestController
@Api("测试controller")
public class TestController {

    @ApiImplicitParams({
            @ApiImplicitParam(value = "测试方法", name = "msg", dataType = "java.lang.String")
    })
    @PostMapping(value = "/test")
    public String postTest(@RequestBody String msg) {
        Assert.notNull(msg, "消息不能为空");
        return "postTest get message:" + msg;
    }

    @GetMapping(value = "/test/{msg}")
    public String getTest(@PathVariable String msg) {
        Assert.notNull(msg, "消息不能为空");
        return "getTest get message:" + msg;
    }

    @GetMapping(value = "/tt/{msg}")
    public String tt(@PathVariable String msg) {
        Assert.notNull(msg, "消息不能为空");
        return "getTest get message:" + msg;
    }
}

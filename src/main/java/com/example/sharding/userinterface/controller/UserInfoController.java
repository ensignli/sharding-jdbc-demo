package com.example.sharding.userinterface.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.sharding.domain.entity.UserInfo;
import com.example.sharding.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wf
 * @date 2019/11/14
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/userList")
    public Object list() {
        return JSONUtils.toJSONString(userInfoService.list("", 1, 10));
    }

    @GetMapping("/add")
    public Object add() {
        for (int i = 0; i < 100; i++) {
            UserInfo userInfo = UserInfo.builder().userName("liudehua" + i).password("123456").account(i).build();
            userInfoService.addUserInfo(userInfo);
        }
        return "success";
    }

}

package com.example.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sharding.domain.entity.UserInfo;
import com.example.sharding.domain.vo.UserInfoVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wf
 * @date 2019/11/14
 */
public interface UserInfoService  extends IService<UserInfo> {

    public void addUserInfo(UserInfo userInfo);

    public List<UserInfo> getUserInfoList();

    public UserInfoVO findUserById(Long userId);

    public List<UserInfo> list(String name,int current,int size);
}

package com.example.sharding.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sharding.domain.entity.UserInfo;
import com.example.sharding.domain.mapper.userinfo.UserInfoMapper;
import com.example.sharding.domain.vo.UserInfoVO;
import com.example.sharding.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wf
 * @date 2019/11/14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void addUserInfo(UserInfo userInfo) {

        userInfoMapper.insert(userInfo);
    }

    @Override
    public List<UserInfo> getUserInfoList() {

        List<UserInfo> userInfoList = userInfoMapper.selectList(new QueryWrapper<>());

        return userInfoList;
    }

    public UserInfoVO findUserById(Long userId) {

        return userInfoMapper.findUserById(userId);
    }

    @Override
    public List<UserInfo> list(String name,int current,int size) {
        Page<UserInfo> iPage = new Page<>(current, size);
        IPage<UserInfo> data = userInfoMapper.selectPage(iPage,new QueryWrapper<UserInfo>());
        return data.getRecords();
    }


}

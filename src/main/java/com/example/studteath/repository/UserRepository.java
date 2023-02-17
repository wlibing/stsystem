package com.example.studteath.repository;

import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.*;
import com.example.studteath.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ユーザー情報 リポジトリ
 */
@Service
public class UserRepository {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * ユーザー一覧情報検索
     *
     * @return 検索結果
     */
    public List<UserInfo> searchAllUser(USER003InputDto inputDto) {
        List<UserInfo> userInfoList=new ArrayList<>();
        User userSearch = new User();
        String id = inputDto.getId();
        String userNo = inputDto.getUserNo();
        Long uesrId = null;
        if (id != "" && id != null){
            uesrId = Long.parseLong(id);
            userSearch.setId(uesrId);
        }
        if (userNo!="" && userNo != null){
            userSearch.setUserNo(userNo);
        }
        userSearch.setDisableFlag("1");
        List<User> users = userMapper.searchUserList(userSearch);
        if (users.size()>0){
            for (User user: users){
                UserInfo userInfo = new UserInfo();
                BeanUtils.copyProperties(user, userInfo);
                userInfoList.add(userInfo);
            }
        }
        return userInfoList;
    }

    /**
     * ユーザー一覧情報検索
     *
     * @return 検索結果
     */
    public USER001OutputDto  addUser(USER001InputDto inputDto) {
        USER001OutputDto outputDto=new USER001OutputDto();
        User u=new User();
        BeanUtils.copyProperties(inputDto,u);
        u.setDisableFlag("1");
        LocalDateTime nowDateTime = LocalDateTime.now();
        u.setCreateDate(nowDateTime);
        u.setUpdateDate(nowDateTime);
        u.setCreateUser(Long.parseLong(inputDto.getId()));
        u.setUpdateUser(Long.parseLong(inputDto.getId()));
        Integer addNum=userMapper.add(u);

        List<User> users = userMapper.searchUserList(new User());
        List<UserInfo> userInfoList=new ArrayList<>();
        if (users.size()>0){
            for (User user: users){
                UserInfo userInfo = new UserInfo();
                BeanUtils.copyProperties(user, userInfo);
                userInfoList.add(userInfo);
            }
        }
        outputDto.setUserInfoList(userInfoList);
        return outputDto;
    }

    /**
     * ユーザー削除
     *
     * @return 検索結果
     */
    public USER005OutputDto delete(USER005InputDto inputDto) {
        String id=inputDto.getId();
        Integer addNum=userMapper.delete(Integer.parseInt(id));
        USER005OutputDto user005OutputDto=new USER005OutputDto();
        user005OutputDto.setUserInfoList(searchAllUser(new USER003InputDto()));
        return user005OutputDto;
    }

}

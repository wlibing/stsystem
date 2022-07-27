package com.example.studteath.repository;

import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER001OutputDto;
import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.studteath.common.Constants.*;

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
    public List<UserInfo> searchUser(USER003InputDto inputDto) {
        List<UserInfo> userInfoList=new ArrayList<>();
        User userSearch = new User();
        String id = inputDto.getId();
        String userNo = inputDto.getUserNo();
        Long uesrId = null;
        if (!id.isEmpty()){
            uesrId = Long.parseLong(id);
            userSearch.setId(uesrId);
        }
        if (!userNo.isEmpty()){
            userSearch.setUserNo(userNo);
        }
//        List<User> users = userMapper.searchUser(userSearch);
//        if (users.size()>0){
//            for (User user: users){
//                UserInfo userInfo = new UserInfo();
//                BeanUtils.copyProperties(user, userInfo);
//                userInfoList.add(userInfo);
//            }
//        }
        return userInfoList;
    }
}

package com.example.studteath.repository;

import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.USER002InputDto;
import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.studteath.common.Constants.DISABLE_FLAG_1;

/**
 * ユーザー登録 リポジトリ
 */
@Repository
public class User002Repository {
    /**
     * ユーザー Mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * ユーザー登録
     * @param inputDto
     * @return 検索結果
     */
    public UserInfo searchUser(USER002InputDto inputDto) {
        UserInfo userInfo = new UserInfo();

        User user = new User();
        user.setUserNo(inputDto.getUserNo());
        user.setPassWord(inputDto.getPassWord());
        user.setDisableFlag(DISABLE_FLAG_1);
        User user1 = userMapper.searchUser(user);

        if (user1 != null) {
            BeanUtils.copyProperties(user1, userInfo);
            return userInfo;
        }else {
            return null;
        }


    }
}

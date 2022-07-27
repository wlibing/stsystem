package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザー情報 Service
 */
@Service
public class USER003Service {
    /**
     * ユーザー情報 リポジトリ
     */
    @Autowired
    private UserRepository userRepository;



    /**
     * ユーザー一覧情報検索
     *
     * @return 検索結果
     */
    public USER003OutputDto searchUser(USER003InputDto inputDto) {
        USER003OutputDto out = new USER003OutputDto();
       List<UserInfo> userInfoList =userRepository.searchUser(inputDto);
        out.setUserInfoList(userInfoList);
        return out;
    }


}

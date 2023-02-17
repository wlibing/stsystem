package com.example.studteath.service;

import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.USER003OutputDto;
import com.example.studteath.dto.UserInfo;
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
    public USER003OutputDto searAllchUser(USER003InputDto inputDto) {
        USER003OutputDto out = new USER003OutputDto();
        List<UserInfo> userInfoList = userRepository.searchAllUser(inputDto);
        out.setUserInfoList(userInfoList);
        return out;
    }


}

package com.example.studteath.service;

import com.example.studteath.dto.USER002InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.repository.User002Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ユーザー Service
 */
@Service
public class USER002Service {
    /**
     * ユーザー リポジトリ
     */
    @Autowired
    private User002Repository user002Repository;

    /**
     * ユーザー検索
     *
     * @return 検索結果
     */
    public UserInfo searchUser(USER002InputDto inputDto) {
       UserInfo userInfo =user002Repository.searchUser(inputDto);
        return userInfo;
    }


}

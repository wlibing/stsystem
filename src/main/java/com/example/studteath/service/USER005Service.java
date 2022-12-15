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
public class USER005Service {
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
    public USER005OutputDto delete(USER005InputDto inputDto) {

        USER005OutputDto out = userRepository.delete(inputDto);
        return out;
    }


}

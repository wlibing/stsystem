package com.example.studteath.service;

import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER001OutputDto;
import com.example.studteath.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
    /**
     * ユーザー情報 リポジトリ
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザー情報検索
     *
     * @param inputDto リクエストデータ
     * @return 検索結果
     */
    public USER001OutputDto search(USER001InputDto inputDto) {
        USER001OutputDto outputDto = userRepository.search(inputDto);
        return outputDto;
    }
}

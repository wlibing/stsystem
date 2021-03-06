package com.example.studteath.service;

import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER001OutputDto;
import com.example.studteath.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public USER001OutputDto add(USER001InputDto inputDto) {
        USER001OutputDto outputDto = new USER001OutputDto();
//            outputDto = userRepository.add(inputDto);

        return outputDto;
    }

}

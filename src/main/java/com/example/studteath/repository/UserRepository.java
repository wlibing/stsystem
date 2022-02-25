package com.example.studteath.repository;

import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.dto.USER001OutputDto;
import com.example.studteath.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * ユーザー情報検索
     *
     * @param user001InputDto リクエストデータ
     * @return 検索結果
     */
    public USER001OutputDto searchById(USER001InputDto user001InputDto) {

        USER001OutputDto outputDto = new USER001OutputDto();

        User user = userMapper.searchById(user001InputDto);

        if (user == null) {
            outputDto.setResultCode("1");
        } else {
            BeanUtils.copyProperties(user, outputDto);
            outputDto.setResultCode("0");
        }
        return outputDto;
    }

    /**
     * ユーザー情報検索
     *
     * @param user001InputDto リクエストデータ
     * @return 検索結果
     */
    public USER001OutputDto searchAll(USER001InputDto user001InputDto) {

        USER001OutputDto outputDto = new USER001OutputDto();

        User user = userMapper.searchById(user001InputDto);

        if (user == null) {
            outputDto.setResultCode("1");
        } else {
            BeanUtils.copyProperties(user, outputDto);
            outputDto.setResultCode("0");
        }
        return outputDto;
    }
}

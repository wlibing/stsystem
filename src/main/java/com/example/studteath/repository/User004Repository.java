package com.example.studteath.repository;

import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.USER004InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ユーザー更新 リポジトリ
 */
@Repository
public class User004Repository {
    /**
     * ユーザー Mapper
     */
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    /**
     * ユーザー更新
     * @param inputDto
     * @return 検索結果
     */
    public UserInfo searchUser(USER004InputDto inputDto) {
        UserInfo userInfo = new UserInfo();
        User user = new User();
        Long id = Long.parseLong(inputDto.getId());
        String passWord = inputDto.getPassWord();
        String powerFlag = inputDto.getPowerFlag();
        user.setId(id);
        user.setPassWord(passWord);
        user.setPowerFlag(powerFlag);

        Integer integer = userMapper.update(user);
        if (integer > 0 ){
            USER003InputDto user003InputDto = new USER003InputDto();
            user003InputDto.setId(inputDto.getId());
            List<UserInfo> list = userRepository.searchAllUser(user003InputDto);
            userInfo = list.get(0);

        }
              return userInfo;


    }
}

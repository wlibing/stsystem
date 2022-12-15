package com.example.studteath.service;

import com.example.studteath.dto.*;
import com.example.studteath.repository.User004Repository;
import com.example.studteath.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ユーザー更新 Service
 */
@Service
public class USER004Service {
    /**
     * ユーザー更新 リポジトリ
     */
    @Autowired
    private User004Repository user004Repository;


    /**
     * ユーザー一覧情報検索
     *
     * @return 検索結果
     */
    public USER004OutputDto updateUser(USER004InputDto inputDto) {
        USER004OutputDto outputDto = new USER004OutputDto();
         UserInfo info = user004Repository.searchUser(inputDto);
        String userNo = info.getUserNo();
        Long id = info.getId();
        String passWord = info.getPassWord();
        String powerFlag = info.getPowerFlag();
        String disableFlag = info.getDisableFlag();
        Date updateDate = info.getUpdateDate();
        outputDto.setUserNo(userNo);
        outputDto.setId(id);
        outputDto.setPassWord(passWord);
        outputDto.setPowerFlag(powerFlag);
        outputDto.setDisableFlag(disableFlag);
        outputDto.setUpdateDate(updateDate);
        return outputDto;
    }


}

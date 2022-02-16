package com.example.studteath.dao;

import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.entity.User;
import com.example.studteath.modelform.USER001SearchRequest;
import org.apache.ibatis.annotations.Mapper;


/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザー情報検索
     *
     * @param inDto ユーザー検索用リクエストデータ
     * @return ユーザー情報
     */
    User searchById(USER001InputDto inDto);

    /**
     * ユーザー情報検索
     *
     * @return ユーザー情報
     */
    User searchAll();
}

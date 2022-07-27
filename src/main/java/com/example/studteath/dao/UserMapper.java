package com.example.studteath.dao;

import com.example.studteath.dto.USER001InputDto;
import com.example.studteath.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザー情報検索
     *
     * @param user ユーザー検索用リクエストデータ
     * @return ユーザー情報
     */
    User searchUser(User user);

    /**
     * ユーザー情報検索
     *
     * @return ユーザー一覧情報
     */
    List<User> searchUserList(User user);

    /**
     * ユーザー情報検索
     *
     * @return ユーザー情報
     */
    Integer add(User user);
}

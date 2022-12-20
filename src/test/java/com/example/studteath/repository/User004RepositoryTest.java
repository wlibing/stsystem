package com.example.studteath.repository;

import com.example.studteath.dao.UserMapper;
import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.USER004InputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.entity.User;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class User004RepositoryTest {

    @Mock(lenient = true)
    private UserMapper mockUserMapper;
    @Mock(lenient = true)
    private UserRepository mockUserRepository;

    @InjectMocks
    private User004Repository user004RepositoryUnderTest;

    @Test
    void testSearchUser() {
        // Setup
        final USER004InputDto inputDto = new USER004InputDto();
        inputDto.setId("1");
        inputDto.setPowerFlag("powerFlag");
        inputDto.setPassWord("passWord");

        UserInfo expectedResult = new UserInfo();
        User user=new User();
        user.setId(1L);
        user.setPowerFlag("powerFlag");
        user.setPassWord("passWord");
        when(mockUserMapper.update(user)).thenReturn(0);

        // Configure UserRepository.searchAllUser(...).
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setUserNo("userNo");
        userInfo.setPassWord("passWord");
        userInfo.setPowerFlag("powerFlag");
        userInfo.setDisableFlag("disableFlag");
        userInfo.setUpdateDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        userInfo.setCreateDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        userInfo.setDeleteDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        List<UserInfo> userInfoList =new ArrayList<>();
        userInfoList.add(userInfo);
        when(mockUserRepository.searchAllUser(new USER003InputDto())).thenReturn(userInfoList);

        // Run the test
        final UserInfo result = user004RepositoryUnderTest.searchUser(inputDto);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSearchUser_UserRepositoryReturnsNoItems() {
        // Setup
        final USER004InputDto inputDto = new USER004InputDto();
        inputDto.setId("1");
        inputDto.setPowerFlag("powerFlag");
        inputDto.setPassWord("passWord");

        final UserInfo expectedResult = new UserInfo();
        expectedResult.setId(1L);
        expectedResult.setUserNo("userNo");
        expectedResult.setPassWord("passWord");
        expectedResult.setPowerFlag("powerFlag");
        expectedResult.setDisableFlag("disableFlag");
        expectedResult.setUpdateDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreateDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setDeleteDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        USER003InputDto user003InputDto=new USER003InputDto();
        user003InputDto.setId("1");
        when(mockUserMapper.update(any())).thenReturn(1);
        List<UserInfo> userInfoList =List.of(expectedResult);
        when(mockUserRepository.searchAllUser(user003InputDto)).thenReturn(userInfoList);

        // Run the test
        final UserInfo result = user004RepositoryUnderTest.searchUser(inputDto);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}

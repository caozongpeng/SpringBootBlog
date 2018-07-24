/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 14:26
 **/
package com.wip.service.user;

import com.wip.model.UserDomain;

/**
 * 用户相关Service接口
 */
public interface UserService {

    /**
     * 用户登录
     * @param username  用户名
     * @param password  密码
     * @return
     */
    UserDomain login(String username, String password);

    /**
     * 通过用户ID获取用户信息
     * @param uid   主键
     * @return
     */
    UserDomain getUserInfoById(Integer uid);

    /**
     * 更改用户信息
     * @param user  user对象
     * @return
     */
    int updateUserInfo(UserDomain user);

}

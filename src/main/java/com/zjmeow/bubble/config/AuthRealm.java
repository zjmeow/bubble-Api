package com.zjmeow.bubble.config;

import com.zjmeow.bubble.dao.UserMapper;
import com.zjmeow.bubble.model.po.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: shiro用户认证relam
 * @author: zjm
 **/


public class AuthRealm extends AuthorizingRealm {
    @Autowired
    UserMapper mapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phone = (String) token.getPrincipal();
        //模拟查询数据库(假数据)
        User user = mapper.selectUserByPhone(phone);
        String password = user.getPassword();
        if (password.equals(token.getCredentials())) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUid(), password, getName());
            return simpleAuthenticationInfo;
        } else {
            return null;
        }

    }
}

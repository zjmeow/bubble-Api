package com.zjmeow.bubble.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @description:
 * @author: zjm
 **/


public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

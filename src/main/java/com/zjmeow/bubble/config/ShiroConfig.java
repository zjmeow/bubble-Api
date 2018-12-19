package com.zjmeow.bubble.config;

import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: shiro 配置
 * @author: zjm
 **/

@Configuration
public class ShiroConfig {
    @Bean
    public AuthRealm authRealm() {
        return new AuthRealm();
    }

    // 解决BUG
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        // 解决无法正常映射请求BUG
        creator.setUsePrefix(true);
        return creator;
    }


//    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//
//        // logged in users with the 'admin' role
//        chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
//
//        // logged in users with the 'document:read' permission
//        chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
//
//        // all other paths require a logged in user
//        chainDefinition.addPathDefinition("/**", "authc");
//        return chainDefinition;
//    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        manager.setSubjectDAO(subjectDAO);
        return manager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/*", "login"); // need to accept POSTs from the login form
        chainDefinition.addPathDefinition("/logout", "logout");
        return chainDefinition;
    }

}

package com.xiangshangban.transit_service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class RealmTest {
	// 用户登陆和退出
		@Test
		public void testLoginAndLogout() {

			// 创建securityManager工厂，通过ini配置文件创建securityManager工厂
			Factory<SecurityManager> factory = new IniSecurityManagerFactory(
					"classpath:config/shiro-realm.ini");
			
			//创建SecurityManager
			SecurityManager securityManager = factory.getInstance();
			
			//将securityManager设置当前的运行环境中
			SecurityUtils.setSecurityManager(securityManager);
			
			//从SecurityUtils里边创建一个subject
			Subject subject = SecurityUtils.getSubject();
			
			//在认证提交前准备token（令牌）
			UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");

			try {
				//执行认证提交
				subject.login(token);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//是否认证通过
			boolean isAuthenticated =  subject.isAuthenticated();
			
			System.out.println("是否认证通过：" + isAuthenticated);
			
			//退出操作
			subject.logout();
			
			//是否认证通过
			isAuthenticated =  subject.isAuthenticated();
			
			System.out.println("是否认证通过：" + isAuthenticated);
			
			

		}

}

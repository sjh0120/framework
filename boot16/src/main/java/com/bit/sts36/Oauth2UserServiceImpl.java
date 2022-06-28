package com.bit.sts36;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class Oauth2UserServiceImpl extends DefaultOAuth2UserService {

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("oauth2 service run...");
		OAuth2User user=super.loadUser(userRequest);
		System.out.println("1"+userRequest);
		System.out.println("2"+userRequest.getAccessToken());
		System.out.println("3"+userRequest.getClientRegistration());
		System.out.println("4"+userRequest.getAdditionalParameters());
		System.out.println("5"+user);
		System.out.println("6"+user.getAttributes());
		return user;
	}
}

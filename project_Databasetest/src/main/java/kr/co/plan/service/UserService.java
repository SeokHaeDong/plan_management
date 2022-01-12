package kr.co.plan.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

//	public void userJoin(HttpServletRequest request, HttpServletResponse response);
	
	// 회원 가입 서비스, 회원가입 성공 여부, 이메일 중복 체크 결과 여부, 닉네임 중복 체크 결과 여부 
	public Map<String, Object> userJoin(HttpServletRequest request, HttpServletResponse response);
	
	public Map<String, Object> emailCheck(HttpServletRequest request, HttpServletResponse response);
	
	public Map<String, Object> nickCheck(HttpServletRequest request, HttpServletResponse response);
	
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response);

}

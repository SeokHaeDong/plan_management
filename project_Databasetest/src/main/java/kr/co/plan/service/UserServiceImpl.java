package kr.co.plan.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.plan.dao.UserDao;
import kr.co.plan.domain.User_Info;
import kr.co.plan.util.CryptoUtil;
@Service 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	final String KEY = "planmanagement";

//	@Override
//	public void userJoin(HttpServletRequest request, HttpServletResponse response) {
//		
//		String email = request.getParameter("user_email");
//		String pw = request.getParameter("user_pw");
//		String nick = request.getParameter("user_nickname");
//		String date = (String)request.getParameter("user_birthday");
//		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//		Date birthday = null;
//		try {
//			birthday = format.parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		String gender = request.getParameter("user_gender");
//		
//		
//		
//		
//		User_Info users = new User_Info();
//		users.setUser_email(email);
//		users.setUser_pw(pw);
//		users.setUser_nick(nick);
//		users.setUser_birthday(birthday);
//		users.setUser_gender(gender);
//		
//		userDao.userJoin(users);
//		
//				
//
//	}

	@Override
	public Map<String, Object> userJoin(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("result", false);
		
		map.put("emailCheck", false);
		
		map.put("nickCheck", false);
		
		String email = request.getParameter("user_email");
		String pw = request.getParameter("user_pw");
		String nick = request.getParameter("user_nick");
		String date = (String)request.getParameter("user_birthday");
		String gender = request.getParameter("user_gender");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		
		
		
		
		List<String> emailresult = userDao.emailCheck();
		boolean flag = false;
		for(String emaillist : emailresult) {
			try {
				// key 값이 암호화를 위해 사용한 key 
				if(email.equals(CryptoUtil.decryptAES256(emaillist, KEY))) {
					flag = true;
					break;
				}
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		
		String nickCheckresult = userDao.nickCheck(nick);
		if(nickCheckresult == null) {
			map.put("nickCheck", true);
		}
		
		if(flag == false && nickCheckresult == null) {
			User_Info user = new User_Info();
			try {
				user.setUser_email(CryptoUtil.encryptAES256(email, KEY));
				user.setUser_pw(BCrypt.hashpw(pw, BCrypt.gensalt()));
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			user.setUser_email(email);
			user.setUser_pw(pw);
			user.setUser_nick(nick);
			Date birthday = null;
			try {
				birthday = format.parse(date);
			} catch (ParseException e) {
				System.out.println(e.getLocalizedMessage());
				
			}
			user.setUser_birthday(birthday);
			
			int result = userDao.userJoin(user);
			
			map.put("result", true);
		}
		return map;
	}

	@Override
	public Map<String, Object> emailCheck(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		
		String email = request.getParameter("user_email");
		
		List<String> emaillist = userDao.emailCheck();
		
		boolean flag = false;
		
		for(String emails : emaillist) {
			try {
				if(email.equals(CryptoUtil.decryptAES256(emails, KEY))) {
					flag = true;
					break;
				}
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		
		if(flag == false) {
			map.put("result", true);
		}else {
			map.put("result", false);
		}
		
		
		return map;
	}

	@Override
	public Map<String, Object> nickCheck(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		
		String nickname = request.getParameter("user_nick");
		
		String result = userDao.nickCheck(nickname);
		
		if(result == null) {
			map.put("result", true);
		}else {
			map.put("result", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("result", false);
		
		String email = request.getParameter("user_email");
		String pw = request.getParameter("user_pw");
		
		List<User_Info> list = userDao.userlongin();
		
		try {
			for(User_Info user : list) {
				if(email.equals(CryptoUtil.decryptAES256(user.getUser_email(), KEY)) && 
						BCrypt.checkpw(pw, user.getUser_pw())) {
					map.put("result", true);
					
					map.put("email", email);
					map.put("nick", user.getUser_nick());
				}
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		request.getSession().setAttribute("userinfo", map);
		
		return map;
	}

}

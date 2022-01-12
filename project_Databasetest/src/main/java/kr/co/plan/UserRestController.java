package kr.co.plan;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.plan.domain.User_Info;
import kr.co.plan.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value="userJoin")
	public Map<String, Object> UserJoin(@RequestParam User_Info user,HttpServletRequest request, HttpServletResponse response) {
		return userService.userJoin(request, response);
		
	}
	
	@GetMapping("/emailCheck")
	public Map<String, Object> emailCheck(HttpServletRequest request, HttpServletResponse respone){
		return userService.emailCheck(request, respone);
	}
	
	@GetMapping("/nickCheck")
	public Map<String, Object> nickCheck(HttpServletRequest request, HttpServletResponse response){
		return userService.nickCheck(request, response);
	}
	
	@PostMapping("UserLogin")
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response){
		return userService.login(request, response);
	}
	

}

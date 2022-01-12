package kr.co.plan.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class User_Info {
	private int user_code;
	private String user_email;
	private String user_pw;
	private String user_nick;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date user_birthday;
	private String user_gender;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date user_joindate;
	private String user_exists;
}

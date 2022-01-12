package kr.co.plan.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Make_Plan {
	private int plan_user;
	private int plan_number;
	private int plan_priority;
	private String plan_title;
	private String plan_location;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date plan_deadline;
	private String plan_description;
	private String plan_category;
	private String plan_share;
}

package kr.co.plan.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.plan.domain.Make_Plan;

public interface Make_PlanService {
	
//	public void insert(HttpServletRequest request, HttpServletResponse response, Make_Plan plan);
	public void insert(Make_Plan plan);
	
	public List<Make_Plan> getPlan(HttpServletRequest request, HttpServletResponse response);

	public Make_Plan getDetailPlan(Integer plan_number);

	public void updatePlan(Make_Plan plan);

	public void deletePlan(Integer plan_number);
	
}

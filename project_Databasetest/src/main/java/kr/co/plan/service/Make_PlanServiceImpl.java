package kr.co.plan.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.plan.dao.Make_PlanDao;
import kr.co.plan.domain.Make_Plan;

@Service
public class Make_PlanServiceImpl implements Make_PlanService {

	@Autowired
	private Make_PlanDao planDao;

	/*
	 * @Override public void insert(HttpServletRequest request, HttpServletResponse
	 * response, Make_Plan plan) {
	 * 
	 * planDao.insert(plan); }
	 *
	 *
	 */
	
	@Override
	public void insert(Make_Plan plan) {
	
	planDao.insert(plan);
	}

	@Override
	public List<Make_Plan> getPlan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return planDao.getPlan();
	}

	@Override
	public Make_Plan getDetailPlan(Integer plan_number) {
		return planDao.getDetailPlan(plan_number);
	}
	

	@Override
	public void updatePlan(Make_Plan plan) {
		planDao.updatePlan(plan);
		
	}

	@Override
	public void deletePlan(Integer plan_number) {
		planDao.deletePlan(plan_number);
		
	}


	

	

	
	
	
	

}

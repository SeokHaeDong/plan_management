package kr.co.plan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.plan.domain.Make_Plan;
import kr.co.plan.service.Make_PlanService;
import kr.co.plan.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private Make_PlanService planService;
	
	@Autowired
	private UserService userService;
	
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping(value="inserttest")
	public String inserttest() {
		return "inserttest";
	}
	

	@RequestMapping(value="inserttest", method=RequestMethod.POST)
	public String insertcomplete(HttpServletRequest request, HttpServletResponse response, Make_Plan plan) {
//		planService.insert(request, response);
//		planService.insert(request, response, plan);
		planService.insert(plan);
		return "home";
	}
	
	
	@GetMapping(value="getPlan")
	public String getPlan(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("list", planService.getPlan(request, response));
		
	
		return "allPlan";
	}
	
	@RequestMapping(value="detail/{plan_number}")
	public String getDetailPlan(@PathVariable Integer plan_number, Model model) {
		Make_Plan plan = planService.getDetailPlan(plan_number);
		model.addAttribute("plan", plan);
		
		return "detail";
	}
	
	
	@RequestMapping(value="/modifiy/{plan_number}", method=RequestMethod.GET)
	public String modifiy(@PathVariable Integer plan_number, Model model) {
		Make_Plan plan = planService.getDetailPlan(plan_number);
		model.addAttribute("update", plan);
		
		return "modifiy";
	}
	
//	@InitBinder
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePlan(HttpServletRequest request, HttpServletResponse response, WebDataBinder binder) {
		
		/*
		 * SimpleDateFormat fom = new SimpleDateFormat("yyyy/MM/dd");
		 * binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(fom,
		 * false));
		 */
		
		
		Make_Plan plan = new Make_Plan();
		
		int plan_user = Integer.parseInt(request.getParameter("plan_user"));
		int plan_number = Integer.parseInt(request.getParameter("plan_number"));
		int plan_priority = Integer.parseInt(request.getParameter("plan_priority"));
		String plan_title = request.getParameter("plan_title");
		String plan_location = request.getParameter("plan_location");
		
		String date = (String)request.getParameter("plan_deadline");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		
		
		String plan_description = request.getParameter("plan_description");
		String plan_category = request.getParameter("plan_category");
		String plan_share = request.getParameter("plan_share");
		
		
		
		plan.setPlan_user(Integer.parseInt(request.getParameter("plan_user")));
		plan.setPlan_number(Integer.parseInt(request.getParameter("plan_number")));
		plan.setPlan_priority(plan_priority);
		plan.setPlan_title(plan_title);
		plan.setPlan_location(plan_location);
		Date plan_deadline = null;
		try {
			plan_deadline = format.parse(date);
		} catch (ParseException e) {
			System.out.println(e.getLocalizedMessage());
			
		}
		plan.setPlan_deadline(plan_deadline);

		plan.setPlan_description(plan_description);
		plan.setPlan_category(plan_category);
		plan.setPlan_share(plan_share);
		
		
		
		
		planService.updatePlan(plan);
		return "redirect:getPlan";
	}
	
	@RequestMapping(value="/delete/{plan_number}")
	public String deletePlan(@PathVariable Integer plan_number,HttpServletRequest request) {
		
//		Make_Plan plan = new Make_Plan();
//		plan.setPlan_number(Integer.parseInt(request.getParameter("plan_number")));
		planService.deletePlan(plan_number);
		return "home";
	}
	
	// user part controller
	
	@RequestMapping(value="UserJoin", method=RequestMethod.GET)
	public String UserJoinForm() {
		return "User/UserJoin";
	}
	
	
	@GetMapping("UserLogin")
	public String UserLogin() {
		return "User/login";
	}
	
	
	@GetMapping("UserLogout")
	public String UserLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
}

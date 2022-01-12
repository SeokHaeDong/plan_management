package kr.co.plan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.plan.dao.Make_PlanDao;
import kr.co.plan.domain.Make_Plan;
import kr.co.plan.service.Make_PlanService;

// JUnit 과 Spring-Test 를 같이 사용하겠다는 설정 
@RunWith(SpringJUnit4ClassRunner.class)
// Spring Bean Configuration 파일의 내용을 실행하겠다는 설정
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
	/*
	 * @Autowired private DataSource ds;
	 * 
	 * @Autowired private SqlSession sqlSession;
	 */	
	
	@Autowired
	private Make_PlanDao planDao;

	@Test
	public void inserttest()
	{
		
		
		System.out.println(planDao.getDetailPlan(7));
		
	}


}

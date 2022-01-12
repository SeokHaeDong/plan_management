package kr.co.plan.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.plan.domain.Make_Plan;

@Repository
public class Make_PlanDao {
	
	
	
	@Autowired
	private SqlSession sqlSession;
	
	public Integer maxCode()
	{
		return sqlSession.selectOne("MakePlan.maxCode");
	}
	
	public int insert(Make_Plan plan) {
		return sqlSession.insert("MakePlan.insertplan", plan);
	}
	
	public List<Make_Plan> getPlan() {
		return sqlSession.selectList("MakePlan.getPlan");
	}

	public Make_Plan getDetailPlan(Integer plan_number) {
		return sqlSession.selectOne("MakePlan.getDetailPlan", plan_number);
	}

	public int updatePlan(Make_Plan plan) {
		// TODO Auto-generated method stub
		return sqlSession.update("MakePlan.updatePlan", plan);
	}

	public int deletePlan(Integer plan_number) {
		return sqlSession.delete("MakePlan.deletePlan", plan_number);
		
	}
	
	
	
	
	
}

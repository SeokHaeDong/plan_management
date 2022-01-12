package kr.co.plan.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.plan.domain.User_Info;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	public int userJoin(User_Info users) {
		return sqlSession.insert("user.UserJoin", users);
		
	}
	
	public List<String> emailCheck(){
		return sqlSession.selectList("user.emailselect");
	}
	
	public String nickCheck(String user_nick) {
		return sqlSession.selectOne("user.nickselect", user_nick);
	}
	
	public List<User_Info> userlongin(){
		return sqlSession.selectList("user.userlogin");
	}
	
	
	
	
}

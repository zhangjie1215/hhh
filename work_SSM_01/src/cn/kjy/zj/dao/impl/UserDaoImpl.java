package cn.kjy.zj.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.kjy.zj.dao.IUserDao;
import cn.kjy.zj.pojo.User;
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao{

	@Override
	public User checkLogin(User user) {
		return super.getSqlSession().selectOne("cn.kjy.zj.pojo.User.checkLogin", user);
	}

}

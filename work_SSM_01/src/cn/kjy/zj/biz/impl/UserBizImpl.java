package cn.kjy.zj.biz.impl;

import org.springframework.stereotype.Service;

import cn.kjy.zj.biz.IUserBiz;
import cn.kjy.zj.dao.IUserDao;
import cn.kjy.zj.pojo.User;
@Service
public class UserBizImpl implements IUserBiz{
	private IUserDao userDaoImpl;
	@Override
	public User checkLogin(User user) {
		if(user==null||user.getUname()==null||user.getUpwd()==null){
			return null;
		}
		return userDaoImpl.checkLogin(user);
	}
	public IUserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	public void setUserDaoImpl(IUserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}

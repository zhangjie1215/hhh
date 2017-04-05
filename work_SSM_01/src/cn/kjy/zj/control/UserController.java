package cn.kjy.zj.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.kjy.zj.biz.IUserBiz;
import cn.kjy.zj.pojo.User;

@Controller
@RequestMapping("uc")
public class UserController {
	private IUserBiz userBizImpl;
	@RequestMapping(value="cl",method=RequestMethod.POST)
	public String checkLogin(User user,HttpSession session){
		User u = userBizImpl.checkLogin(user);
		String myurl="index";
		if(u!=null){
			myurl="main";
			//myurl="forward:/ec/findemp";//显示全部
			//myurl="forward:/ec/empsplit";//分页显示
			session.setAttribute("u", u);
		}
		return myurl;
	}
	public IUserBiz getUserBizImpl() {
		return userBizImpl;
	}
	public void setUserBizImpl(IUserBiz userBizImpl) {
		this.userBizImpl = userBizImpl;
	}
	
}

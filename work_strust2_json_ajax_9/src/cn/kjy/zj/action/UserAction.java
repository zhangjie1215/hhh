package cn.kjy.zj.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
		private String uname;
		private String res;
		
		/**
		 * 验证用户名是否可用
		 * @return
		 */
		public String checkname(){
			boolean flag=false;
			if(uname.equals("zhangsan")){
				flag=true;
			}
			res=flag+"";
			return "success";
		}
		/**
		 * 注册验证
		 * @return
		 */
		public String isreg(){
			if(uname.equals("zhangsan")){
				return  "input";
			}
			return "success";
		}
		
		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}
	
		public String getRes() {
			return res;
		}
		public void setRes(String res) {
			this.res = res;
		}
}

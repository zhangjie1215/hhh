package cn.kjy.zj.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
		private String uname;
		private String res;
		
		/**
		 * ��֤�û����Ƿ����
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
		 * ע����֤
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

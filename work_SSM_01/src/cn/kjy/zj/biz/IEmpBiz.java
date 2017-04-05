package cn.kjy.zj.biz;

import java.util.List;

import cn.kjy.zj.pojo.Emp;

public interface IEmpBiz {
	public List<Emp> findAllEmp();
	public List<Emp> findEmpSplit(int pn,int ps);	
	public int getCount();
	public int checkName(String name);
}

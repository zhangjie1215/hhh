package cn.kjy.zj.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.kjy.zj.biz.IEmpBiz;
import cn.kjy.zj.dao.IEmpDao;
import cn.kjy.zj.pojo.Emp;
@Service
public class EmpBizImpl implements IEmpBiz{
	private IEmpDao empDaoImpl;
	@Override
	public List<Emp> findAllEmp() {
		return empDaoImpl.findAllEmp();
	}
	public void setEmpDaoImpl(IEmpDao empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}
	public IEmpDao getEmpDaoImpl() {
		return empDaoImpl;
	}
	@Override
	public List<Emp> findEmpSplit(int pn, int ps) {
		return empDaoImpl.findEmpSplit(pn, ps);
	}
	@Override
	public int getCount() {
		return empDaoImpl.getCount();
	}
	@Override
	public int checkName(String name) {
		return empDaoImpl.checkName(name);
	}
}

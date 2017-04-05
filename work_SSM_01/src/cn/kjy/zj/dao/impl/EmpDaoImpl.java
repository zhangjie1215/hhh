package cn.kjy.zj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.kjy.zj.dao.IEmpDao;
import cn.kjy.zj.pojo.Emp;
@Repository
public class EmpDaoImpl extends SqlSessionDaoSupport implements IEmpDao{

	@Override
	public List<Emp> findAllEmp() {
		return super.getSqlSession().selectList("cn.kjy.zj.pojo.Emp.findAllEmp");
	}

	@Override
	public List<Emp> findEmpSplit(int pn, int ps) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("pn",(pn-1)*ps);
		map.put("ps", ps);
		return super.getSqlSession().selectList("cn.kjy.zj.pojo.Emp.findEmpSplit",map);
	}

	@Override
	public int getCount() {
		return super.getSqlSession().selectOne("cn.kjy.zj.pojo.Emp.findEmpCount");
	}

	@Override
	public int checkName(String name) {
		return super.getSqlSession().selectOne("cn.kjy.zj.pojo.Emp.checkName", name);
	}

}

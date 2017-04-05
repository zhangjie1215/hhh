package cn.kjy.zj.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.kjy.zj.dao.IDeptDao;
import cn.kjy.zj.pojo.Dept;
@Repository
public class DeptDaoImpl extends SqlSessionDaoSupport implements IDeptDao{

	@Override
	public List<Dept> findAllDept() {
		return super.getSqlSession().selectList("cn.kjy.zj.pojo.Dept.findAllDept");
	}

}

package cn.kjy.zj.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kjy.zj.biz.IDeptBiz;
import cn.kjy.zj.dao.IDeptDao;
import cn.kjy.zj.pojo.Dept;
@Service
public class DeptBizImpl implements IDeptBiz{
	@Autowired
	private IDeptDao deptDaoImpl;
	@Override
	public List<Dept> findAllDept() {
		return deptDaoImpl.findAllDept();
	}

}

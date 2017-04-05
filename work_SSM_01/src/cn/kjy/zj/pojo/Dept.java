package cn.kjy.zj.pojo;

import java.util.List;

public class Dept implements java.io.Serializable {

	private Integer deptno;
	private String dname;
	private List<Emp> emps;

	public Dept() {
	}

	public Dept(String dname, List<Emp> emps) {
		this.dname = dname;
		this.emps = emps;
	}

	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

}

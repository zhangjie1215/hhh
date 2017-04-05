package cn.kjy.zj.pojo;

public class Emp {
	private Integer empid;
	private String  ename;
	private String  job;
	private Dept dept;
 	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Dept getDept() {
		return dept;
	}
	
}

package cn.kjy.zj.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.kjy.zj.biz.IDeptBiz;
import cn.kjy.zj.biz.IEmpBiz;
import cn.kjy.zj.pojo.Dept;
import cn.kjy.zj.pojo.Emp;

@Controller
@RequestMapping("ec")
public class EmpController {
	private IEmpBiz empBizImpl;
	private IDeptBiz deptBizImpl;
	@RequestMapping(value="findemp")
	public ModelAndView findAllEmp(Model model){
		ModelAndView mav=new ModelAndView();
		System.out.println("进入findAllEmp方法");
		List<Emp> emplist = empBizImpl.findAllEmp();
		System.out.println(emplist.size());
		model.addAttribute("emplist", emplist);
		String myurl="main";
		mav.setViewName(myurl);
		return mav;
	}
	@RequestMapping(value="doget")
	public String doGet(){
		return "redirect:/ec/empsplit";
		//return "forward:/ec/empsplit";
	}
	@RequestMapping(value="empsplit",method=RequestMethod.POST)
	public String findEmpSplit(Model model,Integer ps,Integer pn){
		if(ps==null||pn==null){
			pn=1;
			ps=2;
		}
		List<Emp> emplist =empBizImpl.findEmpSplit(pn, ps);
		int count = empBizImpl.getCount();
		int emppage=(count-1)/ps+1;
		model.addAttribute("emplist", emplist);
		model.addAttribute("count", count);
		model.addAttribute("emppage", emppage);
		model.addAttribute("pn", pn);
		model.addAttribute("ps", ps);
		return "emplist";
	}
	@RequestMapping("addemp")
	public String addEmp(Model model){
		List<Dept> deptlist = deptBizImpl.findAllDept();
		model.addAttribute("deptlist",deptlist);
		return "addemp";
	}
	/*@RequestMapping(value="checkname",method=RequestMethod.POST)
	public void checkName(String ename ,HttpServletResponse response){
		int count = empBizImpl.checkName(ename);
		System.out.println(ename);
		boolean flag=count>0?true:false;
		PrintWriter writer =null;
		try {
			writer = response.getWriter();
			writer.print(flag);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}*/
	
	@RequestMapping(value="checkname",method=RequestMethod.POST)
	public @ResponseBody String checkname(String ename){
		int count = empBizImpl.checkName(ename);
		boolean flag=count>0?true:false;
		return flag+"";
	}
	public void setEmpBizImpl(IEmpBiz empBizImpl) {
		this.empBizImpl = empBizImpl;
	}
	public IEmpBiz getEmpBizImpl() {
		return empBizImpl;
	}
	public void setDeptBizImpl(IDeptBiz deptBizImpl) {
		this.deptBizImpl = deptBizImpl;
	}
	public IDeptBiz getDeptBizImpl() {
		return deptBizImpl;
	}
}

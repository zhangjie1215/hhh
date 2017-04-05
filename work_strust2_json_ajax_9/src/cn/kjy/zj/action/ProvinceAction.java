package cn.kjy.zj.action;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.kjy.zj.dao.HatProvinceDao;
import cn.kjy.zj.dao.impl.HatProvinceDaoImpl;
import cn.kjy.zj.pojo.HatCity;
import cn.kjy.zj.pojo.HatProvince;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class ProvinceAction extends ActionSupport{
	private HatProvinceDao hpd=new HatProvinceDaoImpl();
	private String res;
	private String provinceid;
	
	public String findAllprovince(){
		List<HatProvince> prolist = hpd.findAll();
		//将list集合转换为json格式 有三种方法
		/*
		 * 第一种
		 */
		JSONArray arr=new JSONArray();
		for (int i = 0; i < prolist.size(); i++) {
			HatProvince pro=prolist.get(i);
			JSONObject obj=new JSONObject();
			try {
				obj.put("provinceId", pro.getProvinceId());
				obj.put("province", pro.getProvince());
				//obj.put("hatCities", pro.getHatCities());
				arr.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		res=arr.toString();
		/*
		 * 第二种：gson转换方法（谷歌提供）
		 */
		//String arr=new Gson().toJson(prolist);
		/*
		 * 第三种：fastjson转换方法（阿里巴巴提供）
		 */
		//res=JSON.toJSONString(prolist);
		
		return "success";
	}
	
	public String findCitsByProId(){
		List<HatCity> citylist=hpd.findHatCilyByProvinceId(provinceid);
		/*for (int i = 0; i < citylist.size(); i++) {
			HatCity h=citylist.get(i);
			System.out.println(h);
		}*/
		JSONArray arr=new JSONArray();
		for (int i = 0; i < citylist.size(); i++) {
			HatCity cit=citylist.get(i);
			JSONObject obj=new JSONObject();
			try {
				obj.put("cityId", cit.getCityId());
				obj.put("city", cit.getCity());
				//obj.put("hatCities", pro.getHatCities());
				arr.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			}
		res=arr.toString();
		return "success";
	}
	public String getRes() {
		return res;
	}


	public void setRes(String res) {
		this.res = res;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
}

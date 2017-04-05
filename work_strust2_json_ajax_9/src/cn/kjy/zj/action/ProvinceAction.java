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
		//��list����ת��Ϊjson��ʽ �����ַ���
		/*
		 * ��һ��
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
		 * �ڶ��֣�gsonת���������ȸ��ṩ��
		 */
		//String arr=new Gson().toJson(prolist);
		/*
		 * �����֣�fastjsonת������������Ͱ��ṩ��
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

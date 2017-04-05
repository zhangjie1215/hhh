package cn.kjy.zj.action;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import cn.kjy.zj.dao.HatCityDao;
import cn.kjy.zj.dao.impl.HatCityDaoImpl;
import cn.kjy.zj.pojo.HatArea;
import cn.kjy.zj.pojo.HatCity;

public class CityAction {
	private HatCityDao hcd=new HatCityDaoImpl();
	private String cityid;
	private String res;
	private String kw;
	/**
	 * 根据城市主键查询所有县/区
	 * @return
	 */
	public String findAeraByCityId(){
		List<HatArea> aeralist = hcd.findHatAreaByCityId(cityid);
		JSONArray arr=new JSONArray();
		for (int i = 0; i < aeralist.size(); i++) {
			HatArea hatAera=aeralist.get(i);
			JSONObject obj=new JSONObject();
			try {
				obj.put("areaId", hatAera.getAreaId());
				obj.put("area", hatAera.getArea());
				arr.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		res=arr.toString();
		return "success";
	}
	public String searchByKw(){
		List<HatCity> citylist = hcd.findHatCityByKw(kw);
		JSONArray arr=new JSONArray();
		for (int i = 0; i < citylist.size(); i++) {
			HatCity city = citylist.get(i);
			JSONObject obj=new JSONObject();
			try {
				obj.put("cityId", city.getCityId());
				obj.put("city", city.getCity());
				arr.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		res=arr.toString();
		//res=JSON.toJSONString(citylist);
		//res=new Gson().toJson(citylist);
		return "success";
	}
	
	public void setRes(String res) {
		this.res = res;
	}
	public String getRes() {
		return res;
	}


	public String getCityid() {
		return cityid;
	}


	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getKw() {
		return kw;
	}
	public void setKw(String kw) {
		this.kw = kw;
	}
	
	
}

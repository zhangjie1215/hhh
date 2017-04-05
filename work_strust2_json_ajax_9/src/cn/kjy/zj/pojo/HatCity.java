package cn.kjy.zj.pojo;

// Generated 2017-3-14 17:39:57 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * HatCity generated by hbm2java
 */
public class HatCity implements java.io.Serializable {

	private String cityId;
	private HatProvince hatProvince;
	private Integer id;
	private String city;
	private Set<HatArea> hatAreas = new HashSet<HatArea>(0);

	public HatCity() {
	}

	public HatCity(String cityId, Integer id) {
		this.cityId = cityId;
		this.id = id;
	}

	public HatCity(String cityId, HatProvince hatProvince, Integer id, String city,
			Set<HatArea> hatAreas) {
		this.cityId = cityId;
		this.hatProvince = hatProvince;
		this.id = id;
		this.city = city;
		this.hatAreas = hatAreas;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public HatProvince getHatProvince() {
		return this.hatProvince;
	}

	public void setHatProvince(HatProvince hatProvince) {
		this.hatProvince = hatProvince;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<HatArea> getHatAreas() {
		return this.hatAreas;
	}

	public void setHatAreas(Set<HatArea> hatAreas) {
		this.hatAreas = hatAreas;
	}

}

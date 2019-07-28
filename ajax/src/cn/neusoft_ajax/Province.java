package cn.neusoft_ajax;

import java.util.ArrayList;
import java.util.List;

public class Province {

	private String id;
	private String name;
	private List<City> citys=new ArrayList<City>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(String id) {
		super();
		this.id = id;
	}
	
}

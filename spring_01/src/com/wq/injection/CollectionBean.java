package com.wq.injection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionBean  {
	private Object[] objects;//数组注入
	
	private List list;//list注入(set注入相同)
	
	private Map map;//map注入
	
	
	private Properties properties;//properties注入


	public Object[] getObjects() {
		return objects;
	}


	public void setObjects(Object[] objects) {
		this.objects = objects;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public Properties getProperties() {
		return properties;
	}


	public void setProperties(Properties properties) {
		this.properties = properties;
	}


	@Override
	public String toString() {
		return "CollectionBean [objects=" + Arrays.toString(objects) + ", list=" + list + ", map=" + map
				+ ", properties=" + properties + "]";
	}
	

}

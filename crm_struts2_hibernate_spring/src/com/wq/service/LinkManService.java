package com.wq.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wq.entity.LinkMan;

public interface LinkManService {
	
	List<LinkMan> lkmListService(DetachedCriteria dc);
  
	void addLinkMan(LinkMan man,Long custId);
}

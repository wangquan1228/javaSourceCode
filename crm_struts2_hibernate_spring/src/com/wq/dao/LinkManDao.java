package com.wq.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wq.entity.Customer;
import com.wq.entity.LinkMan;

public interface LinkManDao {

	List<LinkMan> list(DetachedCriteria dc);

	void addLinkMan(LinkMan man, Long custId);

}

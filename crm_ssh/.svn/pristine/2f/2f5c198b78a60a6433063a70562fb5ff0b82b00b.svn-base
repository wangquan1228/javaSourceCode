package com.wq.service.impl;

import com.wq.bean.LinkMan;
import com.wq.dao.LinkManDao;
import com.wq.service.LinkManService;

public class LinkManServiceImpl  implements LinkManService{
    
    //注入
    private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    @Override
    public void saveLinkMan(LinkMan linkMan) {
       linkManDao.save(linkMan);
    }

    @Override
    public void updateLinkMan(Long cust_id) {
        // TODO Auto-generated method stub
        linkManDao.updateLinkMan(cust_id);
    }

     
    

}

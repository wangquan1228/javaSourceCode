package com.wq.action;

  
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
import com.wq.bean.LinkMan;
 
import com.wq.service.LinkManService;
 

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //模型驱动
    LinkMan linkMan=new LinkMan();

    @Override
    public LinkMan getModel() { 
        return linkMan;
    }
     
    //注入linkManService
    private LinkManService linkManService;

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }
    
    public String saveLinkMan() {
        
        linkManService.saveLinkMan(linkMan);
        return "success";
    }
}

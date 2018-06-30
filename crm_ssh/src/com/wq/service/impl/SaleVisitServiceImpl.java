package com.wq.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wq.bean.LinkMan;
import com.wq.bean.SaleVisit;
import com.wq.dao.SaleVisitDao;
import com.wq.service.SaleVisitService;
import com.wq.util.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService{
   //注入 
    private SaleVisitDao saleVisitDao;

    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
        this.saleVisitDao = saleVisitDao;
    }

    @Override
    public void saveSaleVisit(SaleVisit saleVisit) {
        saleVisitDao.save(saleVisit);
        
    }
    
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        // 1 调用Dao的查询总记录数
        Integer totalCount = saleVisitDao.getByTotalCount(dc);
        // 2 创建PageBean
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        // 3 调用 Dao的查询分页列表数据

        List<SaleVisit> list = saleVisitDao.getPageList(dc, pb.getStart(), pb.getPageSize());
        // 4 列表数据放入pageBean中,并返回
        pb.setList(list);
        return pb;
    }

    @Override
    public SaleVisit geSaletVisitById(String visit_id) {
        SaleVisit saleVisit = saleVisitDao.getById(visit_id);
        return saleVisit;
    }

    @Override
    public void updateSaleVisit(SaleVisit saleVisit) {
        saleVisitDao.update(saleVisit);
    }

    @Override
    public void deleteSaleVisit(SaleVisit saleVisit) {
      saleVisitDao.delete(saleVisit);
        
    }
    
}

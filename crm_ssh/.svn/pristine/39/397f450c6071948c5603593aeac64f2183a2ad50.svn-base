package com.wq.service.impl;

import java.util.List;

import com.wq.bean.BaseDict;
import com.wq.dao.BaseDictDao;
import com.wq.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{
    
    private BaseDictDao baseDictDao;
    
    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    @Override
    public List<BaseDict> getListByTpyeCode(String dict_type_code) {
         
        return baseDictDao.getListByTypeCode(dict_type_code);
    }

}

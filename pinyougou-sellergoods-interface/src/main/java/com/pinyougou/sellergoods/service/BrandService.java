package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<TbBrand> findall();

    public PageResult findPage(int pageNum, int pageSize);

    public int addbrand(TbBrand tbBrand);

    public TbBrand findOne(long id);

    public int update(TbBrand tbBrand);

    public void delete(long[] ids);

    public PageResult seach(TbBrand tbBrand,int pageNum,int pageSize);
    List<Map> selectOptionList();
}

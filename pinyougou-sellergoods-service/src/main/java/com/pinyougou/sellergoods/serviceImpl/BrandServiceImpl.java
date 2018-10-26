package com.pinyougou.sellergoods.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    //不分页查询
    @Override
    public List<TbBrand> findall() {
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        return tbBrands;
    }

    //分页查询
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());

        return pageResult;
    }

    //添加
    @Override
    public int addbrand(TbBrand tbBrand) {
        int insert = tbBrandMapper.insert(tbBrand);

        return insert;
    }

    //根据id查询
    @Override
    public TbBrand findOne(long id) {
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    //修改
    @Override
    public int update(TbBrand tbBrand) {
        int i = tbBrandMapper.updateByPrimaryKey(tbBrand);
        return i;
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult seach(TbBrand tbBrand, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null) {

            if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {

                criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
            }
            Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
            return new PageResult(page.getTotal(), page.getResult());
        }
        return findPage(pageNum,pageSize);
    }

    @Override
    public List<Map> selectOptionList() {
        return tbBrandMapper.selectOptionList();
    }
}

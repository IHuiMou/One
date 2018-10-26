package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findall();
    }

    @RequestMapping("/findPage")
    public PageResult pagefind(int page, int rows) {

        PageResult pageResult = brandService.findPage(page, rows);
        return pageResult;
    }

    @RequestMapping("/add")
    public Result addbrand(@RequestBody TbBrand brand) {

        System.out.println();
        try {

            int addbrand = brandService.addbrand(brand);
            Result result = new Result(true, "增加成功");
            return result;
        } catch (Exception e) {

            Result result = new Result(false, "增加失败");
            e.printStackTrace();
            return result;
        }

    }

    @RequestMapping("/findOne")
    public TbBrand findOne(long id) {
        return brandService.findOne(id);

    }

    @RequestMapping("/update")
    public Result updatebrand(@RequestBody TbBrand tbBrand) {
        try {
            int i = brandService.update(tbBrand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result deleteBrand(long[] ids) {

        try {
            brandService.delete(ids);
            return new Result(true, "清除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "清除成功");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, int page, int rows) {

        PageResult seach = brandService.seach(brand, page, rows);
        return seach;
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }

}
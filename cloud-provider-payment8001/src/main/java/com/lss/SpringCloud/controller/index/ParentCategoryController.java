package com.lss.SpringCloud.controller.index;

import com.lss.SpringCloud.entities.FindRecommendGoods;
import com.lss.SpringCloud.entities.ParentCategory;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.ParentCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 15:11
 * @Param:
 * @Return:
 * @Description:
 **/


@RestController
@Slf4j
public class ParentCategoryController {

    @Autowired
    private ParentCategoryService parentCategoryService;
    /// 注入UserService而不是UserMapper直接使用，除非你有特定的需求直接使用Mapper接口在控制器中。通常建议在服务层处理数据库逻辑。


    @GetMapping(value = "/index/ParentCategory")
    public ResultData<List<ParentCategory>> getAll() {
        //通过服务层调用，而不是直接在控制器中调用Mapper。这样可以更好地遵循单一职责原则和分离关注点。
        List<ParentCategory> all = parentCategoryService.findAllWithChildrenCategories();
        return ResultData.success(all);
    }

    @GetMapping(value = "/index/findCategoryTree")
    public ResultData<List<ParentCategory>> findCategoryTree() {
        //通过服务层调用，而不是直接在控制器中调用Mapper。这样可以更好地遵循单一职责原则和分离关注点。
        List<ParentCategory> all = parentCategoryService.selectAll();
        return ResultData.success(all);
    }
}

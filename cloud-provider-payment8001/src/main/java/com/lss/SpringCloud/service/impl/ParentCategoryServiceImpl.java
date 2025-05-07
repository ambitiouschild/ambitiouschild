package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.ParentCategory;
import com.lss.SpringCloud.mapper.ParentCategoryMapper;
import com.lss.SpringCloud.service.index.ParentCategoryService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.code.ORDER;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 14:56
 * @Param:
 * @Return:
 * @Description:
 **/

@Service
public class ParentCategoryServiceImpl implements ParentCategoryService {


    //@Resource和@Autowired的区别导致的了
    // @Resource默认按byName注入，
    // @Autowired默认按byType注入。

    @Resource
    private ParentCategoryMapper parentCategoryMapper;


    //使用mybatis框架在xml文件中编写相应的SQL，正规操作有一个mapper就需要对应一个xml文件，累积下来就有很多文件，
    // 处理起来贼繁琐，直接在对应方法上使用注解编写SQL，一定程度上可以减少开发时间，但是有一个很不好的地方，
    // 判断语句或者批量操作是需要手动添加<script></script>,这个无法自动生成，需要对这个比较熟悉才能上手


    //程序内只创建了一个SQL，通过 in 编号列表去循环匹配，千万不要用去套用整个SQL，
    // 那样每一个编号就会创建一个SQL，效率很低，造成没有必要的数据库压力


    //MyBatis提供了灵活的方式来处理多表查询，无论是通过XML映射文件、注解还是动态SQL，
    // 都可以根据实际需求选择最合适的方法。确保你的SQL语句正确无误，并且结果映射与你的Java对象模型相匹配。
    @Override
    public List<ParentCategory> findAllWithChildrenCategories() {
        return parentCategoryMapper.selectAllparent();
    }

    @Override
    public List<ParentCategory> selectAll() {
        return parentCategoryMapper.selectAll();
    }


}

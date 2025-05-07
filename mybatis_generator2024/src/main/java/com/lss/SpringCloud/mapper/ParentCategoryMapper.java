package com.lss.SpringCloud.mapper;

import com.lss.SpringCloud.entities.ParentCategory;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ParentCategoryMapper extends Mapper<ParentCategory> {


    @Select("<script>"
            + "select DISTINCT p.id as id, p.name as name,"
            + " c.id as id, c.imageUrl as imageUrl, c.`name` as name, c.parent_id as parent_id"
            +  "  from parentcategory p LEFT JOIN childrencategory c"
            + "  ON p.id = c.parent_id ORDER BY p.id ASC"
            + "</script>")


//    @Select("select DISTINCT p.id as parentId, p.name as parentName,c.id as childId, c.imageUrl as imageUrl, c.`name` as childName, c.parent_id as parent_id from parentcategory p LEFT JOIN childrencategory c ON p.id = c.parent_id ORDER BY p.id ASC")

    public List<ParentCategory> selectAllparent();

}
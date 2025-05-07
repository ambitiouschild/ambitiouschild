package com.lss.SpringCloud.mapper;

import com.lss.SpringCloud.entities.ChildrenCategory;
import com.lss.SpringCloud.entities.ParentCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 15:45
 * @Param:
 * @Return:
 * @Description:
 **/
@Repository
public interface ParentCategoryMapper extends Mapper<ParentCategory> {


    @Select("<script>"
            + "select  p.categorylistid as categoryListid, p.categorylist as categoryList,"
            + " c.id as id, c.imageurl as imageUrl, c.`name` as name, c.parent_id as parent_id"
            +  "  from parentcategory p LEFT JOIN childrencategory c"
            + "  ON p.categorylistid = c.parent_id ORDER BY p.categorylistid ASC"
            + "</script>")

    //子分类的数据直接嵌入在父分类的 SQL 查询中，通过 LEFT JOIN 一次性获取所有父子分类数据，
    // 然后通过 MyBatis 的映射规则自动将子分类分组到父分类的 childCategories 集合中。

    //检查实体类字段映射确保 ParentCategory 实体类的属性名与 SQL 查询结果的列名完全一致。
    @Results(value = {
            @Result(property = "categoryListId", column = "categoryListId"), // 父分类 ID
            @Result(property = "categoryList", column = "categoryList"), // 父分类名称
            @Result(
                    property = "childCategories", // 包含子分类集合
                    column = "categoryListId",  // 将父分类的 id 传递给子查询,// 根据父分类 ID 分组
                    javaType = List.class,
                    many = @Many(select = "findChildCategoriesByParentId")
            )
    })


    //如果使用 @Many + 子查询，MyBatis 会先查询父分类，然后对每个父分类触发子查询，可能导致性能问题（N+1 查询）。
    //优化方案：改用单次查询，手动处理映射（单次查询）
    //如果数据量较大，建议使用单次查询并手动映射结果，避免多次查询。
    public List<ParentCategory> selectAllparent();

    // 根据父分类 id 查询子分类

    //在 XML 或接口中定义公共的 childCategoryMap


    // 定义子分类的映射规则
    @Select("SELECT id, imageurl ,name, parent_id FROM childrencategory WHERE parent_id = #{parentId}")
    @Results(value ={
            @Result(property = "id", column = "id"),// 子分类 ID
            @Result(property = "imageUrl", column = "imageUrl"), // 子分类名称
            @Result(property = "name", column = "name"),
            @Result(property = "parentId", column = "parent_id")// 父分类 ID（外键）
    })

    public List<ChildrenCategory> findChildCategoriesByParentId(Integer parentId);
//    List<ChildrenCategory> mapChildCategories();

//    void mapChildCategories(); // 仅定义映射规则，不执行查询
//



//单次查询优化：通过 LEFT JOIN 一次性获取所有数据，避免了多次查询数据库（N+1 问题）。
//自动分组：MyBatis 根据 parent_id 自动将子分类数据分组到对应的父分类中。
//性能优势：单次查询减少了数据库连接开销，适合数据量较大的场景。

//MyBatis 的 @Many + resultMap 可以通过单次 JOIN 查询实现 父子嵌套集合映射。
//核心逻辑是：根据父分类 ID 分组，自动收集子分类数据。
//优势是避免 N+1 查询，性能更高。

    //手动映射未覆盖所有字段：
    //若未在 @Results 中显式映射所有字段（如 parentId 未映射到 childParentId），MyBatis 无法自动填充数据。
    // 定义子分类的映射规则
    @Results(id="childrenCategoryMap", value = {
            @Result(property = "id", column = "id", id = true),// 子分类 ID
            @Result(property = "imageUrl", column = "imageUrl"), // 子分类名称
            @Result(property = "name", column = "name"),
            @Result(property = "parentId", column = "parent_id")// 父分类 ID（外键）
    })
    void mapChildCategories(); // 方法体为空，仅用于定义映射

//‌字段冲突‌ - 父子表存在相同的字段名（如id），导致映射混乱
    @Select("""
           <script>
           SELECT
               p.categorylistid AS categoryListId, -- ✅ 别名与实体类属性名一致
               p.categorylist AS categoryList,
               c.id AS id,  -- 添加子类字段前缀
               c.imageurl AS imageUrl,
               c.`name` AS name,
               c.parent_id AS parent_id
           FROM parentcategory p
           LEFT JOIN childrencategory c ON p.categorylistid = c.parent_id
           ORDER BY p.categorylistid ASC
           </script>
           """)
    @Results({
    //确保数据库字段与Java属性命名规范一致（注意驼峰转换）
    // 标识父类主键（关键配置）
    @Result(property = "categoryListId", column = "categoryListId"), // 父分类 ID
    @Result(property = "categoryList", column = "categoryList"), // 父分类名称
    @Result(
            property = "childCategories", // 包含子分类集合
            column = "categoryListId",  // 将父分类的 id 传递给子查询,// 根据父分类 ID 分组
            javaType = List.class,
            // 关键配置：声明字段前缀 + 引用子映射
            //核心配置：通过 column = "categoryListId" 传递父分类ID，MyBatis 自动根据此值将子分类分组到对应的父分类中。
            many = @Many(resultMap = "com.lss.SpringCloud.mapper.ParentCategoryMapper.childrenCategoryMap") // 引用子分类映射规则
    )
    })

    List<ParentCategory> selectAll();

}
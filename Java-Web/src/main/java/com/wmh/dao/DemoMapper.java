package com.wmh.dao;


import com.wmh.dto.DemoDto;
import com.wmh.dto.DemoExportReqVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// @Repository 主要作用：组件扫描和自动装配、异常转换（重要特性）
@Repository
public interface DemoMapper {
    List<DemoDto> allDemo();

    int deleteByPrimaryKey(Integer id);

    // @Param("ids") 将方法参数 List<Integer> ids 指定为 SQL 查询中的别名 ids。在 MyBatis 的 SQL 配置中，可以通过 #{ids} 引用这个参数。
    int deleteBatchByIds(@Param("ids") List<Integer> ids);

    List<DemoDto> listByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<DemoExportReqVo> selectList(DemoExportReqVo demoExportReqVo);

    int total();

    int insertSelective(DemoDto record);

    DemoDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DemoDto record);
}
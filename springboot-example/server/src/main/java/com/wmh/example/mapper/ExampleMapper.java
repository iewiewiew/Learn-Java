package com.wmh.example.mapper;

import com.wmh.example.dto.ExampleDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
  * @author      weimenghua
  * @time        2024-12-10 08:41
  * @description
  */
@Repository
public interface ExampleMapper {
    // Mapper 接口的方法名称和 Mapper.xml 的 id 值对应

    ExampleDto getById(long id);

    List<ExampleDto> getAll();

    List<ExampleDto> listByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    int total();

    void insert(ExampleDto exampleDto);

    void update(ExampleDto exampleDto);

    void delete(long id);
}

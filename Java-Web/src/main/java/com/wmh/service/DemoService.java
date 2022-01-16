package com.wmh.service;

import com.wmh.dto.DemoDto;
import com.wmh.dto.DemoExportReqVo;
import javax.validation.Valid;
import java.util.List;

/**
 * @author weimenghua
 * @date 2021-11-14 13:26
 */

public interface DemoService {

    /**
     * 列表查询
     */
    List<DemoDto> allDemo();

    /**
     * 分页查询
     */
    List<DemoDto> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 导出 Excel
     */
    List<DemoExportReqVo> getDemoList(DemoExportReqVo demoExportReqVo);

    /**
     * 查询总数
     */
    int total();
    
    /**
     * 根据条件查找
     */
    DemoDto findDemoById(Integer id);

    /**
     * 新增
     */
    String addDemo(DemoDto demoDto);

    /**
     * 删除
     */
    boolean deleteDemo(Integer id);

    /**
     * 批量删除
     */
    int deleteBatch(List<Integer> ids);

    /**
     * 更新
     */
    boolean updateDemo(DemoDto demoDto);
}

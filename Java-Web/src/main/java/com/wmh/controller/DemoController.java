package com.wmh.controller;

import com.alibaba.excel.EasyExcel;
import com.wmh.common.CommonResult;
import com.wmh.dto.DemoDto;
import com.wmh.dto.DemoExportReqVo;
import com.wmh.service.impl.DemoServiceImpl;
import com.wmh.utils.EncryptId;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author weimenghua
 * @date 2021-11-14 14:18
 *
 * 接口请求时params与data的区别：
 * GET请求时，使用params，参数会直接追加至请求字符串(url)后。
 * POST请求时，使用data（也可以使用params），参数是添加到请求体(body)的。
 * 只要使用params get与post请求基本是一样使用的，如果参数名与传递名称不一致，需要使用@RequestParam修饰，若使用Map接收参数，必须使用@RequestParam修饰。
 * 若使用data传递参数，必须使用一个实体类接收参数，而且需要添加注解@RequestBody进行修饰。
 *
 * 如果需要去掉 CommonResult 返回，同步需要去掉方法返回类型 CommonResult
 */

@Api(tags = "Demo 模块")
@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoServiceImpl demoService;

    /**
     * 列表查询
     */
    @ApiOperation(value = "查询 Demo")
    @ResponseBody
    @GetMapping(value = "list")
    public Object allDemo() {
        return demoService.allDemo();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询 Demo")
    @ResponseBody
    @PostMapping(value = "listByPage")
//  CommonResult 先注释，页面渲染不正常   
//    public CommonResult<Map<String, Object>> listByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
    public Map<String, Object> listByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        // 计算数据库中需要的起始位置
        int offset = (pageNum - 1) * pageSize;

        // 获取总记录数
        Integer total = demoService.total();

        // 根据分页参数获取数据
        List<DemoDto> data = demoService.listByPage(offset, pageSize);

        // 构建返回结果
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);

        // 返回成功结果
        return res;
    //    return CommonResult.success(200, "成功", res);
    }

    /**
     * 根据id查找数据
     */
    @ApiOperation(value = "查找 Demo")
    @Validated
    @GetMapping(value = "list/{id}")
    public DemoDto findDemoById(@PathVariable @NotNull String id) {
        DemoDto res = demoService.findDemoById(Integer.valueOf(id));
        return res;
    }

    /**
     * 新增
     */
//    @ApiImplicitParams({
//       @ApiImplicitParam(name = "username", value = "姓名", required = true),
//       @ApiImplicitParam(name = "password", value = "密码", required = true)
//    })
    @ApiOperation(value = "新增 Demo")
    @ResponseBody
    @PostMapping(value = "/add")
    //在接口需要校验的参数上加上@Valid注解
    public Object addDemo(@RequestBody @Valid DemoDto demoDto) {
        String res = demoService.addDemo(demoDto);
        return res;
    }

    /**
     * 删除
     *
     * @PathVariable: URL路径参数，比如/delete/{id}中的id参数
     */
    @ApiOperation(value = "删除 Demo")
    @ResponseBody
    @DeleteMapping(value = "delete/{id}")
    public Object deleteDemo(@PathVariable @Validated @EncryptId String id) {
        if (!id.isEmpty()) {
            boolean result = demoService.deleteDemo(Integer.valueOf(id));
            return result? "删除成功": "删除失败";
        } else {
            return "参数为空！";
        }
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/deleteBatch")
    @ApiOperation(value = "批量删除 Demo 数据", notes = "根据 ID 列表批量删除")
    public ResponseEntity<String> deleteBatch(@RequestBody DemoDto demo) {
        List<Integer> ids = demo.getIds();

        int deletedCount = demoService.deleteBatch(ids);
        return ResponseEntity.ok("成功删除 " + deletedCount + " 条记录！");
    }

    /**
     * 更新
     */
    @ApiOperation(value = "更新 Demo")
    @ResponseBody
    @PostMapping(value = "update")
    public Object updateDemo(@RequestBody DemoDto demoDto) {
        boolean res = demoService.updateDemo(demoDto);
        return res;
    }

    /**
     * 导出 Excel
     */
    @ApiOperation(value = "导出 Excel")
    @GetMapping("/export")
    public String exportDemoExcel(DemoExportReqVo demoExportReqVo) {
        // 获取数据
        List<DemoExportReqVo> list = demoService.getDemoList(demoExportReqVo);
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String fileName = "demo_" + date + ".xlsx";
        try {
            // 使用阿里 EasyExcel 导出 Excel
            EasyExcel.write(fileName, DemoExportReqVo.class).sheet("DemoData").doWrite(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导出成功: " + fileName;
    }
}

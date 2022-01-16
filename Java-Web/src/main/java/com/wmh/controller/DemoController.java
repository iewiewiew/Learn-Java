package com.wmh.controller;

import com.alibaba.excel.EasyExcel;
import com.wmh.domain.Demo;
import com.wmh.domain.DemoExportReqVo;
import com.wmh.service.impl.DemoServiceImpl;
import com.wmh.utils.EncryptId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
 */
@Api(tags = "Demo 模块")
@RestController
@RequestMapping("demo")
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
        logger.info("demo列表");
        return demoService.allDemo();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询 Demo")
    @ResponseBody
    @PostMapping(value = "listByPage")
    public Map<String, Object> listByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum = (pageNum-1)*pageSize;
        Integer total = demoService.tatol();
        List<Demo> data = demoService.listByPage(pageNum, pageSize);
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    /**
     * 根据id查找数据
     */
    @ApiOperation(value = "查找 Demo")
    @Validated
    @GetMapping(value = "list/{id}")
    public Demo findDemoById(@PathVariable @NotNull String id) {
        logger.info("根据id查找数据");
        return demoService.findDemoById(Integer.valueOf(id));
    }

    /**
     * 新增
     */
    @ApiImplicitParam(name = "username",value = "姓名",required = true)
    @ApiOperation(value = "新增 Demo")
    @ResponseBody
    @PostMapping(value = "add")
    //在接口需要校验的参数上加上@Valid注解
    public Object addDemo(@RequestBody @Valid Demo demo) {
        String res = demoService.addDemo(demo);
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
     * 更新
     */
    @ApiOperation(value = "更新 Demo")
    @ResponseBody
    @PostMapping(value = "update")
    public Object updateDemo(@RequestBody Demo demo) {
        boolean res = demoService.updateDemo(demo);
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
            EasyExcel.write(fileName, DemoExportReqVo.class).sheet("Demo Data").doWrite(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导出成功: " + fileName;
    }
}

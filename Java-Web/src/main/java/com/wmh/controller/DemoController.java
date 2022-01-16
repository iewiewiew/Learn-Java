package com.wmh.controller;

import com.wmh.domain.Demo;
import com.wmh.service.impl.DemoServiceImpl;
import com.wmh.utils.EncryptId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Api(tags = "demo模块")
@RestController
@RequestMapping("demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoServiceImpl demoService;

    /**
     * 列表查询
     */
    @ApiOperation(value = "查询demo")
    @ResponseBody
    @RequestMapping(value = "list")
    public Object allDemo() {
        logger.info("demo列表");
        return demoService.allDemo();
    }

    /**
     * 分页查询
     */
    @ApiOperation(value = "分页查询demo")
    @ResponseBody
    @RequestMapping(value ="listByPage")
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
    @Validated
    @RequestMapping(value = "list/{id}")
    public Demo findDemoById(@PathVariable @NotNull String id) {
        logger.info("根据id查找数据");
        return demoService.findDemoById(Integer.valueOf(id));
    }

    /**
     * 新增
     */
    @ApiImplicitParam(name = "username",value = "姓名",required = true)
    @ApiOperation(value = "新增demo")
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //在接口需要校验的参数上加上@Valid注解
    public Object addDemo(@RequestBody @Valid Demo demo) {
        boolean res = demoService.addDemo(demo);
        return res;
    }

    /*//在接口需要校验的参数上加上@Valid注解
    public Object addDemo(@RequestBody @Valid Demo demo, BindingResult bindingResult) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        boolean res = demoService.addDemo(demo);
        return res;
    }*/


    /**
     * 删除
     */
    @ApiOperation(value = "删除demo")
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Object deleteDemo(@RequestParam String id) {
        if (!id.isEmpty()) {
            demoService.deleteDemo(Integer.valueOf(id));
            return "删除成功";
        } else {
            return "参数为空！";
        }
    }

    /**
     * 删除
     *
     * @PathVariable: URL路径参数，比如/delete/{id}中的id参数
     */
    @ResponseBody
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Object deleteDemo2(@PathVariable @Validated @EncryptId String id) {
        if (!id.isEmpty()) {
            boolean result = demoService.deleteDemo(Integer.valueOf(id));
            if (!result){
                logger.info("删除失败");
            }else{
                logger.info("删除成功");
            }
            return result;
        } else {
            return "参数为空！";
        }
    }


    /**
     * 更新
     */
    @ApiOperation(value = "更新demo")
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object updateDemo(@RequestBody Demo demo) {
        boolean res = demoService.updateDemo(demo);
        return res;
    }
}

package com.kingschan.springboot2.el.ctrl;

import com.kingschan.springboot2.el.vo.ElVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * EL表达式练习控制器
 * @author kings.chan
 * @create 2019-01-14 11:38
 **/
@Api(description = "EL表达式")
@RequestMapping("/el")
@Slf4j
@RestController
public class ElCtrl {

    @Autowired
    private ElVo elVo;

    @ApiOperation(value = "获取vo对象", notes = "展示ELvo对象的内容")
    @GetMapping("/getVo")
    public ElVo getElVo(){
        return elVo;
    }
}

package com.kingschan.springboot2.validation.ctrl;

import com.kingschan.springboot2.validation.vo.ValidationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * spring boot 控制器效验
 * @author kings.chan
 * @create 2019-01-14 15:40
 **/
@Api(description = "控制器参数效验")
@RequestMapping("/validation")
@Slf4j
@RestController
public class ValidationCtrl {

    private ObjectError error;

    @ApiOperation(value = "保存用户", notes = "保存用户对象并效验参数")
    @PostMapping("/saveUser")
    public Object  saveUser(@RequestBody @Validated ValidationVo vo,BindingResult result){
        // 现在表示执行的验证出现错误
        if (result.hasErrors()) {
            // 获取全部错误信息
            Iterator<ObjectError> iterator = result.getAllErrors().iterator();
            while (iterator.hasNext()) {
                // 取出每一个错误
                ObjectError error = iterator.next() ;
                System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage());
            }
            return result.getAllErrors() ;
        } else {
            return vo;
        }
    }
}

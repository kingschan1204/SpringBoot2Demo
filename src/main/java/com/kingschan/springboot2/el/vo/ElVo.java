package com.kingschan.springboot2.el.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * El表达式练习  返回vo
 * @author kings.chan
 * @create 2019-01-14 11:48
 **/
@Getter
@Setter
@ApiModel(value = "ElVo", description = "EL表达式练习对象")
@Component
public class ElVo implements Serializable {
    /**
     * 从系统环境变量里取值
     */
    @Value("#{systemProperties['os.name']}")
    @ApiModelProperty(value = "操作系统名称")
    private String osName;

    /**
     * 从properties文件里取值
     */
    @Value("${info.version}")
    @ApiModelProperty(value = "工程版本号")
    private String version;
}

package com.kingschan.springboot2.validation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * 效验vo
 * @author kings.chan
 * @create 2019-01-14 15:42
 **/
@Getter
@Setter
@ApiModel(value = "ValidationVo", description = "参数效验vo")
public class ValidationVo {

    @Size(max = 4,min = 2,message = "姓名长度为2-4")
    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名")
    private String name;

    @Min(18)
    @Max(100)
    @NotNull(message = "年纪不能为空")
    @ApiModelProperty(value = "年纪")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    @NotNull(message = "邮箱不能为空！")
    @ApiModelProperty(value = "邮箱")
    private String email;

    //@Past(message = "日期格式不正确")
    @NotNull(message = "加入时间不能为空")
    @ApiModelProperty(value = "加入日期")
    private String joinDate;

    @NotNull(message = "性别不到为空")
    @ApiModelProperty(value = "性别")
    private Boolean sex;
}

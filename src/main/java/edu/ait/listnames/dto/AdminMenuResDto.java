package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: listnames
 * @description: 管理员端菜单
 * @author: lgppppppp
 * @create: 2021-04-06 21:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMenuResDto {
    private String moudleId;//学科id
    private String semesterYearId;//学期学年id
    private Integer startYear;//开始学年
    private Integer endYear;//结束学年
    private Integer semester;//学期
    private String moudleName;//学科名称
}

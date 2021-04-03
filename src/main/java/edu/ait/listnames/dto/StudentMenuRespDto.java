package edu.ait.listnames.dto;

import lombok.Data;

/**
 * @program: listnames
 * @description: 学生页面出参
 * @author: lgppppppp
 * @create: 2021-04-03 20:14
 **/
@Data
public class StudentMenuRespDto {
    private Integer startYear;//开始学年
    private Integer endYear;//结束学年
    private Integer semester;//学期

    public StudentMenuRespDto(Integer startYear, Integer endYear, Integer semester) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.semester = semester;
    }
}

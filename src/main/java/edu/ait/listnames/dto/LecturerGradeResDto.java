package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: listnames
 * @description: 教师端成绩查询
 * @author: lgppppppp
 * @create: 2021-04-06 21:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerGradeResDto {
    private String name;
    private Integer grade;
}

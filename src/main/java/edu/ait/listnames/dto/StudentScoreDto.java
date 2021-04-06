package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xgy
 * @date 2021-04-05 1:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreDto {
    private String studentId;

    private String subjectName;

    private Integer grade;

}

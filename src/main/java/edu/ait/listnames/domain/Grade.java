package edu.ait.listnames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 成绩表
 * @author: lgppppppp
 * @create: 2021-03-31 00:31
 **/
@Entity
@Table(name = "grade")
@DynamicUpdate
@NamedQuery(name = "Grade.findAll", query = "SELECT s FROM Grade s ")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Grade implements Serializable {

    private static final long serialVersionUID = -7819843800572603746L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "student_id")
    private String studentId;//学生id

    @Column(name = "moudle_id")
    private String moudleId;//学科id

    @Column(name = "semester_year_id")
    private String semesterYearId;//学期学年id

    @Column(name = "grade")
    private Integer grade;//成绩

}

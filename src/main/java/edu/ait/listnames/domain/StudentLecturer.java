package edu.ait.listnames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 学生老师关联表
 * @author: lgppppppp
 * @create: 2021-04-03 19:37
 **/
@Entity
@Table(name = "student_lecturer")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class StudentLecturer implements Serializable {

    private static final long serialVersionUID = 6253859932593621349L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "student_id")
    private String studentId;//学生id

    @Column(name = "lecturer_id")
    private String lecturerId;//导师id

}

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
 * @description: 老师-学科关联表
 * @author: lgppppppp
 * @create: 2021-04-03 19:39
 **/
@Entity
@Table(name = "lecturer_moudle")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class LecturerMoudle implements Serializable {

    private static final long serialVersionUID = -3526184792582508553L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "lecturer_id")
    private String lecturerId;//导师id

    @Column(name = "moudle_id")
    private String moudleId;//学科id

    @Column(name = "semester_year_id")
    private String semesterYearId;//学期学年id
}

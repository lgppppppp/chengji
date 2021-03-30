package edu.ait.listnames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 学期学年学科中间表
 * @author: lgppppppp
 * @create: 2021-03-30 23:21
 **/
@Entity
@Table(name = "moudle")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class SemesterYearMoudle implements Serializable {

    private static final long serialVersionUID = 6153684345618738134L;

    @Column(name = "semester_year_id")
    private String semesterYearId;//学期学年id

    @Column(name = "moudle_id")
    private String moudleId;//学科id
}

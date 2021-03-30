package edu.ait.listnames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.ait.utils.Audited;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 学期学年表
 * @author: lgppppppp
 * @create: 2021-03-30 23:15
 **/
@Entity
@Table(name = "semester_year")
@DynamicUpdate
@NamedQuery(name = "SemesterYear.findAll", query = "SELECT s FROM SemesterYear s where s.flag = 1")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class SemesterYear extends Audited implements Serializable {

    private static final long serialVersionUID = -4517819210222136913L;

    @Column(name = "start_year")
    private Integer startYear;//开始学年

    @Column(name = "end_year")
    private Integer endYear;//结束学年

    @Column(name = "semester")
    private Integer semester;//学期
}

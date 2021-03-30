package edu.ait.listnames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.ait.utils.Audited;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

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
public class SemesterYearMoudle extends Audited implements Serializable {

    private static final long serialVersionUID = 6153684345618738134L;


}

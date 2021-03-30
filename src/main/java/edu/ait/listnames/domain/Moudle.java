package edu.ait.listnames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.ait.utils.Audited;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 学课表
 * @author: lgppppppp
 * @create: 2021-03-30 23:18
 **/
@Entity
@Table(name = "moudle")
@DynamicUpdate
@NamedQuery(name = "Moudle.findAll", query = "SELECT s FROM Moudle s where s.flag = 1")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Moudle implements Serializable {

    private static final long serialVersionUID = -4432884085781947011L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "moudle_name")
    private String moudleName;//学科名称
}

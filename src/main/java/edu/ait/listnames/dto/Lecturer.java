package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 导师表
 * @author: lgppppppp
 * @create: 2021-04-03 19:33
 **/
@Entity
@Table(name = "lecturer")
@DynamicUpdate
@NamedQuery(name = "Lecturer.findAll", query = "SELECT s FROM Lecturer s ")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Lecturer implements Serializable {

    private static final long serialVersionUID = -7819965119818714595L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;//姓名

    @Column(name = "user_name")
    private String userName;//用户名

    @Column(name = "password")
    private String password;//密码

}

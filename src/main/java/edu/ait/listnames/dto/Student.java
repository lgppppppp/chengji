package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 学生表
 * @author: lgppppppp
 * @create: 2021-03-30 22:42
 **/
@Entity
@Table(name = "student")
@DynamicUpdate
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s ")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 273045115492848660L;

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

package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: listnames
 * @description: 管理员表
 * @author: lgppppppp
 * @create: 2021-04-03 19:35
 **/
@Entity
@Table(name = "admin")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = 9187606894071002939L;

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

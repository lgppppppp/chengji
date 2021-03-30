package edu.ait.listnames.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

    /**
     * 查看
     */
    @Query("select s from Student s where s.flag=1")
    Student findOneById(@Param("id") String id);
}

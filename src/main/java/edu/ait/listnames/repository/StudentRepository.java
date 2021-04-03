package edu.ait.listnames.repository;

import edu.ait.listnames.dto.Student;
import edu.ait.listnames.dto.StudentMenuRespDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String>,
        JpaSpecificationExecutor<Student> {

    /**
     * @description: //TODO 查询学生页面左边菜单栏
     * @author: lgppppppp
     * @date: 2021-04-03 19:58
     * @param:
     * @return:
     **/
    @Query(value ="select new edu.ait.listnames.dto.StudentMenuRespDto(sy.startYear, sy.endYear, sy.semester) " +
            "from Grade g left join SemesterYear sy on sy.id = g.semesterYearId where g.studentId = :id ")
    List<StudentMenuRespDto> findMenu(@Param("id") String id);
}

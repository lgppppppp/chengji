package edu.ait.listnames.repository;

import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.dto.Lecturer;
import edu.ait.listnames.dto.LecturerGradeResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LecturerRepository extends JpaRepository<Lecturer, String>,
        JpaSpecificationExecutor<Lecturer> {

    /**
     * 导师端菜单列表
     * @param id
     * @return
     */
    @Query(value =" SELECT new edu.ait.listnames.dto.LectureMenuResDto(lm.moudleId, lm.semesterYearId, m.moudleName, sy.startYear, sy.endYear, sy.semester)  FROM LecturerMoudle lm " +
            "LEFT JOIN Moudle m ON lm.moudleId = m.id LEFT JOIN SemesterYear sy ON sy.id = lm.semesterYearId WHERE lm.lecturerId = :id ")
    Page<LectureMenuResDto> findMenu(@Param("id") String id, Pageable pageable);

    /**
     * @description: //TODO 导师端查询学生成绩
     * @author: lgppppppp
     * @date: 2021-04-06 20:27
     * @param:
     * @return:
     **/
    @Query(value = " select new edu.ait.listnames.dto.LecturerGradeResDto(s.name,g.grade) from " +
            "Grade g left join Student s on s.id = g.studentId where g.semesterYearId = :id")
    Page<LecturerGradeResDto> findGrade(@Param("id") String id, Pageable pageable);
}

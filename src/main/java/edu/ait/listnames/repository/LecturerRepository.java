package edu.ait.listnames.repository;

import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.dto.Lecturer;
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
}

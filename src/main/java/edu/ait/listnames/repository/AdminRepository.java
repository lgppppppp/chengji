package edu.ait.listnames.repository;

import edu.ait.listnames.dto.Admin;
import edu.ait.listnames.dto.AdminMenuResDto;
import edu.ait.listnames.dto.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String>,
        JpaSpecificationExecutor<Admin> {

    @Query(value = "select new edu.ait.listnames.dto.AdminMenuResDto(m.id,sy.id,sy.startYear,sy.endYear,sy.semester,m.moudleName) from SemesterYear sy " +
            "left join SemesterYearMoudle sym ON sy.id = sym.semesterYearId left join Moudle m ON m.id = sym.moudleId")
    Page<AdminMenuResDto> findMenu(Pageable pageable);

    @Query(value = "select new edu.ait.listnames.dto.Student(sl.studentId,sl.studentId,sl.studentId,sl.studentId)" +
            "from StudentLecturer sl where sl.lecturerId in" +
            "(select  le.id from Lecturer le join LecturerMoudle lm on lm.lecturerId = le.id where  lm.moudleId = :moudleId )" )
    List<Student> findStudentIdList(@Param("moudleId") String moudleId);

    @Query(value = "select s from Student s" )
    List<Student> findAllStudent();
}

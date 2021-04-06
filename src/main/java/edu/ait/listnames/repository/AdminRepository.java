package edu.ait.listnames.repository;

import edu.ait.listnames.dto.Admin;
import edu.ait.listnames.dto.AdminMenuResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, String>,
        JpaSpecificationExecutor<Admin> {

    @Query(value = "select new edu.ait.listnames.dto.AdminMenuResDto(m.id,sy.id,sy.startYear,sy.endYear,sy.semester,m.moudleName) from SemesterYear sy " +
            "left join SemesterYearMoudle sym ON sy.id = sym.semesterYearId left join Moudle m ON m.id = sym.moudleId")
    Page<AdminMenuResDto> findMenu(Pageable pageable);
}

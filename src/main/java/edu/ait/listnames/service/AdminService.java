package edu.ait.listnames.service;

import edu.ait.listnames.dto.AdminMenuResDto;
import edu.ait.listnames.dto.Student;
import edu.ait.listnames.dto.StudentLecturer;
import edu.ait.listnames.repository.AdminRepository;
import edu.ait.listnames.repository.StudentLecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: listnames
 * @description: 管理员端
 * @author: lgppppppp
 * @create: 2021-04-06 22:02
 **/
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StudentLecturerRepository studentLecturerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<AdminMenuResDto> findMenu(){
        Pageable pageable = PageRequest.of(0,10);
        Page<AdminMenuResDto> page = adminRepository.findMenu(pageable);
        List<AdminMenuResDto> menuList = page.getContent();
        return menuList;
    }

    /**
     * 未选择这门课的学生
     * @param moudleId
     * @return
     */
    public List<Student> findAllStudent(String moudleId) {
        // 选择该课程的学生
        List<Student> findStudentList = adminRepository.findStudentIdList(moudleId);
        List<String>  findStudentIdList= findStudentList.stream().map(Student::getId).collect(Collectors.toList());
        // 所有学生
        List<Student> allStudent = adminRepository.findAllStudent();
        // 未选择该课程的学生
        List<Student> collect = allStudent.stream().filter(student -> {
            if (findStudentIdList.contains(student.getId())) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 已选择这门课的学生
     */
    public List<Student> findStudentDone(String moudleId){
        List<Student> findStudentList = adminRepository.findStudentIdList(moudleId);
        return  findStudentList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveLecturerStudent(List<String> studentIds,String lecturerId){
        try {
            studentIds.forEach(studentid -> {
                StudentLecturer studentLecturer = new StudentLecturer();
                studentLecturer.setStudentId(studentid);
                studentLecturer.setLecturerId(lecturerId);
                studentLecturerRepository.save(studentLecturer);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

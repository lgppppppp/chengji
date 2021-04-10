package edu.ait.listnames.service;

import edu.ait.listnames.dto.Admin;
import edu.ait.listnames.dto.Lecturer;
import edu.ait.listnames.dto.Student;
import edu.ait.listnames.repository.AdminRepository;
import edu.ait.listnames.repository.LecturerRepository;
import edu.ait.listnames.repository.StudentRepository;
import edu.ait.listnames.token.TokenDto;
import edu.ait.listnames.token.TokenThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiaoGuiYou
 */
@Service
public class LoginService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private AdminRepository adminRepository;

    public TokenDto login(String userName, String password) {
        // 学生表查询 用户名  密码一样的 获得 Student 对象
        Student student = studentRepository.login(userName,password);
        if (student != null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setType(1);
            tokenDto.setUserId(student.getId());
            TokenThreadLocal.put(tokenDto);
            return tokenDto;
        }
        // 老师表查询 用户名  密码一样的 获得 teacher 对象
        Lecturer lecturer = lecturerRepository.login(userName, password);
        if (lecturer != null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setType(2);
            tokenDto.setUserId(lecturer.getId());
            TokenThreadLocal.put(tokenDto);
            return tokenDto;
        }
        // 管理员表表查询 用户名  密码一样的 获得 admin 对象
        Admin admin = adminRepository.login(userName, password);
        if (admin != null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setType(2);
            tokenDto.setUserId(admin.getId());
            TokenThreadLocal.put(tokenDto);
            return tokenDto;
        }
        // 如果都查不到 用户名密码错误
        return null;
    }
}

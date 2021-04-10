package edu.ait.listnames.controller;

import edu.ait.listnames.dto.AdminMenuResDto;
import edu.ait.listnames.dto.Student;
import edu.ait.listnames.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: listnames
 * @description: 管理员端
 * @author: lgppppppp
 * @create: 2021-04-06 22:12
 **/
@RestController("AdminController")
@Api(value = "adminController", tags = { "admin" })
@RequestMapping("gradeSys/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**  
     * @description: //TODO 查询管理员端菜单
     * @author: lgppppppp
     * @date: 2021-04-06 23:08 
     * @param: []
     * @return: java.util.List<edu.ait.listnames.dto.AdminMenuResDto>
     **/
    @GetMapping(value = "/findMenu")
    @ResponseBody
    public List<AdminMenuResDto> findMenu() {
        List<AdminMenuResDto> menu = adminService.findMenu();
        return menu;
    }

    /**  
     * @description: //TODO 查询未选择这门课的学生
     * @author: lgppppppp
     * @date: 2021-04-06 23:07 
     * @param: [id]
     * @return: java.util.List<edu.ait.listnames.dto.Student>
     **/
    @GetMapping(value = "/findStudent")
    @ResponseBody
    public List<Student> findAllStudent(@RequestParam(value = "id", required = false)
                                            @ApiParam(name = "id", value = "id", required = false) String id) {
        List<Student> allStudent = adminService.findAllStudent(id);
        return allStudent;
    }

    /**
     * 查询已选择这门课的学生
     * @param id
     * @return
     */
    @GetMapping(value = "/findStudentDone")
    @ResponseBody
    public List<Student> findStudentDone(@RequestParam(value = "id", required = false)
                                        @ApiParam(name = "id", value = "id", required = false) String id) {
        List<Student> allDoneStudent = adminService.findStudentDone(id);
        return allDoneStudent;
    }

    /**  
     * @description: //TODO 为老师选择学生
     * @author: lgppppppp
     * @date: 2021-04-10 18:11
     * @param: [studentId, lecturerId]
     * @return: java.lang.Boolean
     **/
    @PostMapping(value = "/save")
    public Boolean saveStudentLecturer(@RequestParam(value = "studentIds") List<String> studentId,
                                       @RequestParam(value = "lecturerId") String lecturerId){
        return adminService.saveLecturerStudent(studentId, lecturerId);
    }
}

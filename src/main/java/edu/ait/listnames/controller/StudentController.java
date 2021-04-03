package edu.ait.listnames.controller;

import edu.ait.listnames.dto.StudentMenuRespDto;
import edu.ait.listnames.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: listnames
 * @description:
 * @author: lgppppppp
 * @create: 2021-04-03 20:11
 **/
@RestController("StudentController")
@Api(value = "studentController", tags = { "student" })
@RequestMapping("gradeSys/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/findMenu")
    @ResponseBody
    public List<StudentMenuRespDto> findMenu(@RequestParam(value = "id", required = false)
                                             @ApiParam(name = "id", value = "id", required = false) String id) {
        List<StudentMenuRespDto> menu = studentService.findMenu(id);
        return menu;
    }
}

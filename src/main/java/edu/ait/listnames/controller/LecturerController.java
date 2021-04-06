package edu.ait.listnames.controller;

import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.dto.LecturerGradeResDto;
import edu.ait.listnames.service.LectureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("LecturerController")
@Api(value = "lecturerController", tags = { "lecturer" })
@RequestMapping("gradeSys/lecturer")
public class LecturerController {

    @Autowired
    private LectureService lectureService;

    /**
     * 导师端菜单列表
     * @param id
     * @return
     */
    @GetMapping(value = "/findMenu")
    @ResponseBody
    public List<LectureMenuResDto> findMenu(@RequestParam(value = "id", required = false)
                                             @ApiParam(name = "id", value = "id", required = false) String id) {
        List<LectureMenuResDto> menu = lectureService.findMenu(id);
        return menu;
    }

    @GetMapping(value = "/findGrade")
    @ResponseBody
    public List<LecturerGradeResDto> findGrade(@RequestParam(value = "id", required = false)
                                            @ApiParam(name = "id", value = "id", required = false) String id) {
        List<LecturerGradeResDto> Grade = lectureService.findGrade(id);
        return Grade;
    }
}

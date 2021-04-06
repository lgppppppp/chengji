package edu.ait.listnames.controller;

import edu.ait.listnames.dto.AdminMenuResDto;
import edu.ait.listnames.service.AdminService;
import io.swagger.annotations.Api;
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

    @GetMapping(value = "/findMenu")
    @ResponseBody
    public List<AdminMenuResDto> findMenu() {
        List<AdminMenuResDto> menu = adminService.findMenu();
        return menu;
    }
}

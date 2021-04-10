package edu.ait.listnames.controller;

import edu.ait.listnames.token.TokenDto;
import edu.ait.listnames.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoGuiYou
 */
@RestController("login")
@Api(value = "login", tags = { "login" })
@RequestMapping("gradeSys/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping
    public TokenDto login(String userName,String password){
        return loginService.login(userName, password);
    }
}

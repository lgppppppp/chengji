package edu.ait.listnames.service;

import edu.ait.listnames.dto.AdminMenuResDto;
import edu.ait.listnames.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public List<AdminMenuResDto> findMenu(){
        Pageable pageable = PageRequest.of(0,10);
        Page<AdminMenuResDto> page = adminRepository.findMenu(pageable);
        List<AdminMenuResDto> menuList = page.getContent();
        return menuList;
    }
}

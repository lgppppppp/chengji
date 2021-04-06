package edu.ait.listnames.service;

import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LecturerRepository lecturerRepository;

    /**
     * 分页查询导师端菜单列表
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<LectureMenuResDto> findMenu(String id){
        Pageable pageable = PageRequest.of(0,5);
        Page<LectureMenuResDto> page = lecturerRepository.findMenu(id,pageable);
        List<LectureMenuResDto> menuList = page.getContent();
        return menuList;
    }
}

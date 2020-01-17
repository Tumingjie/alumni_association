package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Classes;
import service.impl.ClassesServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    @Qualifier("ClassesServiceImpl")
    ClassesServiceImpl classesService;

    @RequestMapping("/dtClasses")
    public List<Classes> dtClasses(String dtName){
        List<Classes> list = classesService.listClassesByDepartmentName("信息电子学部");
        System.out.println(list.size());
        System.out.println(list.get(0));
        return list;
    }
}

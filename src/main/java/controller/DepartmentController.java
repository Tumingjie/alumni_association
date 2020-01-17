package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.impl.DepartmentServiceImpl;


@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    @Qualifier("DepartmentServiceImpl")
    DepartmentServiceImpl departmentService;

}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Student;
import pojo.StudentContent;
import service.impl.StudentContentServiceImpl;
import service.impl.StudentServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    @Qualifier("StudentServiceImpl")
    StudentServiceImpl studentService;

    @Autowired
    @Qualifier("StudentContentServiceImpl")
    StudentContentServiceImpl studentContentService;

    @ResponseBody
    @RequestMapping(value = "/whichStudent",method = RequestMethod.POST)
    public List<StudentContent> whichStudent(String methods,int start){
        List<StudentContent> list = studentContentService.listStudentContentByLink(methods,start);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "clickStudent",method = RequestMethod.POST)
    public List<Student> clickStudent(){
        List<Student> list = studentService.listStudent();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){
        int count = studentContentService.getCount(methods);
        return count;
    }
}

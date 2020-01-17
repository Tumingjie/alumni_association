package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.*;
import service.impl.*;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    @Qualifier("NewsServiceImpl")
    NewsServiceImpl newsService;
    @Autowired
    @Qualifier("AlumniServiceImpl")
    AlumniServiceImpl alumniService;
    @Autowired
    @Qualifier("DonateServiceImpl")
    DonateServiceImpl donateService;
    @Autowired
    @Qualifier("FigureServiceImpl")
    FigureServiceImpl figureService;
    @Autowired
    @Qualifier("HelpServiceImpl")
    HelpServiceImpl helpService;
    @Autowired
    @Qualifier("MediumServiceImpl")
    MediumServiceImpl mediumService;
    @Autowired
    @Qualifier("StudentServiceImpl")
    StudentServiceImpl studentService;

    @RequestMapping("/nchu")
    public String hello(Model model){
        List<News> listNews =newsService.listNews();//将新闻传到页面
        model.addAttribute("listNews",listNews);
        List<Alumni> listAlumni = alumniService.listAlumni();//将校友会传到页面
        model.addAttribute("listAlumni",listAlumni);
        List<Donate> listDonate = donateService.listDonate();//将捐赠传到页面
        model.addAttribute("listDonate",listDonate);
        List<Figure> listFigure = figureService.listFigure();//将任务传到页面
        model.addAttribute("listFigure",listFigure);
        List<Help> listHelp = helpService.listHelp();//将帮助传到页面
        model.addAttribute("listHelp",listHelp);
        List<Medium> listMedium = mediumService.listMedium();//将照片视频传到页面
        model.addAttribute("listMedium",listMedium);
        List<Student> listStudent = studentService.listStudent();//将昌航人传到页面
        model.addAttribute("listStudent",listStudent);
        return "index";
    }
}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Alumni;
import pojo.AlumniContent;
import service.impl.AlumniContentServiceImpl;
import service.impl.AlumniServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/alumni")
public class AlumniController {
    @Autowired
    @Qualifier("AlumniServiceImpl")
    AlumniServiceImpl alumniService;

    @Autowired
    @Qualifier("AlumniContentServiceImpl")
    AlumniContentServiceImpl alumniContentService;

    @ResponseBody
    @RequestMapping(value = "/whichAlumni",method = RequestMethod.POST)
    public List<AlumniContent> whichAlumni(String methods,int start){//start从第几条开始查询
        List<AlumniContent> list = alumniContentService.listAlumniContentByLink(methods,start);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "clickAlumni",method = RequestMethod.POST)
    public List<Alumni> clickAlumni(){//导航栏
        List<Alumni> list = alumniService.listAlumni();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){//访问不到getCount？？?
        int count = alumniContentService.getCount(methods);
        return count;
    }
}

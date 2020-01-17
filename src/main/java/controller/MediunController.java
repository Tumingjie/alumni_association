package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Medium;
import pojo.MediumContent;
import service.impl.MediumContentServiceImpl;
import service.impl.MediumServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/medium")
public class MediunController {
    @Autowired
    @Qualifier("MediumServiceImpl")
    MediumServiceImpl mediumService;

    @Autowired
    @Qualifier("MediumContentServiceImpl")
    MediumContentServiceImpl mediumContentService;

    @ResponseBody
    @RequestMapping(value = "/whichMedium",method = RequestMethod.POST)
    public List<MediumContent> whichMedium(String methods,int start){
        List<MediumContent> list = mediumContentService.listMediumContentByLink(methods,start);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "clickMedium",method = RequestMethod.POST)
    public List<Medium> clickMedium(){
        List<Medium> list = mediumService.listMedium();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){
        int count = mediumContentService.getCount(methods);
        return count;
    }
}

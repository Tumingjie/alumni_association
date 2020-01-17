package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Help;
import pojo.HelpContent;
import service.impl.HelpContentServiceImpl;
import service.impl.HelpServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/help")
public class HelpController {

    @Autowired
    @Qualifier("HelpServiceImpl")
    HelpServiceImpl helpService;

    @Autowired
    @Qualifier("HelpContentServiceImpl")
    HelpContentServiceImpl helpContentService;

    @ResponseBody
    @RequestMapping(value = "/whichHelp",method = RequestMethod.POST)
    public List<HelpContent> whichHelp(String methods,int start){
        List<HelpContent> list = helpContentService.listHelpContentByLink(methods,start);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "clickHelp",method = RequestMethod.POST)
    public List<Help> clickHelp(){
        List<Help> list = helpService.listHelp();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){
        int count = helpContentService.getCount(methods);
        return count;
    }
}

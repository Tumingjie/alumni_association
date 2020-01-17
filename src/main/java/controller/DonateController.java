package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Donate;
import pojo.DonateContent;
import service.impl.DonateContentServiceImpl;
import service.impl.DonateServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    @Qualifier("DonateServiceImpl")
    DonateServiceImpl donateService;

    @Autowired
    @Qualifier("DonateContentServiceImpl")
    DonateContentServiceImpl donateContentService;

    @ResponseBody
    @RequestMapping(value = "/whichDonate",method = RequestMethod.POST)
    public List<DonateContent> whichDonate(String methods,int start){
        List<DonateContent> list = donateContentService.listDonateContentByLink(methods,start);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "clickDonate",method = RequestMethod.POST)
    public List<Donate> clickDonate(){
        List<Donate> list = donateService.listDonate();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){
        int count = donateContentService.getCount(methods);
        return count;
    }
}

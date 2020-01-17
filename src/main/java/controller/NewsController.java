package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.News;
import pojo.NewsContent;
import service.impl.NewsContentServiceImpl;
import service.impl.NewsServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    @Qualifier("NewsServiceImpl")
    NewsServiceImpl newsService;

    @Autowired
    @Qualifier("NewsContentServiceImpl")
    NewsContentServiceImpl newsContentService;

    @ResponseBody
    @RequestMapping(value = "whichNews",method = RequestMethod.POST)
    public List<NewsContent> whichNews(String methods,int start){
        List<NewsContent> listnc = newsContentService.listNewsContentByLink(methods,start);
        return listnc;
    }

    @ResponseBody
    @RequestMapping(value = "clickNews",method = RequestMethod.POST)
    public List<News> clickNews(){
        List<News> list = newsService.listNews();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){
        int count = newsContentService.getCount(methods);
        return count;
    }
}

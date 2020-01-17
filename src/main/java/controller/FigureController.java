package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Figure;
import pojo.FigureContent;
import service.impl.FigureContentServiceImpl;
import service.impl.FigureServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/figure")
public class FigureController {
    @Autowired
    @Qualifier("FigureServiceImpl")
    FigureServiceImpl figureService;

    @Autowired
    @Qualifier("FigureContentServiceImpl")
    FigureContentServiceImpl figureContentService;

    @ResponseBody
    @RequestMapping(value = "/whichFigure",method = RequestMethod.POST)
    public List<FigureContent> whichFigure(String methods,int start){
        List<FigureContent> list  = figureContentService.listFigureContentByLink(methods,start);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "clickFigure",method = RequestMethod.POST)
    public List<Figure> clickFigure(){
        List<Figure> list = figureService.listFigure();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    public int getCount(String methods){
        int count = figureContentService.getCount(methods);
        return count;
    }
}

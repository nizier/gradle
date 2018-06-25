package d1.web;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String  greeting() {
        //返回最新版本和历史版本
        StringBuffer sb = new StringBuffer();
        sb.append("Hello 核查子系统\n");
        sb.append("最新版本:1.0.19 2017/10/11");
        return sb.toString();
    }
}
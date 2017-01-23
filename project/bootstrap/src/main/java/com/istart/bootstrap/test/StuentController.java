package com.istart.bootstrap.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xhuji on 2016/8/28.
 */
@Controller
public class StuentController {
    @RequestMapping(value = "test",method = RequestMethod.POST)
    @ResponseBody
    public Student test(@RequestBody  Request request){
        return new Student();
    }
}

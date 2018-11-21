package com.ft.controller;

import com.ft.annotation.Simple;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mask
 * @date 2018/7/11 16:44
 * @desc
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getText")
    @ResponseBody
    @Simple
    public Map<String, Object> getServerText(){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","1");
        map.put("msg","asd");
        return map;
    }
}

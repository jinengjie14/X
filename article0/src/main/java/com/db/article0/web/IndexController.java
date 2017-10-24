package com.db.article0.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends BaseController {

    @GetMapping("/index")
	public String index(){
    	System.out.println(sessionUserId);
		return "index";
	}
}

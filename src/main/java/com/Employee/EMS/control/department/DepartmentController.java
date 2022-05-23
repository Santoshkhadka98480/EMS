package com.Employee.EMS.control.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department")
public class DepartmentController {

//    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @GetMapping("/home")
    public String openDepartmentHomePage () {
        System.out.println("This is department page loading");
        return "department/home";
    }
}

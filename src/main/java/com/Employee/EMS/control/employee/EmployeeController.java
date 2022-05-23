package com.Employee.EMS.control.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")

public class EmployeeController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String openEmployeeHomePage () {
        return "employee/home";
    }
}

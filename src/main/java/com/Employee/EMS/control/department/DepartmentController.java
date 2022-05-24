package com.Employee.EMS.control.department;

import com.Employee.EMS.control.dto.DepartmentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {

//    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @GetMapping
    public String openDepartmentHomePage (Model model) {

        model.addAttribute("departmentDto",new DepartmentDto());

        System.out.println("This is department page loading");
        return "department/home";
    }

    @PostMapping
    public String saveDepartment(@ModelAttribute DepartmentDto departmentDto) {
        //call a service to save data
        return "redirect:/department";

    }
}

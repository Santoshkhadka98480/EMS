package com.Employee.EMS.controller.department;

import com.Employee.EMS.dto.DepartmentDto;
import com.Employee.EMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @GetMapping
    public String openDepartmentHomePage (Model model) {
        if (model.getAttribute("departmentDto") == null)
        model.addAttribute("departmentDto",new DepartmentDto());
        model.addAttribute("departmentDtoList", departmentService.findAll());

        System.out.println("This is department page loading");
        return "department/home";
    }

    @PostMapping
    public String saveDepartment(@ModelAttribute DepartmentDto departmentDto,
                                 RedirectAttributes redirectAttributes) {
        //call a service to save data
        String message = "";
        departmentDto= departmentService.savDepartment(departmentDto);
        if (departmentDto == null) {
            message="Department cannot be saved";
        } else {
            message="Department saved successfully";
        }
        redirectAttributes.addFlashAttribute("message",message);

       return "redirect:/department";

    }

    @GetMapping("/find-by-id/{id}")
    public String findByID(@PathVariable("id") Integer departmentId, RedirectAttributes redirectAttributes) {
        DepartmentDto departmentDto =  departmentService.findById(departmentId);
        if (departmentDto != null)
        redirectAttributes.addFlashAttribute("departmentDto",departmentDto);
        return "redirect:/department";

    }

    @GetMapping("delete/{id}")
    public String deleteDepartment(@PathVariable("id") Integer departmentId, RedirectAttributes redirectAttributes) {
        String message = "Department deleted successfully";
        departmentService.deleteDepartmentById(departmentId);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/department";
    }
}

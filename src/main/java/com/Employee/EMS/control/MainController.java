package com.Employee.EMS.control;

import com.Employee.EMS.control.dto.SampleDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String openMainPage(Model model) {
        model.addAttribute("sampleDto", new SampleDto("Nepal","Hello"));
        System.out.println("Main page open");

        return "index";
    }

    @PostMapping("/submit1")
    public String submitForm(HttpServletRequest request, Model model) {
        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");
        System.out.println(data1+data2);

        model.addAttribute("d1",data1);
        model.addAttribute("d2",data2);
        return "redirect:/";
    }

    @RequestMapping("/submit2")
    public String submitForm(@RequestParam("data1") String data1,
                             @RequestParam("data2") String data2, Model model) {
        System.out.println(data1);
        System.out.println(data2);
        model.addAttribute("d3",data1);
        model.addAttribute("d4",data2);
        return "redirect:/";

    }

    @RequestMapping("/submit3")
    public String submitForm(@ModelAttribute SampleDto sampleDto, RedirectAttributes redirectAttributes) {
        System.out.println(sampleDto.toString());
        redirectAttributes.addFlashAttribute("d5",sampleDto.getData1());
        redirectAttributes.addFlashAttribute("d6", sampleDto.getData2());
        return "redirect:/";
    }

}

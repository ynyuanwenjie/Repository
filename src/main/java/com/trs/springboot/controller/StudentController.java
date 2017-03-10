package com.trs.springboot.controller;

import com.trs.springboot.model.Student;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanwenjie on 2016/11/26.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/{id}")
    public String user(@PathVariable("id")Student student, Model model) {
        model.addAttribute("student",student);
        System.out.println(student);

        return "student";
    }

    @RequestMapping("/name/{name}")
    public String name(@PathVariable("name")Student student,Model model) {
        System.out.println(student);
        return "name:"+student.getName();
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("-==================------------------------");
        return " index successful";
    }
}

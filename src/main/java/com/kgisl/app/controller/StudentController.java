package com.kgisl.app.controller;

import java.util.List;

import com.kgisl.app.model.Student;
import com.kgisl.app.repository.Javarepositary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * StudentController
 */

@RequestMapping(value = "/students")
@Controller
public class StudentController {
    @Autowired
    public static Javarepositary javarepositary;

    // @RequestMapping
    // public Student submit(@ModelAttribute("Student") Student student) {
    // student.setRollno(0);
    // return javarepositary.save(student);
    // }
      @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public static List<Student> listStudents() {
        System.out.println("Get method executed");

        // model.addAttribute("listStudent", javarepositary.findAll());
        return javarepositary.findAll();
    }

    // @RequestMapping(method = RequestMethod.POST)
    // public Student addStudent(@ModelAttribute Student student) {
    // // student.setRollno(0);
    // return javarepositary.save(student);
    // // System.out.println("MOdal clsass"+student);
    // // System.out.println("Post worked");
    // }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addstudent( @ModelAttribute Student student, 
    BindingResult result, ModelMap model){
    System.out.println("insert called");
        // System.out.println(student);
        // new student, add it
        javarepositary.save(student);
        model.addAttribute("listStudent", javarepositary.findAll());
        return "list";
    }
}

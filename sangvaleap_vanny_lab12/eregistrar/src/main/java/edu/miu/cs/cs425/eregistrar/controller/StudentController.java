package edu.miu.cs.cs425.eregistrar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;

@Controller
@RequestMapping(value = { "/eregister/secured/admin/student", "/eregister/secured/registrar/student" })
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = { "/list", "" })
    public ModelAndView listStudents(@RequestParam(defaultValue = "0") int pageNo) {
        var students = studentService.getStudentsPaged(pageNo);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("secured/registrar/student/list");
        return modelAndView;
    }

    @GetMapping(value = { "/new" })
    public String displayNewStudentForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "secured/registrar/student/new";
    }

    @PostMapping(value = { "/new" })
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/registrar/student/new";
        }
        studentService.saveStudent(student);
        return "redirect:/eregister/secured/registrar/student/list";
    }

    @GetMapping(value = { "/edit/{studentId}" })
    public String displayEditStudent(@PathVariable Integer studentId, Model model) {
        var student = studentService.findStudent(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "secured/registrar/student/edit";
        }
        return "redirect:/eregister/secured/registrar/student/list";
    }

    @PostMapping(value = { "/update" })
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/registrar/student/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/eregister/secured/registrar/student/list";
    }

    @GetMapping(value = { "/delete/{studentId}" })
    public String deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/eregister/secured/registrar/student/list";
    }

    @GetMapping(value = { "/search" })
    public ModelAndView searchStudents(@RequestParam String searchString) {
        if (searchString.isBlank()) {
            return new ModelAndView("redirect:/eregister/secured/registrar/student/list");
        }
        var modelAndView = new ModelAndView();
        var students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/registrar/student/searchResult");
        return modelAndView;
    }

}

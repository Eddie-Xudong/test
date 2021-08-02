package com.haue.controller;

import com.haue.domain.Student;
import com.haue.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

    //学生注册
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tip = "注册失败！";
        //调用service处理student
        int num = service.addStudent(student);
        if (num == 1){
            tip = "学生【"+student.getName()+"】注册成功！";
        }
        //添加数据
        mv.addObject("tip",tip);
        //指定结果页面
        mv.setViewName("result");
        return mv;
    }

    ///处理查询,响应ajax
    @RequestMapping("/queryStudents.do")
    @ResponseBody
    public List<Student> queryStudents(){
        //参数检查，简单的数据处理
        List<Student> students = service.findStudents();
        return students;
    }
}

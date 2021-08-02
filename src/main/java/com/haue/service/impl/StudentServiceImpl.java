package com.haue.service.impl;

import com.haue.dao.StudentDao;
import com.haue.domain.Student;
import com.haue.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //引用类型自动注入 默认byName
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int num = studentDao.insertStudent(student);
        return num;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }
}

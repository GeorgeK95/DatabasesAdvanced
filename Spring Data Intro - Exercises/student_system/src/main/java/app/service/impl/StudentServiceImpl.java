package app.service.impl;

import app.dao.StudentDao;
import app.model.Student;
import app.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class StudentServiceImpl implements StudentService<Student, Long> {
    @Autowired
    private StudentDao dao;

    @Override
    public Student findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Student object) {
        dao.delete(object);
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Student object) {
        dao.save(object);
    }

    @Override
    public List<Object[]> getStudentInfo() {
        return dao.getStudentInfo();
    }
}

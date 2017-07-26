package app.service.impl;

import app.dao.CourseDao;
import app.model.Course;
import app.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class CourseServiceImpl implements CourseService<Course, Long> {

    @Autowired
    private CourseDao dao;

    @Override
    public Course findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Course object) {
        dao.delete(object);
    }

    @Override
    public List<Course> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Course object) {
        dao.save(object);
    }

    @Override
    public List<String> getCourseWithMoreThan5Resources() {
        return dao.getCourseWithMoreThan5Resources();
    }

    @Override
    public List<Course> activeCources2001() {
        return dao.activeCources2001();
    }
}

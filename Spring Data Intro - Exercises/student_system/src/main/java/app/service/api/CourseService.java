package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
public interface CourseService<Course, Long> extends ServiceInterface<Course, Long> {
    List<String> getCourseWithMoreThan5Resources();

    List<Course> activeCources2001();
}

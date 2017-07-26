package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
public interface StudentService<Student, Long> extends ServiceInterface<Student, Long> {
    List<Object[]> getStudentInfo();
}

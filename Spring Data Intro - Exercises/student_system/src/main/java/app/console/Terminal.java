package app.console;

import app.model.*;
import app.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private StudentService<Student, Long> studentService;
    @Autowired
    private CourseService<Course, Long> courseService;
    @Autowired
    private HomeworkService<Homework, Long> homeworkService;
    @Autowired
    private ResourceService<Resource, Long> resourceService;
    @Autowired
    private LicenceService<License, Long> licenseService;

    @Override
    public void run(String... strings) throws Exception {
//        seedData();
//        task_7();
    }

    private void task_7() {
        //1
//        homeworkService.findAll()
//                .stream()
//                .forEach(x -> System.out.printf("%s %s %s\n", x.getStudent().getName(), x.getContent(), x.getContentType().toString()));
        //2
//        List<Course> courses = courseService.findAll();
//        courses = courses.stream().sorted(Comparator.comparing(Course::getStartDate).thenComparing(Course::getEndDate).reversed()).collect(Collectors.toList());
//        for (Course x : courses) {
//            System.out.printf("%s %s\n", x.getName(), x.getDescription());
//            for (Resource y : x.getResources()) {
//                System.out.printf("%s %s\n", y.getName(), y.getResourceType(), y.getUrl());
//            }
//            System.out.println("______________________________________________");
//        }
        //3
//        courseService.getCourseWithMoreThan5Resources().forEach(System.out::println);
        //4
//        courseService.activeCources2001()
//                .stream()
//                .sorted(Comparator.comparing((Course x) -> x.getStudents().size()).reversed()
//                        .thenComparing(Course::getDifferenceDays).reversed())
//                .forEach(x -> System.out.printf("%s %s %s %d %d\n", x.getName(), x.getStartDate().toString(),
//                        x.getEndDate().toString(),
//                        x.getDifferenceDays(),
//                        x.getStudents().size()));
        //5
//        studentService.getStudentInfo().forEach(s -> {
//            System.out.printf("Name: %s, Coursec count: %s, Total price: %s, Average price: %s\n",
//                    s[0], s[1], s[2], s[3]);
//        });
    }

    private void seedData() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");

        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("Vankata");
        student.setRegistrationDate(new Date());
        studentService.save(student);
        students.add(student);

        Student studentTwo = new Student();
        studentTwo.setName("LrX");
        studentTwo.setRegistrationDate(formatter.parse("20/01/1998"));
        studentService.save(studentTwo);
        students.add(studentTwo);

        Student studentThree = new Student();
        studentThree.setName("Pesho");
        studentThree.setRegistrationDate(formatter.parse("30/07/2002"));
        studentService.save(studentThree);
        students.add(studentThree);

        Student studentFour = new Student();
        studentFour.setName("Javarvarin");
        studentFour.setRegistrationDate(formatter.parse("12/05/2010"));
        studentService.save(studentFour);
        students.add(studentFour);

        Course course = new Course();
        course.setName("Java OOP");
        course.setStartDate(formatter.parse("30/07/2017"));
        course.setEndDate(formatter.parse("15/19/2017"));
        course.setPrice(BigDecimal.valueOf(350));
//        course.setStudents(new HashSet<>(students));
        courseService.save(course);

        Course course1 = new Course();
        course1.setName("DB Basics");
        course1.setStartDate(formatter.parse("10/02/2002"));
        course1.setEndDate(formatter.parse("18/03/2002"));
        course1.setPrice(BigDecimal.valueOf(250));
//        course1.setStudents(new HashSet<>(students.subList(1, 3)));
        courseService.save(course1);


        Course course2 = new Course();
        course2.setName("Programming Fundamentals");
        course2.setStartDate(formatter.parse("12/04/2015"));
        course2.setEndDate(formatter.parse("12/06/2015"));
        course2.setPrice(BigDecimal.valueOf(290));
//        course2.setStudents(new HashSet<>(students.subList(0, 2)));
        courseService.save(course2);

        Course course3 = new Course();
        course3.setName("SoftUni Programming");
        course3.setStartDate(formatter.parse("01/03/2000"));
        course3.setEndDate(formatter.parse("16/06/2002"));
        course3.setPrice(BigDecimal.valueOf(1800));
//        course3.setStudents(new HashSet<>(students.subList(1, 2)));
        courseService.save(course3);

        Course course4 = new Course();
        course4.setName("Drawing with paint");
        course4.setStartDate(formatter.parse("01/01/2005"));
        course4.setEndDate(formatter.parse("01/01/2015"));
        course4.setPrice(BigDecimal.valueOf(350000));
//        course4.setStudents(new HashSet<>(students));
        courseService.save(course4);

        Homework homework = new Homework();
        homework.setContent("Gluposti gluposti da");
        homework.setContentType(ContentType.APPLICATION_PDF);
        homework.setSubmissionDate(new Date());
        homework.setStudent(studentTwo);
        homeworkService.save(homework);

        Homework homework1 = new Homework();
        homework1.setContent("Learn java java java");
        homework1.setContentType(ContentType.APPLICATION_ZIR);
        homework1.setSubmissionDate(formatter.parse("01/02/2017"));
        homework1.setStudent(student);
        homeworkService.save(homework1);

        Homework homework2 = new Homework();
        homework2.setContent("MySQL rules, use Heidi");
        homework2.setContentType(ContentType.APPLICATION_PDF);
        homework2.setSubmissionDate(formatter.parse("12/05/2015"));
        homework2.setStudent(studentThree);
        homeworkService.save(homework2);

        Homework homework3 = new Homework();
        homework3.setContent("Niznam ko da pisha zdr ko pr");
        homework3.setContentType(ContentType.APPLICATION_PDF);
        homework3.setSubmissionDate(new Date());
        homework3.setStudent(studentFour);
        homeworkService.save(homework3);

        Homework homework4 = new Homework();
        homework4.setContent("The final domashno and Im done with this sh*t");
        homework4.setContentType(ContentType.APPLICATION_ZIR);
        homework4.setSubmissionDate(formatter.parse("04/11/2002"));
        homework4.setStudent(studentFour);
        homeworkService.save(homework4);

        Resource resource = new Resource();
        resource.setName("Java Programming");
        resource.setCourse(course);
        resource.setResourceType(ResourceType.DOCUMENT);
        resource.setUrl("www.java.uchizdravo");
//        resource.setStudents(new HashSet<>(students));
        resourceService.save(resource);

        Resource resource1 = new Resource();
        resource1.setName("Google");
        resource1.setCourse(course);
        resource1.setResourceType(ResourceType.OTHER);
        resource1.setUrl("www.google.com");
//        resource1.setCourses(new HashSet<>(students));
        resourceService.save(resource1);

        Resource resource2 = new Resource();
        resource2.setName("Pisna mi da snimam svatbi okolo Varna!!!");
        resource2.setCourse(course1);
        resource2.setResourceType(ResourceType.VIDEO);
        resource2.setUrl("www.mnogoPut.malkoSun");
//        resource2.setStudents(new HashSet<>(students));
        resourceService.save(resource2);

        Resource resource3 = new Resource();
        resource3.setName("Seeding sample data is damn boring");
        resource3.setCourse(course2);
        resource3.setResourceType(ResourceType.PRESENTATION);
        resource3.setUrl("www.softuni.com");
//        resource3.setStudents(new HashSet<>(students));
        resourceService.save(resource3);

        License license = new License();
        license.setName("Kot takoa");
        license.setResource(resource);
        licenseService.save(license);

        License license1 = new License();
        license1.setName("Nqma da pisha poveche!");
        license1.setResource(resource2);
        licenseService.save(license1);
    }
}

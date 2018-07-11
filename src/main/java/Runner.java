import db.DBCourse;
import db.DBHelper;
import db.DBStudent;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Mentor mentor1 = new Mentor ("Tony Goncalves");
        DBHelper.save(mentor1);

        Mentor mentor2 = new Mentor ("Jarrod");
        DBHelper.save(mentor2);

        Course course1 = new Course ("Computer Science", "BSc");
        DBHelper.save(course1);

        Course course2 = new Course ("Medicine", "MBChB");
        DBHelper.save(course1);

        Student student1 = new Student ("Zsolt Poboda", 34, 1, course1, mentor1);
        DBHelper.save(student1);

        Student student2 = new Student ("John Harper", 30, 2, course2, mentor2);
        DBHelper.save(student1);

        Instructor instructor1 = new Instructor ("Bill Gates");
        DBHelper.save(instructor1);

        Lesson lesson1 = new Lesson ("Object-orientated programming", 20, course1, instructor1);
        DBHelper.save(lesson1);

        Lesson lesson2 = new Lesson ("Introduction to Anatomy", 30, course2, instructor1);
        DBHelper.save(lesson2);

        List<Lesson> lessons = DBHelper.getAll(Lesson.class);
        List<Student> students = DBHelper.getAll(Student.class);
        List<Course> courses = DBHelper.getAll(Course.class);

        List<Lesson> lessonsForCS = DBCourse.getLessonsForCourse(course1);

        List<Lesson> lessonsForJohn = DBStudent.getLessonsForStudent(student2);

    }
}

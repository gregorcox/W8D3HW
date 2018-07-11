package models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Fetch;

@Entity
@Table(name = "lessons")
public class Lesson {

    private int id;
    private String title;
    private int classroomNumber;
    private Instructor instructor;
    private Course course;

    public Lesson(String title, int classroomNumber, Course course, Instructor instructor){
        this.title = title;
        this.classroomNumber = classroomNumber;
        this.course = course;
        this.instructor = instructor;
    }

    public Lesson(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "classroomNumber")
    public int getClassroomNumber() {
        return classroomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

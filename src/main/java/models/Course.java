package models;

import javax.persistence.*;
import java.util.List;

public class Course {

    private int id;
    private String title;
    private String level;
    private List<Student> students;
    private List<Lesson> lessons;

    public Course(String title, String level){
        this.title = title;
        this.level = level;
    }

    public Course(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle(){
        return title;
    }

    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public List<Student> getStudents() {
        return students;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

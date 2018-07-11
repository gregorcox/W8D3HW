package models;

import javax.persistence.*;
import java.util.List;

public class Instructor {

    private int id;
    private String name;
    private List<Lesson> lessons;

    public Instructor(String name){
        this.name = name;
    }

    public Instructor(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

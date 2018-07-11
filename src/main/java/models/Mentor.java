package models;

import javax.persistence.*;

@Entity
@Table(name = "mentors")
public class Mentor {

    private int id;
    private String name;
    private Student student;

    public Mentor(String name){
        this.name = name;
    }

    public Mentor(){
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

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

package com.okta.developer.docker_microservices.service.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint( name = "un_class", columnNames = {
        "course_id", "teacher_id", "year"
}))
public class TeachingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class_course"))
    @NotNull
    @NonNull
    private Course course;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class_teacher"))
    @NotNull
    @NonNull
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            foreignKey = @ForeignKey(name = "fk_class_student"),
            inverseForeignKey = @ForeignKey(name = "fk_student_class")
    )
    @NonNull private List<Student> students;
    @NonNull private int year;


}

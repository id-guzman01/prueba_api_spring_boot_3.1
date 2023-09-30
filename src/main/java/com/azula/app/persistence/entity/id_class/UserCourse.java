package com.azula.app.persistence.entity.id_class;

import com.azula.app.persistence.entity.User;
import com.azula.app.persistence.entity.Course;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(UserCourseKey.class)
@Table(name = "user_course")
public class UserCourse {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @Column(name = "rating")
    private int rating;

    @Override
    public String toString() {
        return "UserCourse{" +
                ", rating='" + rating + '\'' +
                '}';
    }

}

package com.azula.app.persistence.entity.id_class;

import com.azula.app.persistence.entity.Course;
import com.azula.app.persistence.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class UserCourseKey implements Serializable {

    private User user;

    private Course course;

    public UserCourseKey(User user, Course course){
        this.user = user;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCourseKey that = (UserCourseKey) o;

        if (!Objects.equals(user, that.user)) return false;
       return Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(user);
        result = 31 * result + Objects.hash(course);
        return result;
    }

}

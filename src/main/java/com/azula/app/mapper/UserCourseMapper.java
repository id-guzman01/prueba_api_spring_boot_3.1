package com.azula.app.mapper;

import com.azula.app.persistence.entity.Course;
import com.azula.app.persistence.entity.User;
import com.azula.app.persistence.entity.id_class.UserCourse;
import com.azula.app.persistence.repository.CourseRepository;
import com.azula.app.persistence.repository.UserRepository;
import com.azula.app.service.DTO.UserCourseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserCourseMapper implements IMapper<UserCourseDTO, UserCourse>{

    private final UserRepository userRepository;

    private final CourseRepository courseRepository;

    public UserCourseMapper(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public UserCourse map(UserCourseDTO in) {
        UserCourse userCourse = new UserCourse();

        User user = userRepository.findById(in.getUser_id()).get();
        userCourse.setUser(user);

        Course course = courseRepository.findById(in.getCourse_id()).get();
        userCourse.setCourse(course);

        userCourse.setRating(in.getRating());
        return userCourse;
    }
}

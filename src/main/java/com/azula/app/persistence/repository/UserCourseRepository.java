package com.azula.app.persistence.repository;

import com.azula.app.persistence.entity.id_class.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {
}

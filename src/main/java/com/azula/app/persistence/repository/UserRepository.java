package com.azula.app.persistence.repository;

import com.azula.app.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "update users set password=:password where id=:id", nativeQuery = true)
    public void updatePasswordUser(@Param("id") int id, @Param("password") String password);

}

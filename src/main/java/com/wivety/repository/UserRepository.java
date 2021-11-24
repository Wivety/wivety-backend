package com.wivety.repository;

import com.wivety.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM Profile p WHERE p.email = :email")
    public Profile getByEmail(@Param("email") String email);

    @Query("SELECT p FROM Profile p WHERE p.id = :id")
    public Profile getById(@Param("id") String id);
}

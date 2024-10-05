package com.example.JavaSpringPostgreSQL.repositories;

import com.example.JavaSpringPostgreSQL.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.cars WHERE u.id = :id")
    User findByIdWithCars(@Param("id") Long id);
}

package com.example.JavaSpringPostgreSQL.repositories;

import com.example.JavaSpringPostgreSQL.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}

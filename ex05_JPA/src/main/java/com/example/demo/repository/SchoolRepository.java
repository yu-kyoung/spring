package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}

package com.demo.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.weather.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

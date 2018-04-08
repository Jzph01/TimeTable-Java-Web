package com.enjoyyourtime.app.repositories;

import com.enjoyyourtime.app.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {



}

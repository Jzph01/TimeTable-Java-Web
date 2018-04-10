package com.enjoyyourtime.app.areas.activity.repositories;

import com.enjoyyourtime.app.areas.activity.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {



}

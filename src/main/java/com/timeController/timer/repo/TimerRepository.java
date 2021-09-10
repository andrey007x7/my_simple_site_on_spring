package com.timeController.timer.repo;

import com.timeController.timer.models.Timer;
import org.springframework.data.repository.CrudRepository;

public interface TimerRepository extends CrudRepository<Timer, Long> {
}

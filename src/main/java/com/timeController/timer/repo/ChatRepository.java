package com.timeController.timer.repo;

import com.timeController.timer.models.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Long> {
}

package com.timeController.timer.repo;

import com.timeController.timer.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}

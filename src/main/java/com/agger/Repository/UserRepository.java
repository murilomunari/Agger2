package com.agger.Repository;

import com.agger.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Override
    Optional<User> findById(String id);
}

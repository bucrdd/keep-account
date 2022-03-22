package org.bucr.keepaccount.repository;

import java.util.Optional;
import org.bucr.keepaccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}

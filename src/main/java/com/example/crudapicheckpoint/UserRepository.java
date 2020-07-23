package com.example.crudapicheckpoint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    @Query(value="SELECT * FROM users WHERE id = :id", nativeQuery=true)
    User findByUserId(Long id);

    @Query(value="UPDATE users WHERE id = :id SET email = :email", nativeQuery = true)
    User updateEmailByUserId(Long id, String email);

    @Query(value="UPDATE users WHERE id = :id SET password = :password")
    User updatePasswordByUserId(Long id, String password);

}

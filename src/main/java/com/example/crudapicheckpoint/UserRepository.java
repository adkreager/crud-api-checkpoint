package com.example.crudapicheckpoint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    @Query(value="SELECT * FROM users WHERE id = :id", nativeQuery=true)
    User findByUserId(Long id);

    @Query(value="UPDATE users SET email = :email WHERE id = :id", nativeQuery = true)
    User updateEmailByUserId(Long id, String email);

    @Query(value="UPDATE users SET password = :password WHERE id = :id", nativeQuery=true)
    User updatePasswordByUserId(Long id, String password);

    @Query(value="DELETE FROM users WHERE id = :id", nativeQuery=true)
    User deleteUser(Long id);

//    @Query(value="INSERT INTO users (id, email, password) VALUES (:id, :email, :password)", nativeQuery = true)
//    User createUser(Long id, String email, )

}

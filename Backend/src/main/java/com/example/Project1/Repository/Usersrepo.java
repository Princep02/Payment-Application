

package com.example.Project1.Repository;

import com.example.Project1.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query; // Add this import
import java.util.Optional;


@Repository
public interface Usersrepo extends JpaRepository<Users,Integer> {
    // @Query("SELECT u FROM Users u WHERE u.email_id = :email_id")
    // public abstract Users findByEmailId(@Param("email_id") String email_id);
    // Users findByphonenumber(long phonenumber);
    Users findByphonenumber(Long phonenumber);
    Optional<Users> findOneByphonenumberAndPassword(Long phonenumber,String password);

}


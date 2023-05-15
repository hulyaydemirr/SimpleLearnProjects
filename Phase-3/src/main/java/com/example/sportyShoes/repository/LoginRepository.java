package com.example.sportyShoes.repository;

import com.example.sportyShoes.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    @Query("select l from Login l where l.emailId = :emailId and l.password = :password and l.typeOfUser=:typeOfUser")
     Login signIn(@Param("emailId") String emailId,
                        @Param("password") String password,
                        @Param("typeOfUser") String typeOfUser);
}
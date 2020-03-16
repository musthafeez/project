package com.example.shoppingAPP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.shoppingAPP.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}





package com.example.Project1.Repository;

import com.example.Project1.Model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Accountsrepo extends JpaRepository<Accounts,Integer> {


}

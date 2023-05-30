package com.banksystem.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banksystem.management.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

}

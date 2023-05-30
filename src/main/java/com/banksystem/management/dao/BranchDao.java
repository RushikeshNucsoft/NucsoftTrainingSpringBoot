package com.banksystem.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banksystem.management.entity.Branch;
@Repository
public interface BranchDao extends JpaRepository<Branch, Integer>{

}

package com.toy.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.memo.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

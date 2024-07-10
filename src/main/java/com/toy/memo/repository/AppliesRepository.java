package com.toy.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.memo.model.Applies;

@Repository
public interface AppliesRepository extends JpaRepository<Applies, Long> {
}

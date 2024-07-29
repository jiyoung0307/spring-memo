package com.toy.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.memo.model.MemoLog;

@Repository
public interface MemoLogRepository extends JpaRepository<MemoLog, String> {
}

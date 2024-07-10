package com.toy.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.memo.model.JopPost;

import java.util.List;

@Repository
public interface JopPostRepository extends JpaRepository<JopPost, Long> {

    List<JopPost> findByPositionContainingOrTechStackContainingOrCompanyNo_NameContaining(
            String positonKeyword, String StackKeyword, String coNameKeyword
    );

    List<JopPost> findByCompanyNo(Long companyNo);
}

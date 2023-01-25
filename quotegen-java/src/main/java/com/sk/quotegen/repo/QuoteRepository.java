package com.sk.quotegen.repo;

import com.sk.quotegen.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {

    QuoteEntity findByQid (int id);

}

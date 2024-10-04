package com.curriculoapi.repository;

import com.curriculoapi.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacaoRepository extends JpaRepository<Education, Long> {
}

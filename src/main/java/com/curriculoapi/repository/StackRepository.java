package com.curriculoapi.repository;

import com.curriculoapi.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StacksRepository extends JpaRepository<Stack, Long> {
}

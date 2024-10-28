package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdviceRepository extends JpaRepository<Advice, Long> {

    Optional<Advice> findBySymptomId(Long symptomId);
}

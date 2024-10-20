package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.EducationalResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalResourceRepository extends JpaRepository<EducationalResource,Long> {
}

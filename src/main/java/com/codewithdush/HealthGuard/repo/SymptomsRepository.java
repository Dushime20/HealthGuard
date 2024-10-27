package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms, Long> {

//    @Query("SELECT s FROM Symptoms s WHERE s.user.id = :userId")
//    List<Symptoms> findSymptomsByUserId(@Param("userId") Long userId);
}

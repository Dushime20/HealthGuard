package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.Vaccinations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccinations, Long> {

   // List<Vaccinations> findByUserId(Long userId);

    @Query("SELECT v FROM Vaccinations v JOIN v.user u WHERE u.cell = :cell")
    List<Vaccinations> findByUserCell(@Param("cell") String cell);

    @Query("SELECT v FROM Vaccinations v JOIN v.user u WHERE u.sector = :sector")
    List<Vaccinations> findByUserSector(@Param("sector") String sector);

    @Query("SELECT v FROM Vaccinations v JOIN v.user u WHERE u.village = :village")
    List<Vaccinations> findByUserVillage(@Param("village") String village);
}

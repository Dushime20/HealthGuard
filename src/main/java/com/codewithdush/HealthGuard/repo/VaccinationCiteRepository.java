package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.VaccinationSites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface VaccinationCiteRepository extends JpaRepository<VaccinationSites, Long> {


    List<VaccinationSites> findAllByCiteDistrictAndCiteSectorAndCiteCell( String citeDistrict, String citeSector, String citeCell);
}

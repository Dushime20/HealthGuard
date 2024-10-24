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

    @Query("SELECT v FROM Vaccinations v WHERE v.recipientDistrict = :district AND v.recipientSector = :sector AND v.recipientCell = :cell")
    List<Vaccinations> findByRecipientSectorAndDistrictAndCell(@Param("cell") String cell,

                                      @Param("district") String district,
                                      @Param("sector") String sector);

    @Query("SELECT v FROM Vaccinations v WHERE v.recipientDistrict = :district AND v.recipientSector = :sector")
    List<Vaccinations> findByRecipientSectorAndDistrict(@Param("sector") String sector,
                                                        @Param("district") String district);

    @Query("SELECT v FROM Vaccinations v WHERE v.recipientDistrict = :district")
    List<Vaccinations> findByRecipientDistrict(@Param("district") String district);


    @Query("SELECT v FROM Vaccinations v WHERE v.recipientVillage = :village AND v.recipientDistrict = :district AND v.recipientSector = :sector AND v.recipientCell = :cell")
    List<Vaccinations> findByRecipientVillageAndDistrictAndSectorAndCell(
            @Param("village") String village,
            @Param("district") String district,
            @Param("sector") String sector,
            @Param("cell") String cell
    );



}

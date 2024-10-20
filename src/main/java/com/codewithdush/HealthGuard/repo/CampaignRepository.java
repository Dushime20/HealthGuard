package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.Campaigns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaigns,Long> {

    @Query("SELECT c FROM Campaigns c WHERE c.startDate = :startDate AND c.address = :address")
    List<Campaigns> findCampaignByStartingDateAndAddress(@Param("startDate") LocalDateTime startDate, @Param("address") String address);

}

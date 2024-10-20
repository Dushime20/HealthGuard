package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.repo.CampaignRepository;

import java.time.LocalDateTime;

public interface ICampaignService{

    Response createCampaign(String title,String address ,String description, LocalDateTime startDate, LocalDateTime endDate, Long userId,LocalDateTime updatedAt);
    Response getAllCampaign();
    Response getCampaignBYId(Long campaignId);
    Response getCampaignByStartingDateAndAddress(LocalDateTime startDate, String address);
    Response deleteCampaign(Long campaignId);
}

package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.CampaignsDto;
import com.codewithdush.HealthGuard.Dto.ReportsDto;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.Campaigns;
import com.codewithdush.HealthGuard.entity.Reports;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.CampaignRepository;
import com.codewithdush.HealthGuard.repo.UserRepository;
import com.codewithdush.HealthGuard.service.Intrefac.ICampaignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignService implements ICampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response createCampaign(Long userId,String title, String address, String description, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime updatedAt) {
        Response response = new Response();
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new OurException("User not found"));
            Campaigns campaigns = new Campaigns();

            campaigns.setAddress(address);
            campaigns.setCreatedBy(user);
            campaigns.setTitle(title);
            campaigns.setDescription(description);
            campaigns.setStartDate(startDate);
            campaigns.setEndDate(endDate);
            campaigns.setUpdatedAt(LocalDateTime.now());

            Campaigns savedCampaign = campaignRepository.save(campaigns);

            // Map to DTO
            CampaignsDto campaignsDto = modelMapper.map(savedCampaign, CampaignsDto.class);


            response.setStatusCode(200);
            response.setMessage("Success");
            response.setCampaigns(campaignsDto);

        }
        catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        }
        catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error creating campaign: " + e.getMessage());
        }

        return response;
    }


    @Override
    public Response getAllCampaign() {
        Response response = new Response();
        try {
            // Retrieve the list of reports sorted by ID in descending order
            List<Campaigns> campaignsList = campaignRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

            // Map the list of Reports to a list of ReportsDto
            List<CampaignsDto> campaignsDtoList = campaignsList.stream()
                    .map(campaign -> modelMapper.map(campaign, CampaignsDto.class))
                    .collect(Collectors.toList());

            response.setStatusCode(200);
            response.setMessage("success");
            response.setCampaignsDtoList(campaignsDtoList);
        }  catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all campaigns: " + e.getMessage());
        }

        return response;
    }


    @Override
    public Response getCampaignBYId(Long campaignId) {
        Response response = new Response();
        try{
            Campaigns campaigns =  campaignRepository.findById(campaignId).orElseThrow(()-> new OurException("report not found"));
            CampaignsDto campaignsDto = modelMapper.map(campaigns,CampaignsDto.class);

            response.setStatusCode(200);
            response.setMessage("success");
            response.setCampaigns(campaignsDto);
        }
        catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all campaign: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response getCampaignByStartingDateAndAddress(LocalDateTime startDate, String address) {
        Response response = new Response();

        try{

            List<Campaigns> campaignsList = campaignRepository.findCampaignByStartingDateAndAddress(startDate,address);
            // Map the list of Campaigns to a list of CampaignsDto
            List<CampaignsDto> campaignsDtoList = campaignsList.stream()
                    .map(campaign -> modelMapper.map(campaignsList, CampaignsDto.class))
                    .collect(Collectors.toList());
            response.setStatusCode(200);
            response.setMessage("success");
            response.setCampaignsDtoList(campaignsDtoList);


        }
        catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting by date and location campaign: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Response deleteCampaign(Long campaignId) {
        Response response = new Response();
        try{
             campaignRepository.findById(campaignId).orElseThrow(()->new OurException("Campaign not found"));
            campaignRepository.deleteById(campaignId);
            response.setStatusCode(200);
            response.setMessage("success");

        }

     catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all campaign: " + e.getMessage());
        }

        return response;
    }

}

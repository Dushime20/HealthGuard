package com.codewithdush.HealthGuard.service.Intrefac;



import com.codewithdush.HealthGuard.Dto.LoginRequest;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    Response register(User user);
    Response login (LoginRequest loginRequest);
    Response getAllUser();
    Response resetPassword(Long userId,String email, String password);
    Response addUserProfile(Long userId, MultipartFile photo);
    Response updateUserProfile(Long userId, String name, String phoneNumber, String email, String address, MultipartFile photo);
    Response deleteUser(String userId);
    Response getUserById(String userId);
    Response getMyInfo(String email);
}

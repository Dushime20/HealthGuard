package com.codewithdush.HealthGuard.Dto;

import lombok.Data;

@Data
public class ResetPassword {
  public String email;
  public String password;
}

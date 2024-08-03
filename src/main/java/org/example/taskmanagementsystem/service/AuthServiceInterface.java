package org.example.taskmanagementsystem.service;

import org.example.taskmanagementsystem.dtos.LoginDto;
import org.example.taskmanagementsystem.dtos.RegisterDto;

public interface AuthServiceInterface {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}

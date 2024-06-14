package com.blocklend.lending.protocol.controller.auth;

import com.blocklend.lending.protocol.dtos.request.RegisterUserRequest;
import com.blocklend.lending.protocol.dtos.request.VerificationRequest;
import com.blocklend.lending.protocol.dtos.response.AuthenticateUserResponse;
import com.blocklend.lending.protocol.dtos.response.OtpVerificationResponse;
import com.blocklend.lending.protocol.exceptions.EmailAlreadyExistException;
import com.blocklend.lending.protocol.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class EmailVerificationController {

    private final UserService userService;

    @PostMapping("/sendOtp")
    public ResponseEntity<AuthenticateUserResponse> sendOtpMail(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.status(CREATED).body(userService.register(request));
    }

    @PostMapping("/verifyMail")
    public ResponseEntity<OtpVerificationResponse> verifyOtpMail(@RequestBody VerificationRequest request) {
    return ResponseEntity.ok(userService.verifyEmail(request));
    }







}

package com.twilio.phonenumber_verification_system.controller;

import com.twilio.phonenumber_verification_system.service.PhoneNumberVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/phoneNumber")
public class PhoneNumberVerificationController {

    @Autowired
    PhoneNumberVerificationService verificationService;

    @GetMapping(value = "/generateOTP")
    public ResponseEntity<String> generateOTP(@RequestParam(value = "phoneNumber") String phoneNumber) {

        verificationService.generateOTP(phoneNumber);
        return new ResponseEntity<>("Your OTP has been sent to your verified phone number ", HttpStatus.OK);

    }

    @GetMapping("/verifyOTP")
    public ResponseEntity<?> verifyUserOTP(@RequestParam(value = "phoneNumber") String phoneNumber, @RequestParam(value = "otp") String otp) {

        try {
            verificationService.verifyUserOTP(phoneNumber, otp);
        } catch (Exception e) {
            return new ResponseEntity<>("Verification failed.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("This user's verification code has been completed successfully.", HttpStatus.OK);

    }

}

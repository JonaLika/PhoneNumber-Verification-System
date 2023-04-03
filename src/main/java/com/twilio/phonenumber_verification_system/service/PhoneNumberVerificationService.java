package com.twilio.phonenumber_verification_system.service;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;

@Slf4j
@Configuration
public class PhoneNumberVerificationService {

    @Autowired
    private Environment env;

    public void generateOTP(String phoneNumber) {

        Twilio.init(env.getProperty("TWILIO_ACCOUNT_SID"), env.getProperty("TWILIO_AUTH_TOKEN"));

        Verification verification = Verification.creator(
                        env.getProperty("PATH_SERVICE_SID"), // this is your verification sid
                        "+" + phoneNumber, //this is your Twilio verified recipient phone number
                        "sms") // this is your channel type
                .create();

        System.out.println(verification.getStatus());
        log.info("OTP has been successfully generated and awaits your verification {}", LocalDateTime.now());

    }

    public void verifyUserOTP(String phoneNumber, String otp) {

        Twilio.init(env.getProperty("TWILIO_ACCOUNT_SID"), env.getProperty("TWILIO_AUTH_TOKEN"));

        VerificationCheck verificationCheck = VerificationCheck.creator(
                        env.getProperty("PATH_SERVICE_SID"))  //pass verification SID here
                .setTo("+" + phoneNumber)
                .setCode(otp)  //pass generated OTP here
                .create();

        System.out.println(verificationCheck.getStatus());
        log.info("OTP has been successfully verified ", LocalDateTime.now());
    }


}

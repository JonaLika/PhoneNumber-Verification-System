# Phone Number Verification System 

This is a sample phone number verification system built using Java Spring Boot and Twilio Verify. The system allows
users to verify their phone numbers by sending a verification code to their phone via SMS or voice call.

## Technologies Used

- Java
- Spring Boot
- Twilio Verify API
- Maven

## Requirements

- Java 8 or later
- Maven
- Twilio account
- A verified Twilio phone number

## Steps 

- Create a Twilio account : https://www.twilio.com/try-twilio?promo=YbalWV
- Click on the Account Info drop down to access your credentials, copy them and store for later
    Account SID 
    Auth Token 
- Create a service 
    Navigate to the Verify section and create a verification service 
    Give the service a name and enable the SMS channel
    Copy the Service SID and store it for later

- To run this project, you'll need to have the following software installed on your machine:

    Java 11 or later
    Maven 3 or later
    Twilio SDK as a dependency in pom.xml
    Add to application.properties the variables Account SID, Auth Token, Service SID

-Run the following command to build and run the project

    mvn spring-boot:run

## Using the Application
Once the application is running, you can use the following endpoints to import and export data:

- GET /generateOTP: to generate an OTP for the clients phone number
- POST /verifyOTP : to verify the OTP generated for the client

You can test the endpoints using a tool like cURL or Postman. 


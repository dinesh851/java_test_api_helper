package com.example.trading.HelloWorldController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;


@RestController
// @RequestMapping("/api")
public class HelloWorldController {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/hello")
    public String helloWorld() {
        return "{\"message\": \"java, World!\"}";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/endpoint1")
    public String endpoint1() {
        try {
            // Set the values for the JSON payload
			String apkversion = "1.0.0";
            String uid = " ";
            String appkey = " ";
            String pwd = " ";
            String factor2 = " ";
            String vc = " ";
            String imei = " ";
            String source = "API"; 

            // Create a JSON string with the payload values
            String payload = "jData={\"apkversion\":\"" + apkversion +
                              "\",\"uid\":\"" + uid +
                              "\",\"appkey\":\"" + appkey +
                              "\",\"pwd\":\"" + pwd +
                              "\",\"factor2\":\"" + factor2 +
                              "\",\"vc\":\"" + vc +
                              "\",\"imei\":\"" + imei +
                              "\",\"source\":\"" + source + "\"}";

            // Set the URI for the POST request
            URI uri = new URI("https://api.shoonya.com/NorenWClientTP/QuickAuth");

            // Create the HTTP request object
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            // Create the HTTP client object
            HttpClient httpClient = HttpClient.newBuilder().build();

            // Capture the start time
            long startTime = System.currentTimeMillis();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            // Capture the end time        
            long endTime = System.currentTimeMillis();

            // Print the response
            System.out.println(response.body());

            // Calculate and print the time taken
            long timeTaken = endTime - startTime;
            System.out.println("Time taken: " + timeTaken + "ms");
            // Return the response as JSON
            return response.body();

        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
            return "{\"error\":\"An error occurred.\"}";
        } 
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/endpoint2")
    public String endpoint2 () {
        String secretKey = "52P5M54237Q7A763654424AC556Q22S4";

        // Create a new instance of GoogleAuthenticator
        GoogleAuthenticator gAuth = new GoogleAuthenticator();

        // Generate the TOTP token as a string
        int totpToken = gAuth.getTotpPassword(secretKey);
        String totpTokenString =String.valueOf(totpToken);
        System.out.println("TOTP Token: " + totpToken);
        return totpTokenString ;
    }

    @PostMapping("/endpoint3")
    public String endpoint3() {
        return "Endpoint 3";
    }

    @GetMapping("/endpoint4")
    public String endpoint4() {
        return "Endpoint 4";
    }

    @PostMapping("/endpoint5")
    public String endpoint5() {
        return "Endpoint 5";
    }
}

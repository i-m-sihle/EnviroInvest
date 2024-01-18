package com.enviro365.enviroinvests.controller;

import com.enviro365.enviroinvests.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")

public class CloudRenderApiService {
    CloudVendor cloudVendor;
    @GetMapping("{venderId}")
    public CloudVendor getCloudVendorDetails(String vendorId)
    {
        return cloudVendor;
//                ("C1", "Sihle", "Address 1" , "12345");
    }
    @PostMapping
    public String createCloudVenderDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return  "Cloud Vendor Created Succesfully ";
    }

}

package com.lti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegResponseDto;
import com.lti.dto.RetailerDocsDto;
import com.lti.dto.RetailerLoginDto;
import com.lti.dto.UpdateRetailer;
import com.lti.entity.Retailer;
import com.lti.service.RetailerService;

@RestController
@RequestMapping("/retailer")
@CrossOrigin(origins ="*")
public class RetailerController {

    @Autowired
    RetailerService retailerService;    

//    http://localhost:8181/OnlineShoppingWebApp/myapp/retailer/signup
    @RequestMapping(value="/signup" , method=RequestMethod.POST) //new usersignup1
    //@ResponseBody
    public RegResponseDto signup(@RequestBody Retailer retailer) {
        return retailerService.signup(retailer);
    }

    @PutMapping("/update")
    //@PutMapping(value =  "/update",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public UpdateRetailer updateProfile(@RequestBody Retailer retailer) {
        return retailerService.updateProfile(retailer);
    }

//    http://localhost:8181/OnlineShoppingWebApp/myapp/retailer/login
    @PostMapping("/login")
    public boolean login(@RequestBody RetailerLoginDto loginData) {
        boolean res = retailerService.retailerLogin(loginData.getId(), loginData.getPassword());

        return res;
    }

    @PostMapping("/pic-upload")
    public String uploadAdhaar( RetailerDocsDto retailerDocsDto) {
        String imageUploadLocation = "d:/retailerdocs/";
        String fileName = retailerDocsDto.getAddharCard().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        
        try {
            FileCopyUtils.copy(retailerDocsDto.getAddharCard().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Retailer retailer=retailerService.findRetailer(retailerDocsDto.getRetailerId());
        
        retailer.setAddharCard(fileName);
        UpdateRetailer updateRetailer= retailerService.updateProfile(retailer);
        if(updateRetailer!=null)
            return "File uploaded";
        return "Upload failed";
    }

    @PostMapping("/panupload")
    public String uploadPan( RetailerDocsDto retailerDocsDto) {
        String imageUploadLocation = "d:/retailerdocs/";
        String fileName = retailerDocsDto.getPanCard().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        
        try {
            FileCopyUtils.copy(retailerDocsDto.getPanCard().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Retailer retailer=retailerService.findRetailer(retailerDocsDto.getRetailerId());
        
        retailer.setPanCard(fileName);
        UpdateRetailer updateRetailer= retailerService.updateProfile(retailer);
        if(updateRetailer!=null)
            return "File uploaded";
        return "Upload failed";
    }
    
    @PostMapping("/certupload")
    public String uploadCert( RetailerDocsDto retailerDocsDto) {
        String imageUploadLocation = "d:/retailerdocs/";
        String fileName = retailerDocsDto.getRetailerCertificate().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        
        try {
            FileCopyUtils.copy(retailerDocsDto.getRetailerCertificate().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Retailer retailer=retailerService.findRetailer(retailerDocsDto.getRetailerId());
        
        retailer.setRetailerCertificate(fileName);
        UpdateRetailer updateRetailer= retailerService.updateProfile(retailer);
        if(updateRetailer!=null)
            return "File uploaded";
        return "Upload failed";
    }
    
    @GetMapping("/profile")
    public Retailer profile(@RequestParam("retailerId") int id, HttpServletRequest request) {
        //fetching customer data from the database
        Retailer retailer = retailerService.findRetailer(id);

        //reading the project's deployed folder location
        String projPath = request.getServletContext().getRealPath("/");
        String tempDownloadPath = projPath + "/downloads/";
        //creating a folder within the project where we will place the profile pic of the customer getting fetched
        File f = new File(tempDownloadPath);
        if(!f.exists())
            f.mkdir();
        String targetFile = tempDownloadPath + retailer.getAddharCard();
        System.out.println(targetFile);

        //the original location where the uploaded images are present
        String uploadedImagesPath = "d:/retailerdocs/";
        String sourceFile = uploadedImagesPath + retailer.getAddharCard();

        try {
            FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            //maybe for this customer there is no profile pic
        }

        return retailer;
    }
    
    @GetMapping("/viewProfileDetails/{retailerID}")
	public Retailer viewProfileDetails(@PathVariable int retailerID) {
		return retailerService.findRetailer(retailerID);
	}
}
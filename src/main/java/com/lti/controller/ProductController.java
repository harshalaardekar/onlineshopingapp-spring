package com.lti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ProductDto;
import com.lti.dto.ProductsDto;
import com.lti.dto.RetailerDocsDto;
import com.lti.dto.UpdateProduct;
import com.lti.dto.UpdateRetailer;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public boolean addProduct(@RequestBody Product product) {
		boolean message = productService.addProduct(product);
		return message;
	}
	
	@GetMapping("/viewAll")
	@ResponseBody
	public List<Product> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	@PostMapping("/pic-upload")
    public String uploadImage( ProductsDto productDto) {
        String imageUploadLocation = "d:/products/";
        String fileName = productDto.getProductImage().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        
        try {
            FileCopyUtils.copy(productDto.getProductImage().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Product product=productService.findProduct(productDto.getProductId());
        
        product.setProductImage(fileName);
        UpdateProduct updateProduct= productService.updateProfile(product);
        if(updateProduct!=null)
            return "File uploaded";
        return "Upload failed";
    }

	@GetMapping("/profile")
    public Product profile(@RequestParam("productId") int id, HttpServletRequest request) {
        //fetching customer data from the database
		Product product = productService.findProduct(id);

        //reading the project's deployed folder location
        String projPath = request.getServletContext().getRealPath("/");
        String tempDownloadPath = projPath + "/downloads/";
        //creating a folder within the project where we will place the profile pic of the customer getting fetched
        File f = new File(tempDownloadPath);
        if(!f.exists())
            f.mkdir();
        String targetFile = tempDownloadPath + product.getProductImage();
        System.out.println(targetFile);

        //the original location where the uploaded images are present
        String uploadedImagesPath = "d:/uploads/";
        String sourceFile = uploadedImagesPath + product.getProductImage();

        try {
            FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            //maybe for this customer there is no profile pic
        }

        return product;
    }
}

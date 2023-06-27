package com.demo_e.controller;


import com.demo_e.model.Product;
import com.demo_e.repo.ElasticSearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("")
public class ElasticSearchController {

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

//    @Autowired
//    private ProductRepo productRepo;

//    @PostMapping("/createOrUpdateDocument")
//    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Product product) throws IOException {
//        String response = elasticSearchQuery.createOrUpdateDocument(product);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

//    @GetMapping("/getDocument/{productId}")
//    public ResponseEntity<Object> getDocumentById(@PathVariable String productId) throws IOException {
//        Product product =  elasticSearchQuery.getDocumentById(productId);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/deleteDocument/{productId}")
//    public ResponseEntity<Object> deleteDocumentById(@PathVariable String productId) throws IOException {
//        String response =  elasticSearchQuery.deleteDocumentById(productId);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @GetMapping("/searchDocument")
    public ResponseEntity<Object> searchAllDocument() throws IOException {
        List<Product> products = elasticSearchQuery.searchAllDocuments();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//
//    @GetMapping("/searchName")
//    public ResponseEntity<Object> searchName(@RequestParam String name) throws IOException {
//        List<Product> products = productRepo.searchName(name);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
}
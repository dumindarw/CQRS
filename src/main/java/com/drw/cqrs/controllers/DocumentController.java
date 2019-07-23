package com.drw.cqrs.controllers;

import com.drw.cqrs.registry.DocumentServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/doc")
public class DocumentController {


    @Autowired
    DocumentServiceFactory documentServiceFactory;

    @PostMapping(value = "/upload/{docName}")
    public ResponseEntity<String> uploadDocument(@PathVariable("docName") String docName, @RequestParam("file") MultipartFile file) throws IOException {

        String response = documentServiceFactory.getService(docName).upload(file);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value="/download/{docName}/{docID}")
    public ResponseEntity<?> downloadDocument(@PathVariable("docName") String docName,@PathVariable("docID") int docID){

        return new ResponseEntity<>(documentServiceFactory.getService(docName).download(docID), HttpStatus.OK);
    }

}

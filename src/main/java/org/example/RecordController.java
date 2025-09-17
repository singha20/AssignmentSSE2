package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/load")
    public ResponseEntity<String> loadCsv(@RequestParam("file") MultipartFile file) {
        
        if(file.isEmpty()){
            return ResponseEntity.badRequest.body("File is empty");
        }
        recordService.loadCsv(file);

        return ResponseEntity.ok("CSV processed");
    }

    @GetMapping("/query")
    public ResponseEntity<List<Record>> query(@RequestParam String field, @RequestParam String value) {
        List<String> validFields = Arrays.asList("id", "name", "value");
        if(!validFields.contains(field.toLowerCase())) {
             return ResponseEntity.badRequest.body("Invalid field parameter");
        }
        List<Record> records = recordService.query(field, value);
        return ResponseEntity.ok(records);
    }
}

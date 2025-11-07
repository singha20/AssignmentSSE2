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
    private RecordRepository recordRepository;

    @PostMapping("/load")
    public ResponseEntity<String> load(@RequestParam("file") MultipartFile file) {
        //TODO
        return null;
    }

    @GetMapping("/query")
    public ResponseEntity<List<Record>> query(@RequestParam String field, @RequestParam String value) {
       //TODO
        return null;
    }
}


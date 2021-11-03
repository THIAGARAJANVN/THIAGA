package com.example.wordcounter.controller;

import com.example.wordcounter.exception.WordCounterException;
import com.example.wordcounter.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/wordLibrary")
@CrossOrigin
public class RestController {

    @Autowired
    WordService wordService;

    @GetMapping
    public String welcome() {
        return "Welcome to Word Counter Program";
    }

    @PostMapping("/addWord/{word}")
    public ResponseEntity<String> addWord(@PathVariable String word) {
    	String response = "Given word "+ "'"+ word + "'";
    	response = response.concat(wordService.addWord(word)? " is successfully added...": " is failed to add...");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/countWord/{word}")
    public ResponseEntity<String> countWord(@PathVariable String word) throws WordCounterException {
        int count = wordService.countWord(word);
        return ResponseEntity.ok("Word occurrence for " + word + " = " + count);
    }
}

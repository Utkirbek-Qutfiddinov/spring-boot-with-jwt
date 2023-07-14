package uz.utkirbek.springbootwithjwt.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: utkirbek.
 * Time: 19:22:46
 * Date: July 14, 2023, Friday
 */
@RestController
@RequestMapping("/api/report")
public class ReportController {

    @GetMapping
    public HttpEntity<?> getReport(){
        return ResponseEntity.ok( "This is report!");
    }
}

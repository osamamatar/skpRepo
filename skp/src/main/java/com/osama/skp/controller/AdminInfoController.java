package com.osama.skp.controller;

import com.osama.skp.service.AdminService;
import com.osama.skp.utilityClasses.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin/adminInfo")
public class AdminInfoController {
    @Autowired
    private AdminService adminService;



    @GetMapping
    public ResponseEntity<Page<?>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                           @RequestParam(required = false, defaultValue = "20") Integer size) {
        return ResponseEntity.ok(adminService.findAll(page, size));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<AdminDto> findById(@PathVariable String userName) {
        return ResponseEntity.ok(adminService.findById(userName));
    }

    @PostMapping
    public ResponseEntity<AdminDto> save(@RequestBody @Valid AdminDto adminDto) {
        return ResponseEntity.ok(adminService.save(adminDto));
    }


}

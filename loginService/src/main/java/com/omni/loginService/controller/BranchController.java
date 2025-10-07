package com.omni.loginService.controller;

import java.util.*;

import com.omni.loginService.middleware.IMiddlewareImp;
import com.omni.loginService.model.BranchRequest;
import com.omni.loginService.model.BranchResponse;
import com.omni.loginService.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/branches")
public class BranchController {

    private final IMiddlewareImp middleware;

    public BranchController(IMiddlewareImp middleware) {
        this.middleware = middleware;
    }


    @PostMapping("/search")
    public ResponseEntity<List<BranchResponse>> getNearBYBranches(@RequestBody BranchRequest request) {
        List<BranchResponse> response = middleware.getBranches(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

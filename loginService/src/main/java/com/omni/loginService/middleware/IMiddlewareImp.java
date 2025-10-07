package com.omni.loginService.middleware;

import com.omni.loginService.model.BranchRequest;
import com.omni.loginService.model.BranchResponse;
import com.omni.loginService.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IMiddlewareImp implements  IMiddleware{

    private final BranchService service;

    //@Autowired
    public IMiddlewareImp(BranchService service) {
        this.service = service;
    }

    @Override
    public List<BranchResponse> getBranches(BranchRequest request) {

        if((request.getCity()==null || request.getCity().isEmpty()) &&
          (request.getPincode()==null || request.getPincode().isEmpty())){
           throw new IllegalArgumentException("City and Pincode must not be null and Empty");
        }
        return service.findBranches(request.getCity(), request.getPincode());
    }
}

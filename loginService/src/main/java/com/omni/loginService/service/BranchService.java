package com.omni.loginService.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omni.loginService.model.BranchResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.ArrayList;

@Service
public class BranchService {

    public List<BranchResponse> findBranches(String city,String pincode){
        List<BranchResponse> result=new ArrayList<>();

        try{
            InputStream inputStream=new ClassPathResource("JSON/BranchData.json").getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode branches=mapper.readTree(inputStream).get("branches");

            for (JsonNode node: branches){
                String jsonCity=node.get("city").asText();
                String jsonPincode=node.get("pincode").asText();

                if((city !=null && city.equalsIgnoreCase(jsonCity)) ||
                  (pincode !=null && pincode.equalsIgnoreCase(jsonPincode))){

                    BranchResponse branch=new BranchResponse();
                    branch.setBranchName(node.get("branchName").asText());
                    branch.setAddress(node.get("address").asText());
                    branch.setContact(node.get("contact").asText());
                    branch.setIfsc(node.get("ifsc").asText());

                    result.add(branch);
                }
            }

        }catch (Exception e) {
            System.out.println("Error reading BranchData.json: " + e.getMessage());
        }
        return result;
    }
}

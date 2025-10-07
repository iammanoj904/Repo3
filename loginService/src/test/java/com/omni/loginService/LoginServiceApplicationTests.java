package com.omni.loginService;

import com.omni.loginService.model.BranchResponse;
import com.omni.loginService.service.BranchService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceApplicationTests {

    //private final BranchService service=new BranchService();

    private static BranchService service;
    @BeforeAll
    public static void beforeAll(){
        service=new BranchService();
    }

	@Test
	void contextLoads() {
        List<BranchResponse> lst=service.findBranches("Hyderabad",null);
        assertNotNull(lst);
        assertFalse(lst.isEmpty());

	}
    //test find by pincode

    @Test
    public void findByPincode(){
        List<BranchResponse> result=service.findBranches(null,"560038");
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Gurugram Trafic, Delhi", result.get(0).getAddress());
    }

    @Test
    public void find(){
        List<BranchResponse> res=service.findBranches("Delhi","560038");
        assertNotNull(res);

    }
    @AfterAll
    public static void afterAll(){
        //any message you can print
        System.out.println("All test cases are passed successfully");
    }

}

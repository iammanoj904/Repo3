package com.omni.loginService.middleware;

import java.util.*;
import com.omni.loginService.model.BranchRequest;
import com.omni.loginService.model.BranchResponse;

public interface IMiddleware {

   public List<BranchResponse> getBranches(BranchRequest request);
}

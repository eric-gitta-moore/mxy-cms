package com.mxycms.backend.controller.index;

import com.mxycms.backend.util.Result;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @GetMapping("/")
    public Result index() {
        return Result.success(1);
    }
}

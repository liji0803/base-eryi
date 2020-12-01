package com.hit.eryi.api.demo;

import com.hit.eryi.infrastructure.aspect.WebLog;
import com.hit.eryi.infrastructure.beans.model.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Api(description = "demo-API")
@RestController
@RequestMapping("base-eryi-api/api/demo")
public class DemoApi {

    @GetMapping("/get-by-id")
    @ApiOperation(value = "通过id查询数据", notes = "通过id查询数据")
    @WebLog
    Response getById(@RequestParam Integer id) {
        return Response.success(id);
    }

    @PostMapping("/test-abc")
    Response testAbc(@RequestParam String... a){
        return Response.success(a);
    }

    @PostMapping("/test/{urlCode}")
    Response testUrlCode(@PathVariable("urlCode") String urlCode,@RequestBody Map<String,Object> map){
        if("abc".equals(urlCode)){
            return Response.success(urlCode);
        }
        return Response.fail(443,"错误的url");

    }
}

package com.hit.eryi.api.createdir;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("api/create-dir")
public interface CreateDirApi {

    @PostMapping("create-by-excel")
    @ApiOperation(value = "按条件查询数据", notes = "注意问题点")
    void createDirByExcel(@RequestParam MultipartFile file, @RequestParam String prefix) ;
}

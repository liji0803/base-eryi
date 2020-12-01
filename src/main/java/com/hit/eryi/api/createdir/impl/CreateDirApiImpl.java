package com.hit.eryi.api.createdir.impl;

import com.hit.eryi.api.createdir.CreateDirApi;
import com.hit.eryi.infrastructure.utils.ImportExcelUntil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Slf4j
@Api(description = "创建文件夹")
@RestController
public class CreateDirApiImpl implements CreateDirApi {

    @Override
    public void createDirByExcel(@RequestParam MultipartFile file, String prefix) {
        if(prefix == null  || prefix == ""){
            prefix = "/Users/eryi/";
        }
        try {
            List<List<String>> list = ImportExcelUntil.ReadExcel(file);
            for (List<String> strings : list) {
                String abc = StringUtils.strip(strings.toString().replaceAll(",","/"),"[]");
                log.info("abc:{}",abc);
                String dirPath = prefix + abc.trim();
                File file1 = new File(dirPath);
                if (!file1.exists()) {
                    file1.mkdirs();
                }
            }
            log.info("list:{}",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

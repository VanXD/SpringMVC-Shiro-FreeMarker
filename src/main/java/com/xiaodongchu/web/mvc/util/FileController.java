package com.xiaodongchu.web.mvc.util;

import com.alibaba.druid.util.StringUtils;
import com.xiaodongchu.component.file.FileUtil;
import com.xiaodongchu.component.response.RespCode;
import com.xiaodongchu.component.response.RespJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Administrator on 2016/3/10.
 */
@RequestMapping("/util")
@Controller
public class FileController {

    @Autowired
    private FileUtil fileUtil;

    @RequestMapping("/uploadFile")
    @ResponseBody
    public RespJSON<Map> uploadFile(Map map, MultipartFile file) {
        String fileUrl = fileUtil.saveFile(file);
        if(StringUtils.isEmpty(fileUrl)) {
            return new RespJSON<>(RespCode.FAIL);
        } else {
            map.put("url", fileUrl);
            return new RespJSON<>(map);
        }
    }
}

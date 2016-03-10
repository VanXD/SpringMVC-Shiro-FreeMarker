package com.xiaodongchu.component.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by Administrator on 2016/3/10.
 */
@Component
public class FileUtil {

    @Value("${upload.file.src}")
    private String picDir;
    @Value("${upload.file.prefix}")
    private String urlPrefix;

    public String saveFile(MultipartFile filedata) {
        // 根据配置文件获取服务器图片存放路径
        String suffix = filedata.getContentType().split("/")[1];
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." +suffix;
        String saveFilePath = picDir;

        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        try {
            FileOutputStream out = new FileOutputStream(saveFilePath + fileName);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
            return saveFilePath.replace(urlPrefix, "") + fileName;
        } catch (Exception e) {
            return null;
        }
    }
}

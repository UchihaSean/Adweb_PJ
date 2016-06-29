package adweb.controller;

import adweb.Config;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;

/**
 * Created by zhouyi on 16-6-29.
 */
@Controller
public class UploadController {
//    @Autowired
//    private UploadService uploadService;


    @RequestMapping(value = "/upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public @ResponseBody
    HashMap upload(@RequestParam("fileData")MultipartFile fileData){
        String name="gotoschool";
        File file=new File(Config.RESOURCE_FOLDER+name);
        try {
            if(file.exists())
                file.delete();
            file.createNewFile();
            fileData.transferTo(file);
        }catch (Exception e){}

        return Maps.newHashMap(ImmutableMap.of("url",name));
    }
}

package adweb.controller;

import adweb.service.AdwebService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * Created by zhouyi on 16-6-30.
 */
@RestController
public class ExcitedController {

    @Autowired
    private AdwebService adwebService;

    @RequestMapping("/")
    public HashMap printWelcome() {
        return Maps.newHashMap(ImmutableMap.of("value","这里是高级web pj的后台"));
    }

    @RequestMapping("/register/{username}/{password}")
    public HashMap register(@PathVariable String username,
                            @PathVariable String password) {
        return Maps.newHashMap(ImmutableMap.of("value", adwebService.register(username, password)));
    }

    @RequestMapping("/login/{username}/{password}")
    public HashMap login(@PathVariable String username,
                         @PathVariable String password) {
        return Maps.newHashMap(ImmutableMap.of("value", adwebService.login(username, password)));
    }

    @RequestMapping(value = "/portrait/{uid}", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public HashMap upload(@PathVariable int uid,
                          @RequestParam("fileData") MultipartFile fileData) {
        return Maps.newHashMap(ImmutableMap.of("value", adwebService.setPortrait(uid, fileData)));
    }

    @RequestMapping(value = "/action/show/{uid}/{aid}")
    public HashMap showActions(@PathVariable int uid,
                               @PathVariable int aid) {
        return Maps.newHashMap(ImmutableMap.of("value", adwebService.getActions(uid,aid)));
    }
}

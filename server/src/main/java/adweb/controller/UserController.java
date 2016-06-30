package adweb.controller;

import adweb.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register/{username}/{password}")
    public HashMap register(@PathVariable String username,
                            @PathVariable String password) {
        return Maps.newHashMap(ImmutableMap.of("value", userService.register(username, password)));
    }

    @RequestMapping("/login/{username}/{password}")
    public HashMap login(@PathVariable String username,
                         @PathVariable String password) {
        return Maps.newHashMap(ImmutableMap.of("value", userService.login(username, password)));
    }

    @RequestMapping(value = "/portrait/{uid}", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public HashMap upload(@PathVariable int uid,
                          @RequestParam("fileData") MultipartFile fileData) {
        return Maps.newHashMap(ImmutableMap.of("value", userService.setPortrait(uid, fileData)));
    }

}

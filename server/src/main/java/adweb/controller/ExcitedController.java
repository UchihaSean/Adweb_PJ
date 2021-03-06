package adweb.controller;

import adweb.model.View;
import adweb.service.AdwebService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

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
        return Maps.newHashMap(ImmutableMap.of("uid", adwebService.register(username, password)));
    }

    @RequestMapping("/login/{username}/{password}")
    public HashMap login(@PathVariable String username,
                         @PathVariable String password) {
        return Maps.newHashMap(ImmutableMap.of("uid", adwebService.login(username, password)));
    }

//    @RequestMapping(value = "/portrait/{uid}", headers = "content-type=multipart/*", method = RequestMethod.POST)
//    public HashMap upload(@PathVariable int uid,
//                          @RequestParam("fileData") MultipartFile fileData) {
//        return Maps.newHashMap(ImmutableMap.of("value", adwebService.setPortrait(uid, fileData)));
//    }

    @RequestMapping(value="/setPortrait/{uid}")
    public HashMap setPortrait(@PathVariable int uid){
        return Maps.newHashMap(ImmutableMap.of("value",adwebService.setPortrait(uid)));
    }

    @RequestMapping(value = "/action/show/{uid}/{aid}")
    public List<View> showActions(@PathVariable int uid,
                               @PathVariable int aid) {
        return adwebService.getActions(uid,aid);
    }
    @RequestMapping(value="/info/{vid}")
    public View getViewInfo(@PathVariable int vid){
        return adwebService.getViewInfo(vid);
    }

    @RequestMapping(value="/view")
    public List<View> getAllView(){
        return adwebService.getAllView();
    }

    @RequestMapping(value="/search/{uid}/{name}")
    public List<View> searchView(@PathVariable int uid,@PathVariable String name){
        return adwebService.searchView(uid,name);
    }

    @RequestMapping(value="/history/search/{uid}/{aid}")
    public List<HashMap> searchHistory(@PathVariable int uid,@PathVariable int aid){
        return adwebService.searchHistory(uid,aid);
    }

    @RequestMapping(value="/rankings/{category}/{aid}")
    public List<HashMap> rankByAction(@PathVariable int category,@PathVariable int aid){
        return adwebService.rankByAction(category,aid);
    }

    @RequestMapping(value="/grade/{vid}")
    public HashMap gradeOfView(@PathVariable int vid){
        return adwebService.gradeOfView(vid);
    }

    @RequestMapping(value="/comment/show/{vid}")
    public List<HashMap> getAllComments(@PathVariable int vid){
        return adwebService.getAllComments(vid);
    }

    @RequestMapping(value="/action/add/{uid}/{vid}/{aid}")
    public boolean addAction(@PathVariable int uid,@PathVariable int vid,@PathVariable int aid){
        return adwebService.addAction(uid, vid, aid);
    }

    @RequestMapping(value="/action/delete/{uid}/{vid}/{aid}")
    public boolean deleteAction(@PathVariable int uid,@PathVariable int vid,@PathVariable int aid){
        return adwebService.deleteAction(uid, vid, aid);
    }

    @RequestMapping(value="/flag/show/{ftype}/{vid}")
    public List<HashMap> getFlag(@PathVariable int ftype,@PathVariable int vid){
        return adwebService.getFlag(ftype,vid);
    }

    @RequestMapping(value="/flag/add/{fid}/{vid}/{longitude}/{latitude}/{addition}")
    public boolean addFlag(@PathVariable int fid,@PathVariable int vid, @PathVariable double longitude,
                           @PathVariable double latitude,@PathVariable String addition ){
        return adwebService.addFlag(fid, vid, longitude, latitude, addition);
    }

    @RequestMapping(value="/neighbour/{aid}/{longitude}/{latitude}")
    public List<HashMap> rankOfNeighbour(@PathVariable int aid,@PathVariable double longitude,@PathVariable double latitude){
        return adwebService.rankOfNeighbour(aid, longitude, latitude);
    }

//    @RequestMapping(value = "/comment/picture", headers = "content-type=multipart/*", method = RequestMethod.POST)
//    public HashMap setPicture(
//                          @RequestParam("fileData") MultipartFile fileData) {
//        return Maps.newHashMap(ImmutableMap.of("url", adwebService.setPicture(fileData)));
//    }

    @RequestMapping(value = "/comment/picture")
    public HashMap setPicture() {
        return Maps.newHashMap(ImmutableMap.of("value",adwebService.setPicture()));
    }

    @RequestMapping(value="/comment/add/{uid}/{vid}/{grade}/{detail}/{url}/{type}/{addition}")
    public boolean addComment(@PathVariable int uid,@PathVariable int vid,@PathVariable int grade,
                              @PathVariable String detail,@PathVariable String url,@PathVariable int type,@PathVariable String addition){
        return adwebService.addComment(uid,vid,grade,detail,url,type,addition);
    }

    @RequestMapping(value="/route/schedule/{name_x}/{name_y}")
    public List<View> routeSchedule(@PathVariable String name_x,@PathVariable String name_y){
        return adwebService.routeSchedule(name_x,name_y);
    }

    @RequestMapping(value="/view/area/{vid}")
    public String[] viewArea(@PathVariable int vid){
        return adwebService.viewArea(vid);
    }

    @RequestMapping(value="recommand/{uid}")
    public HashMap recommand(@PathVariable int uid){
        return adwebService.recommand(uid);
    }

}

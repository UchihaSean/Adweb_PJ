package adweb.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public HashMap printWelcome() {
		return Maps.newHashMap(ImmutableMap.of("value","这里是高级web pj的后台"));
	}
}
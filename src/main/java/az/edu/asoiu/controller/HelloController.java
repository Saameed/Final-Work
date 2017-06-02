package az.edu.asoiu.controller;

import az.edu.asoiu.entity.RelDiseaseIndicator;
import az.edu.asoiu.repository.BaseRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class HelloController {

    private final BaseRepository baseRepository;

    @Autowired
    public HelloController(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @RequestMapping(value = "admin-page", method = RequestMethod.GET)
    public String welcomeAdmin(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "admin_view1";
    }

    @RequestMapping(value = {"private", "login"}, method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        return "login";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {
        List<RelDiseaseIndicator> result = baseRepository.getDiseaseParamsWithLimit(15, "desc");
        System.out.println("--------------------0000000000000000000"+new ObjectMapper().writeValueAsString(result));
        request.setAttribute("disease", result);
        map.put("diseases", result);
        List aaa = baseRepository.findAll("Məxmərək");
        System.out.println("+_)_+___)+_)+__+_)_)+_+)_"+new ObjectMapper().writeValueAsString(aaa));
        return "index";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String findAllParam(HttpServletRequest request, @RequestParam("key") String key) throws Exception {
        System.out.println("kotroller---------------");

        List result = baseRepository.findAll(key);
        System.out.println("controller resulttttt :" + result);
        return result.toString();
    }


}
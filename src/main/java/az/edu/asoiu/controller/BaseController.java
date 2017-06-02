package az.edu.asoiu.controller;

import az.edu.asoiu.repository.BaseRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Hp on 22.05.2017.
 */
@Controller
@RequestMapping("/base")
public class BaseController {
    Logger logger = Logger.getLogger(BaseController.class);
    private final BaseRepository baseRepository;

    @Autowired
    public BaseController(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findAllParam(HttpServletRequest request, @RequestParam(value = "key", required = false) String key) throws Exception {
        logger.info("Request(rest/findAll)");
        List<Map> result = baseRepository.findAll(key);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}

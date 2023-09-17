package se.sbab.sbabbe.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import se.sbab.sbabbe.DTOs.TopLine;
import se.sbab.sbabbe.Services.ILineAndStopService;

@RestController
public class LineAndStopController {

    private ILineAndStopService service;

    public LineAndStopController(ILineAndStopService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/top")
    public List<TopLine> getTop10Lines() {
        return service.getTop10Lines();
    }
}

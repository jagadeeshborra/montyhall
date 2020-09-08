package com.game.montyhall.simulator.api;

import com.game.montyhall.simulator.service.MontyHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class MontyHallController {
    private final MontyHallService montyHallService;

    @Autowired
    public MontyHallController(MontyHallService montyHallService)
    {
        this.montyHallService = montyHallService;
    }

    @GetMapping("/play/{iterations}/{switches}")
    public String play(@PathVariable int iterations, @PathVariable boolean switches)  {
        try
        {
            return montyHallService.play(iterations, switches);
        }
        catch (Exception e)
        {
            return "Exception Occurred, please try again";
        }
    }

}

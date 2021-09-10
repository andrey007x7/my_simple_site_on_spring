package com.timeController.timer.controllers;

import com.timeController.timer.TimeDown;
import com.timeController.timer.models.Timer;
import com.timeController.timer.repo.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;

@Controller
public class TimerController {
    private final TimerRepository timerRepository;

    @Autowired
    public TimerController(TimerRepository timerRepository) {
        this.timerRepository = timerRepository;
    }

    @GetMapping("/timer")
    public String timer(Model model) {
        Iterable<Timer> timers = timerRepository.findAll();
        model.addAttribute("timer", timers);
        return "/timer";
    }

    @PostMapping("/timer")
    public String addTimer(@RequestParam int time) {
        Timer timer = new Timer(time);
        timerRepository.save(timer);
        Thread thread = new Thread(new TimeDown(timer, timerRepository));
        thread.start();
        return "redirect:/timer";
    }

}

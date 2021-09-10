package com.timeController.timer;

import com.timeController.timer.models.Timer;
import com.timeController.timer.repo.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class TimeDown implements Runnable{
    private Timer timer;

    private TimerRepository timerRepository;

    public TimeDown(Timer timer, TimerRepository timerRepository) {
        this.timer = timer;
        this.timerRepository = timerRepository;
    }

    @Override
    public void run() {
        int time = timer.getTime();
        while (time > 0) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
            timer.setTime(time);
            timerRepository.save(timer);
        }
    }
}

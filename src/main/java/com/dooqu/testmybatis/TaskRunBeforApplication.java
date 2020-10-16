package com.dooqu.testmybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class TaskRunBeforApplication implements CommandLineRunner {
    static Logger logger = Logger.getLogger(TaskRunBeforApplication.class.getSimpleName());
    @Override public void run(String... args) throws Exception {
        logger.info("TaskRunBeforeApplication");

    }
}

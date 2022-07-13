package project.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void info(String log) {
        logger.info("[CALC] " + log);
    }

    public void warn(String log) {
        logger.warn("[CALC] " + log);
    }

    public void error(String log) {
        logger.error("[CALC] " + log);
    }
}

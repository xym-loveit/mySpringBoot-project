package com.xym.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author xym
 */
@Service
public class TestService {

    private static Logger logger = LoggerFactory.getLogger(TestService.class);

    public TestService() {
        logger.error("------------------------一条error日志");
        logger.warn("------------------------一条warn日志");
        logger.info("------------------------一条info日志");
        logger.debug("------------------------一条debug日志");
        logger.trace("------------------------一条trace日志");
    }

}

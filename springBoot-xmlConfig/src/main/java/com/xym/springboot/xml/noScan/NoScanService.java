package com.xym.springboot.xml.noScan;

import org.springframework.stereotype.Service;

/**
 * @author xym
 */
@Service
public class NoScanService {

    public NoScanService() {
        System.out.println("I am NoScanService,i can not be scan");
    }

}

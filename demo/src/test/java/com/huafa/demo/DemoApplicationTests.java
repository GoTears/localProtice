package com.huafa.demo;

import com.huafa.demo.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Test
    public void testStudent() {

    }

}

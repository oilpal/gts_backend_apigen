package com.neofect.gts.core.services.member;

import com.neofect.gts.GtsTestApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GtsTestApp.class, properties = "spring.main.web-application-type=none")
@Transactional
public class MemberTest {


    @Test
    public void passwordEncodeTest() throws Exception {

    }
}

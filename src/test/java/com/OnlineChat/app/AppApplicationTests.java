package com.OnlineChat.app;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {
	Logger log = LoggerFactory.getLogger(AppApplicationTests.class);

	@Test
	void contextLoads() {
		log.info("Welcome to online chat: Enjoy ");
	}



}

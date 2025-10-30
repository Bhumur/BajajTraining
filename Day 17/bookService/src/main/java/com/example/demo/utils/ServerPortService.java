package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class ServerPortService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	private int port;
	
	@EventListener
	public void onApplicationEvent(ServletWebServerInitializedEvent event) {
		log.info("Server Port : " + event.getWebServer().getPort());
		this.port = event.getWebServer().getPort();
	}
	
	public int getPort() {
		return this.port;
	}
}

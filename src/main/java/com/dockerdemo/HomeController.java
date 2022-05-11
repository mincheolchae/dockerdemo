package com.dockerdemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger( getClass() );

	@GetMapping("/")
	public String home() {
		logger.info( "here i am.." );
		return "index";
	}
}

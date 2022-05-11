package com.dockerdemo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

	private final ContentsRepository contentsRepository;
	private final Logger logger = LoggerFactory.getLogger( getClass() );

	@GetMapping("/")
	public String home() {
		logger.info( "here i am.." );
		return "/index";
	}

	@GetMapping("/test")
	public String test() {
		logger.info( "test mapping.." );
		return "/test";
	}

	@ResponseBody
	@GetMapping("/sample")
	public String sample() {
		logger.info( "sampling.." );
		return "SAMPLE!!";
	}

	@GetMapping("/form")
	public String form() {
		logger.info( "here's FORM!" );
		return "/form";
	}

	@PostMapping( "/form" )
	public String form( @ModelAttribute ContentRequest content ) {
		contentsRepository.save( new Contents( content.getContent() ) );
		return "redirect:/form";
	}

	@GetMapping( "/list" )
	public String list( Model model ) {
		logger.info( "here's LIST" );
		List<Contents> contents = new ArrayList<>();
		Iterable<Contents> contentsIterable = contentsRepository.findAll();
		contentsIterable.forEach( contents::add );

		model.addAttribute( "contents", contents );
		return "/list";
	}

	@Data
	@AllArgsConstructor
	static class ContentRequest {

		private String content;
	}
}

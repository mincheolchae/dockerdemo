package com.dockerdemo.test;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Contents {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String content;

	public Contents( String content ) {
		this.content = content;
	}
}

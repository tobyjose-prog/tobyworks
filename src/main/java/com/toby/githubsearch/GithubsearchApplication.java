package com.toby.githubsearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GithubsearchApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new GithubsearchApplication().configure(new SpringApplicationBuilder(GithubsearchApplication.class)).run(args);
	}

}

package com.realtime.blog_api

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringbootKotlinThymeleafBlogApiApplication {

	@Bean
	fun modelMapper(): ModelMapper {
		return ModelMapper()
	}
}

fun main(args: Array<String>) {
	runApplication<SpringbootKotlinThymeleafBlogApiApplication>(*args)
}

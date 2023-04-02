package com.realtime.blog_api

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class SpringbootKotlinThymeleafBlogApiApplication(@Autowired private val passwordEncoder: PasswordEncoder) : CommandLineRunner {
	override fun run(vararg args: String) {
		println(this.passwordEncoder.encode("ritesh123"))
	}

	@Bean
	fun modelMapper(): ModelMapper =  ModelMapper()
}

fun main(args: Array<String>) {
	runApplication<SpringbootKotlinThymeleafBlogApiApplication>(*args)
}

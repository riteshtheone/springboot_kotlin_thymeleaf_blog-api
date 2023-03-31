package com.realtime.blog_api

import com.realtime.blog_api.dao.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringbootKotlinThymeleafBlogApiApplicationTests(
	@Autowired
	private val userRepository: UserRepository
) {


	@Test
	fun contextLoads() {

	}

	@Test
	fun repositoryTest(){
		println(this.userRepository.javaClass.name)
		println(this.userRepository.javaClass.packageName)
	}

}

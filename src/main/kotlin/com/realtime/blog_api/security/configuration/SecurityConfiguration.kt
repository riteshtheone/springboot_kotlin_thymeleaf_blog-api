//package com.realtime.blog_api.security.configuration
//
//import com.realtime.blog_api.security.service.impl.UserDetailsServiceImpl
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.web.SecurityFilterChain
//import org.springframework.web.servlet.config.annotation.EnableWebMvc
//
//@Configuration
//@EnableWebSecurity
//@EnableWebMvc
//class SecurityConfiguration(
//    @Autowired private val userDetailsService: UserDetailsServiceImpl
//    ) {
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
//
//    @Bean
//    fun authenticationProvider(): AuthenticationProvider {
//        val authenticationProvider = DaoAuthenticationProvider()
//        authenticationProvider.setUserDetailsService(this.userDetailsService)
//        authenticationProvider.setPasswordEncoder(this.passwordEncoder())
//        return authenticationProvider
//    }
//
//    @Bean
//    @Throws(Exception::class)
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
//        http.csrf().disable().authorizeHttpRequests().requestMatchers("/v3/api-docs", "/v2/api-docs", "swagger-resources/**", "/swagger-ui/**", "webjars/**").permitAll().anyRequest().authenticated().and().httpBasic()
//        return http.build()
//    }
//}
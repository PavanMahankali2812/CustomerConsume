package com.pkglobal.subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSubscriberApplication.class, args);
	}

}

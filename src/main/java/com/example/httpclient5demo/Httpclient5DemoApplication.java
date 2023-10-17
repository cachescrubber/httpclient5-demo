package com.example.httpclient5demo;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Httpclient5DemoApplication implements CommandLineRunner {

	public Httpclient5DemoApplication(RestTemplateBuilderConfigurer configurer) {
		this.configurer = configurer;
	}

	public static void main(String[] args) {
		SpringApplication.run(Httpclient5DemoApplication.class, args);
	}

	private final RestTemplateBuilderConfigurer configurer;

	@Override
	public void run(String... args) throws Exception {
//		RestTemplate restTemplate = configurer.configure(new RestTemplateBuilder())
//				.requestFactory(() -> {
//					RequestConfig.Builder requestConfig = RequestConfig.custom()
//							.setRedirectsEnabled(true);
//					HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
//							.setDefaultRequestConfig(requestConfig.build());
//					return new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build());
//				})
//				.rootUri("https://httpbin.org")
//				.build();
//
//		String forObject = restTemplate.getForObject("/redirect-to?url=https://httpbin.org/base64/SFRUUEJJTiBpcyBhd2Vzb21l", String.class);
//
//		System.out.println("XXX: " +forObject);
	}
}

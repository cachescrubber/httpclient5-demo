package com.example.httpclient5demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class Httpclient5DemoApplicationTests {

	@Test
	void contextLoads(@Autowired RestTemplateBuilderConfigurer configurer) {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		configurer.configure(restTemplateBuilder);

		RestTemplate restTemplate = restTemplateBuilder
				.requestFactory(() -> {
					RequestConfig.Builder requestConfig = RequestConfig.custom()
							.setRedirectsEnabled(true);
					HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
							.setDefaultRequestConfig(requestConfig.build());
					HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build());
					//return requestFactory;
					return new BufferingClientHttpRequestFactory(requestFactory);
				})
				.rootUri("https://httpbin.org")
				.build();

		String response = restTemplate.getForObject("/redirect-to?url=https://httpbin.org/base64/SFRUUEJJTiBpcyBhd2Vzb21l", String.class);
		assertThat(response).isEqualTo("HTTPBIN is awesome");
	}

}

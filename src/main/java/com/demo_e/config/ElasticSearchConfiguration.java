package com.demo_e.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.erhlc.RestHighLevelClientFactoryBean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
//@EnableElasticsearchRepositories(basePackages
//        = "io..elasticsearch.repositories")
//@ComponentScan(basePackages = { "io.pratik.elasticsearch" })
public class ElasticSearchConfiguration
{
    @Bean
    public RestHighLevelClient getRestClient() {
        RestHighLevelClient restClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        return restClient;
    }


}
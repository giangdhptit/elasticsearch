package com.demo_e.repo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.aggregations.AggregationBuilders;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.demo_e.model.Product;
import org.elasticsearch.action.admin.indices.create.CreateIndexAction;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.metrics.SumAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ElasticSearchQuery {

    @Autowired
    private RestHighLevelClient elasticsearchClient;

    private final String indexName = "products";

//    public String createOrUpdateDocument(Product product) throws IOException {
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
//        CreateIndexRequestBuilder createIndexRequestBuilder= new CreateIndexRequestBuilder(elasticsearchClient, indexName);
//
//        IndexResponse response = elasticsearchClient.index(i -> i
//                .index(indexName)
//                .id(product.getId())
//                .document(product)
//        );
//
//        if(response.result().name().equals("Created")){
//            return new StringBuilder("Document has been successfully created.").toString();
//        }else if(response.result().name().equals("Updated")){
//            return new StringBuilder("Document has been successfully updated.").toString();
//        }
//        return new StringBuilder("Error while performing the operation.").toString();
//    }
//
//    public Product getDocumentById(String productId) throws IOException{
//        Product product = null;
//        GetResponse<Product> response = elasticsearchClient.get(g -> g
//                        .index(indexName)
//                        .id(productId),
//                Product.class
//        );
//
//        if (response.found()) {
//            product = response.source();
//            System.out.println("Product name " + product.getName());
//        } else {
//            System.out.println ("Product not found");
//        }
//
//        return product;
//    }
//
//    public String deleteDocumentById(String productId) throws IOException {
//
//        DeleteRequest request = DeleteRequest.of(d -> d.index(indexName).id(productId));
//
//        DeleteResponse deleteResponse = elasticsearchClient.delete(request);
//        if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
//            return new StringBuilder("Product with id " + deleteResponse.id() + " has been deleted.").toString();
//        }
//        System.out.println("Product not found");
//        return new StringBuilder("Product with id " + deleteResponse.id()+" does not exist.").toString();
//
//    }

    public List<Product> searchAllDocuments() throws IOException {

        List<Product> products = new ArrayList<>();
        SearchRequest searchRequest =  new SearchRequest();
        searchRequest.indices(indexName);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.wildcardQuery("name","**bc**"));
        searchRequest.source(searchSourceBuilder);

        Map<String, Object> map=null;
        try {
            SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);
            if(searchResponse.getHits().getTotalHits().value>0){
                SearchHit[] hits = searchResponse.getHits().getHits();
                for (SearchHit hit:hits){
                    //map = hit.g();
                    map =  hit.getSourceAsMap();
                    //products.put((Product) hit.getSourceAsMap());
                    System.out.println(map);
                    //products.add(map.values().stream().collect(Collectors.toList()));
                    product = new
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return products;
    }
//    public List<Product> searchName(String name) throws IOException{
//        SearchRequest searchRequest =   SearchRequest.of(s -> s.index("kibana_sample_data_ecommerce"));
//        //=
////        SearchRequest searchRequest = new SearchRequestBuilder(c);
////        searchRequest.indices("products");
//        SumAggregationBuilder aggregationBuilders = AggregationBuilders.sum("total_q")
//
//        SearchResponse searchResponse= elasticsearchClient.search(searchRequest, Product.class);
//
//        List<Product> products = new ArrayList<>();
//
//        return products;
//    }
}
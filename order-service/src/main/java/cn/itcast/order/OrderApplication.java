package cn.itcast.order;


import cn.itcast.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.itcast.feign.clients",defaultConfiguration = DefaultFeignConfiguration.class)

public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /** 1.第一种方式
     * 通过bean注入的方法 实现 随机策略(负载均衡)
     * @return
     */
/*    @Bean
    public IRule iRule(){
        return new RandomRule();
    }*/
}
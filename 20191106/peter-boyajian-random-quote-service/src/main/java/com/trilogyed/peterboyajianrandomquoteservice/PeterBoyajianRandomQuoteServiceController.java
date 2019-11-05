package com.trilogyed.peterboyajianrandomquoteservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class PeterBoyajianRandomQuoteServiceController {
    @Value("${quote1}")
    private String quote1;
    @Value("${quote2}")
    private String quote2;
    @Value("${quote3}")
    private String quote3;
    @Value("${quote4}")
    private String quote4;
    @Value("${quote5}")
    private String quote5;
    @Value("${quote6}")
    private String quote6;
    @Value("${quote7}")
    private String quote7;
    @Value("${quote8}")
    private String quote8;
    private List<String> quotes=new ArrayList<>();
    private Random random=new Random();
    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${magicEightBallServiceName}")
    private String magicEightBallServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @RequestMapping(value = "/quote",method = RequestMethod.GET)
    public String getRandomQuote(){
        quotes.addAll(Arrays.asList(quote1,
                quote2,
                quote3,
                quote4,
                quote5,
                quote6,
                quote7,
                quote8));
        int rand=random.nextInt(quotes.size());
        return quotes.get(rand);
    }
    @GetMapping(value = "/answerme")
    public String getAnswer(){
        List<ServiceInstance> instances = discoveryClient.getInstances(magicEightBallServiceName);

        String magicEightBallServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        return restTemplate.getForObject(magicEightBallServiceUri, String.class);
    }

}

package com.example.demo.settings;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppSetting {
    private String url; 
    private String port;
    private Cors cors;

    @Getter
    @Setter
    public static class Cors {
        private List<String> allowedHosts;
    }
}

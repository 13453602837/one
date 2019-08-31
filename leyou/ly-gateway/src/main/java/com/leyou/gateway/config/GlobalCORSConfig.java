package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCORSConfig {

    @Bean
    public CorsFilter corsFilter(){
        //        1.添加cors的配置信息
        CorsConfiguration config = new CorsConfiguration();
//          允许访问的域
        config.addAllowedOrigin("http://manage.leyou.com");
//          是否允许发送cookie
        config.setAllowCredentials(true);
//          允许的请求方式
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.PUT);
//          允许的头信息
        config.addAllowedHeader("*");
//          访问有效期
        config.setMaxAge(3600L);

//       2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
//       3.返回新的CORSFilter
        return new CorsFilter(source);
    }
}

package com.sctbc.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DruidConfig {


    //加载Druid配置
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    //Druid的界面后台初始化
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //设置请求地址
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin"); //设置登录用户名
        initParams.put("loginPassword", "admin"); //设置登录密码
        initParams.put("allow", "");//默认所有人可以访问
        initParams.put("deny", ""); //等待时间默认
        bean.setInitParameters(initParams);
        return bean;
    }

    //Druid的后台拦截器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bea=new FilterRegistrationBean();
        bea.setFilter(new WebStatFilter()); //初始化过滤器

        Map<String, String> initParams=new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*"); //不过滤这些请求
        bea.setInitParameters(initParams);
        bea.setUrlPatterns(Arrays.asList("/*"));
        return  bea;
    }
}




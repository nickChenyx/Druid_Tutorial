package com.nickchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 运行起来之后
 * http://localhost:8080/druid/spring.html
 * 可以显示 druid 的监控信息
 * @author nickChen
 * @create 2017-07-27 9:34.
 */
@SpringBootApplication
public class App {

    private DataSource datasource;

    @Autowired
    public App(DataSource datasource) {
        this.datasource = datasource;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }


    @Bean
    CommandLineRunner command(){
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Connection conn = datasource.getConnection();
                PreparedStatement stat = conn.prepareStatement("SELECT * FROM users");
                ResultSet resultSet = stat.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        };
    }
}

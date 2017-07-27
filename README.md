# Druid Tutorial

**quick start**
- use maven to import project.
- run `App.main` 

快速创建 DataSource：

```java
    @Bean
    @ConfigurationProperties("spring.datasource.druid")  // "spring.datasource 也可"
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }

```

多数据源绑定：

```java
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

```
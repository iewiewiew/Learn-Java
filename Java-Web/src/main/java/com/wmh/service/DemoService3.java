package com.wmh.service;

import com.wmh.domain.Demo3;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author weimenghua
 * @time 2022-12-03 18:25
 * @description
 *
 * Spring Data JPA接口文档：https://docs.spring.io/spring-data/data-jpa/docs/current/api/
 */

@CacheConfig(cacheNames = "demo3")
public interface DemoService3 extends JpaRepository<Demo3, Long> {
    @Cacheable
    Demo3 findByUsername(String username);

    @Query("from Demo3 d where d.username=:username")
    Demo3 findDemo3(@Param("username") String username);
}

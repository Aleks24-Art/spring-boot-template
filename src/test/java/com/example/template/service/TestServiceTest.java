package com.example.template.service;

import com.example.template.annotation.MainTestTemplate;
import com.example.template.entity.TestEntity;
import com.example.template.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@MainTestTemplate
@EnableCaching
class TestServiceTest {

    @SpyBean
    private TestRepository testRepository;

    @Autowired
    private TestService testService;

    @Test
    void save() {
    }

    @Test
    void findById() {
        var expectedEntity = new TestEntity(UUID.randomUUID(), "Bill");
        testService.save(expectedEntity);
      /*  when(testRepository.findById(any(UUID.class)))
                .thenReturn(Optional.of(expectedEntity));*/

        var actualEntity1 = testService.findById(expectedEntity.getId());
        var actualEntity2 = testService.findById(expectedEntity.getId());
        var actualEntity3 = testService.findById(expectedEntity.getId());
        var actualEntity4 = testService.findById(expectedEntity.getId());

        assertEquals(expectedEntity, actualEntity1);
        verify(testRepository, times(0)).findById(any(UUID.class));
    }
}
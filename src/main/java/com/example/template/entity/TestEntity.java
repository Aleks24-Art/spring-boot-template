package com.example.template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "DAT_TEST_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {

    @Id
    private UUID id;

    private String username;
}

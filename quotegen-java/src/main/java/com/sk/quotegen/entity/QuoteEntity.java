package com.sk.quotegen.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "quote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qid")
    private int qid;

    @Column(name = "quote")
    private String quote;

    @Column(name = "author")
    private String author;

    @Column(name = "used_at")
    private Timestamp usedAt;

    @Column(name = "category")
    private String category;

}

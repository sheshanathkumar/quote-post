package com.sk.quotegen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuoteModel {

    private String name;

    private String username;

    private String image;

    private String quote;

    private String author;

    private String createdAt;

    private String category;

    private String lastUsed;


}

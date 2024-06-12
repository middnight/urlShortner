package com.url.shortner.url_shortner.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@Builder
@Data
@Document(indexName = "urls")
public class URLRecord {
  @Id
  @Field(type = FieldType.Text)
  private String url;

  @Field(type = FieldType.Text)
  private String shortUrl;
}

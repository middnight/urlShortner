package com.url.shortner.url_shortner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @Field(type = FieldType.Text)
  private String url;

  @Id
  @Field(type = FieldType.Text)
  private String shortUrl;

  @JsonIgnore
  @Field(type = FieldType.Long)
  private Long createdOn;
}

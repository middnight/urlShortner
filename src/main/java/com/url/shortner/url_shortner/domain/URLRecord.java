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
  @Field(type = FieldType.Text)
  private String url;
  /*
   * I'm not adding the prefix url of domain into database record, it gives me the flexibility to move entire data set to new domain
   * without doing any data migration
   * */
  @Id
  @Field(type = FieldType.Text)
  private String shortUrl;

  // @JsonIgnore
  @Field(type = FieldType.Long)
  private Long createdOn;

  @Field(type = FieldType.Long)
  private Long lastUpdateOn;
}

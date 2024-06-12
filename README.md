This is a classic url shortner written in spring boot 3x and java 17, It'll serve below use cases
1. Creating a short url for given url
2. Retrieving original url from short url
3. Redirecting to original url from short url

Tech stack used is : Spring Boot 3x + java 17 + Elastic as database 

Reason for choosing elastic are
1. Since we are storning string and searching based on string no need to overcomplicate this and thus use of the fastest text seach database

TO Run Elastic in docker for non-prod enviornments you can use below commands

1. docker network create elastic
2. docker pull docker.elastic.co/elasticsearch/elasticsearch:8.14.0
3. docker run -d --name elastic --net elastic -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:8.14.0

To Check data in ES you can either use kibana or any browser extension such as elasticVue

There are two types of generation strategies supported with application
1. uuid : generates uuid based short url, chances of collision with existing short urls are much lesser with this
2. text : generates text based short urls, minimum and maximum length for generation can be controlled from application properties




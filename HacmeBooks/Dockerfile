FROM maven:3-jdk-8-alpine

EXPOSE 8989 8989

RUN apk update && \
  apk add git && \
  rm -rf /var/cache/apk/*

COPY hsqldb-2.4.1.jar hsqldb-2.4.1.jar

RUN git clone https://github.com/cotonne/secure-by-design.git && \
  cp /hsqldb-2.4.1.jar /secure-by-design/HacmeBooks/hsqldb-2.4.1.jar && \
  cd /secure-by-design/HacmeBooks/ && \
  mvn -DskipTests -Dmaven.test.skip install

WORKDIR /secure-by-design/HacmeBooks/
ENTRYPOINT  ./run.sh
  

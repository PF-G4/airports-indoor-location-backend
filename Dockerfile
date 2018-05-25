FROM java:openjdk-8-alpine

MAINTAINER PF-G4 Team "facundo.welschen@gmail.com"


ENV APP_PATH=/opt/backend
ENV MAVEN_VERSION="3.2.5" \
    M2_HOME=/usr/lib/mvn

RUN mkdir -p /opt/backend
COPY . /opt/backend
WORKDIR /opt/backend

RUN apk add --update wget && \
  cd /tmp && \
  wget "http://ftp.unicamp.br/pub/apache/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz" && \
  tar -zxvf "apache-maven-$MAVEN_VERSION-bin.tar.gz" && \
  mv "apache-maven-$MAVEN_VERSION" "$M2_HOME" && \
  ln -s "$M2_HOME/bin/mvn" /usr/bin/mvn && \
  apk del wget && \
  rm /tmp/* /var/cache/apk/*

RUN  mvn package

#VOLUME /opt/backend/logs

#ARG hash=dev
#ARG branch=dev

#LABEL backend.commit_hash=$hash
#LABEL backend.branch=$branch

ENTRYPOINT ["sh", "/opt/backend/entrypoint.sh"]
CMD ["start"]

EXPOSE 9090

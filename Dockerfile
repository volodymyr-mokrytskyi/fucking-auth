FROM centos:7

RUN yum update -y && \
yum install -y wget && \
yum install -y java-1.8.0-openjdk && \
yum install -y net-tools

EXPOSE 8070

ENTRYPOINT ["/usr/bin/java", "-jar", "-XshowSettings:properties", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9010","/usr/share/sicap/auth.jar"]
RUN mkdir -p /usr/share/sicap



ADD target/*.jar /usr/share/sicap/auth.jar


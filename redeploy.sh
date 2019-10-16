#!/usr/bin/env bash

docker-compose down -v
docker rmi f-auth
mvn clean package
docker build -t f-auth:latest .
docker-compose up -d

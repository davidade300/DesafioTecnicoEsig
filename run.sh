#!/usr/bin/zsh
mvn clean package -DskipTests
docker compose up -d
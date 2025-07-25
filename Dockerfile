FROM gradle:8.5.0-jdk17 AS builder
WORKDIR /app

COPY . .

RUN gradle clean test --no-daemon

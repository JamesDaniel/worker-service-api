#!/bin/bash
bash mvnw package && docker-compose up --build --force-recreate -d

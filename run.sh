#!/bin/bash
docker build -t jmcgarr/blobapi:latest .
docker run -p 8080:8080 jmcgarr/blobapi

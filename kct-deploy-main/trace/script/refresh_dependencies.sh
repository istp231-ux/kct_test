#!/bin/sh

# refresh architecture dependencies
# https://hub.docker.com/r/jaegertracing/spark-dependencies
docker run --env STORAGE=elasticsearch --env ES_NODES=http://trace-storage:9200 --env ES_NODES_WAN_ONLY=true --env ES_CLIENT_NODE_ONLY=false --net=im-net jaegertracing/spark-dependencies:latest

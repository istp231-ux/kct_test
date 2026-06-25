#!/bin/sh

# remove 14 days old
docker run -it --rm --network=im-net -e ROLLOVER=true jaegertracing/jaeger-es-index-cleaner:latest 14 http://trace-storage:9200

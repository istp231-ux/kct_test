#!/bin/sh

curl -X PUT --data @alloy-service.json http://localhost:21671/v1/agent/service/register

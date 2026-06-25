#!/bin/sh

# Delete Old Series data
# https://prometheus.io/docs/prometheus/latest/querying/api/#delete-series


HOST=localhost
PORT=21520

STORED_DATE=60    # stored 60 days
TARGET_DATE=

if [[ "$OSTYPE" == "linux-gnu"* ]]; then
  # Linux
  TARGET_DATE=`date -u -d '${STORED_DATE} day ago' +"%Y-%m-%dT%H:%M:%SZ"`
elif [[ "$OSTYPE" == "darwin"* ]]; then
  # Mac OSX (macos 에서 time zone offset 을 찾기 힘들어서 UTC 기준으로 formatting 함)
  TARGET_DATE=`date -uv-${STORED_DATE}d +"%Y-%m-%dT%H:%M:%SZ"`
else
  >&2 echo "unknown os type: $OSTYPE"
 exit 1
fi

echo "delete prometheus time series data : before ${TARGET_DATE}"

curl -X POST -g 'http://'"${HOST}:${PORT}"'/api/v1/admin/tsdb/delete_series?match[]={__name__=~".+"}&end='"${TARGET_DATE}"
curl -X POST -g 'http://'"${HOST}:${PORT}"'/api/v1/admin/tsdb/clean_tombstones'

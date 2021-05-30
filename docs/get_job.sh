#!/bin/bash
export TOKEN=`curl --user app:bfbd9f62-02ce-4638-a370-80d45514bd0a localhost:8080/auth/realms/one/protocol/openid-connect/token -dgrant_type=password -dusername=james -dpassword=james | jq -r .access_token`

AUTH_HEADER="Authorization: Bearer $(echo $TOKEN)"

JOB_ID=$1

curl --request GET \
  --url http://localhost:8081/api/v1/job/$(echo $JOB_ID)/status \
  --header "$(echo $AUTH_HEADER)" \
  --header 'Content-Type: application/json'

echo

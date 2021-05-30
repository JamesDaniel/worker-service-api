#!/bin/bash
export TOKEN=`curl --user app:bfbd9f62-02ce-4638-a370-80d45514bd0a localhost:8080/auth/realms/one/protocol/openid-connect/token -dgrant_type=password -dusername=james -dpassword=james | jq -r .access_token`

AUTH_HEADER="Authorization: Bearer $(echo $TOKEN)"

# bash post_job.sh /home/jamesmcgarr/Pictures/test_image.png
FILE_PATH=$1

curl --request POST \
  --url http://localhost:8081/api/v1/job \
  --header "$(echo $AUTH_HEADER)" \
  --header 'Content-Type: multipart/form-data' \
  --form "payload=@$(echo $FILE_PATH)"

echo

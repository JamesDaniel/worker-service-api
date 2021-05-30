# Job API
A POC application to submit and retrieve images

## References

 - Docker
   - https://docs.docker.com/develop/develop-images/multistage-build/
   - https://docs.docker.com/get-started/02_our_app/
   - https://hub.docker.com/r/adoptopenjdk/maven-openjdk11/tags?page=1&ordering=last_updated
   - https://spring.io/guides/gs/spring-boot-docker/
   - https://chtc.cs.wisc.edu/docker-test.shtml
   - https://github.com/JamesDaniel/spring-boot-docker/blob/master/Dockerfile
 - Spring
   - https://www.baeldung.com/spring-resttemplate-post-json
   - https://auth0.com/blog/spring-boot-authorization-tutorial-secure-an-api-java/
   - https://app.pluralsight.com/library/courses/securing-spring-data-rest-apis/table-of-contents
   - https://github.com/jzheaux/resolutions
   
# How To

 - Start keycloak `cd etc && docker-compose up -d`
 - Note keycloak takes about 3 minutes to start. 
 - The job service will not start correctly unless keycloak is running.
 - The keycloak admin URL is `http://localhost:8080/admin`
 - Once keycloak has started the service can be started.
 - From project base directory start the job service `bash run.sh`
 - The requests must be authenticated. There are helper scripts to do this.
 - To post run this script with an absolute path.
 - E.g. `bash docs/post_job.sh /home/jamesmcgarr/Pictures/test_image.png`
 - To get a job by ID there is a helper script.
 - E.g. `bash docs/get_job.sh 16`

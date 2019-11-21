# tobyworks

Spring boot application ... 

Step 1 build project: 
mvn -e clean install


Step 2 RUN as jar : 
java -jar githubsearch-0.0.1-SNAPSHOT.jar



Command Line script

Step 1 Create Script file 'searchgit.sh' with below content


curl -H 'Accept: application/json' -H "Authorization: Bearer SAMPLETOKEN" http://localhost:8080/github/search?text=$1&pageno=$1&limit=$3


Step 2 run script ( example ./searchgit.sh <Text> <pageNo> <lineLimitforPage>


 
 

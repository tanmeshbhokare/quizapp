# quizapp
End to End CICD pipeline for simple WebApp

![image](https://user-images.githubusercontent.com/42235943/180472508-fae889f1-cf66-48bc-9cf9-9f6be5e5e523.png)

# Pre-requisites
 - Install openjdk-8
   `sudo apt install openjdk-8-jdk`
 - Install Maven
   `sudo apt install maven`
 
# Hot to build this project
 - `cd` to quizapp directory where `pom.xml` is located
 - `mvn clean install`
 - `docker build -t quizapp .`
 - `docker container run -it -d --name quizapp -p 13000:8080 quizapp`
 - open your web browser and visit `localhost:13000`


FROM openjdk:17-jdk

COPY out/artifacts/TalanaKombat_jar/TalanaKombat.jar /home/TalanaKombat.jar

CMD ["java","-jar","/home/TalanaKombat.jar"]
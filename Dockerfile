FROM openjdk:17
ADD target/servicebooking-aws-new.jar .
CMD ["java","-jar","servicebooking-aws-new.jar"]


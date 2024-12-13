## Important Notice

_This project was developed as part of a challenge proposed by the instructors for those who completed the course at Alura. While I created the code independently, it may resemble the work of other students who participated in the same challenge._

**The project is not intended for real-world application; it is solely to demonstrate my programming knowledge to recruiters. In this project, various programming techniques were showcased.**

## Applied Techniques

•  Applied the Strategy design pattern.

•  Reduced coupling by injecting the HttpClient and others classes into the constructors of the classes.

•  Utilized the streams feature introduced in Java 8.

•  Used Enums with constructors and their own methods.

•  Threw appropriate exceptions for the context and handled them.

•  Modeled the application using Java record classes.

• Created private attributes in the classes, and when they needed to be accessed or set, I created getter and setter methods for them, thus ensuring better encapsulation.

• Implemented deserialization and serialization using the ObjectMapper class.

• Applied sanitization to user inputs, ensuring that the application receives the expected type without leading or trailing whitespace and other string malformations.

## Technologies I used to build this project:
[![](https://img.icons8.com/fluency/48/java-coffee-cup-logo.png)](https://www.java.com/en/)[![](https://img.icons8.com/ios/50/maven-ios.png)](https://maven.apache.org/)[![](https://img.icons8.com/fluency/48/intellij-idea.png)](https://www.jetbrains.com/pt-br/idea/)[![](https://img.icons8.com/glyph-neue/50/github.png)](https://github.com/)


## Before running the application:

• Install JRE or JDK

• Install Maven
```
git clone https://github.com/M41k0n-Mk/consulta-tabela-fipe.git

cd consulta-tabela-fipe

mvn clean package

java -jar .\target\consulta-tabela-fipe-1.0-SNAPSHOT.jar
```
SPA GWT SPRING BOOT Test APP
============================

Используется
GWT
Spring boot
Hibernate
Postgres
Maven

Запуск на Glassfish
В pom.xml
раскоментировать '<exclusions>'

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
<!--			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>-->
		</dependency>
        <dependency>
Glassfish использует конфиг
src\main\resources\application.properties


Запуск на Tomcat 9 (Tomcat 10 не поддерживает жанный проект)
В pom.xml
в том же разделе (см. выше)
закоментировать '<exclusions>'
Tomcat использует конфиг
src\main\java\com\my\mywebapp\server\ServerApplication.java
'@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})'
(автоконфигурация Spring)


Сборка проекта стандартная
mvn clean package
или
mvn clean install -U
(для обновления зависимостей)

или

запуск в докере
docker-compose build
docker-compose up -d




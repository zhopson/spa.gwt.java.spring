SPA GWT SPRING BOOT Test APP
============================

������������
GWT
Spring boot
Hibernate
Postgres
Maven

������ �� Glassfish
� pom.xml
���������������� '<exclusions>'

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
Glassfish ���������� ������
src\main\resources\application.properties


������ �� Tomcat 9 (Tomcat 10 �� ������������ ������ ������)
� pom.xml
� ��� �� ������� (��. ����)
��������������� '<exclusions>'
Tomcat ���������� ������
src\main\java\com\my\mywebapp\server\ServerApplication.java
'@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})'
(���������������� Spring)


������ ������� �����������
mvn clean package
���
mvn clean install -U
(��� ���������� ������������)

���

������ � ������
docker-compose build
docker-compose up -d




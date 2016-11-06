# DangerManageSystem
<h1>lib</h1>
WEB-INF/lib/antlr-2.7.7.jar
WEB-INF/lib/aopalliance-1.0.jar
WEB-INF/lib/c3p0-0.9.1.2.jar
WEB-INF/lib/commons-fileupload-1.3.1.jar
WEB-INF/lib/commons-logging-1.0.4.jar
WEB-INF/lib/dom4j-1.6.1.jar
WEB-INF/lib/hibernate-commons-annotations-4.0.5.Final.jar
WEB-INF/lib/hibernate-core-4.3.10.Final.jar
WEB-INF/lib/hibernate-ehcache-4.3.10.Final.jar
WEB-INF/lib/hibernate-entitymanager-4.3.10.Final.jar
WEB-INF/lib/hibernate-jpa-2.1-api-1.0.0.Final.jar
WEB-INF/lib/jackson-annotations-2.5.0.jar
WEB-INF/lib/jackson-core-2.5.4.jar
WEB-INF/lib/javassist-3.18.1-GA.jar
WEB-INF/lib/jboss-logging-3.1.3.GA.jar
WEB-INF/lib/jboss-transaction-api_1.2_spec-1.0.0.Final.jar
WEB-INF/lib/jstl-1.2.jar
WEB-INF/lib/junit.jar
WEB-INF/lib/slf4j-api-1.7.7.jar
WEB-INF/lib/spring-aop-4.1.6.RELEASE.jar
WEB-INF/lib/spring-beans-4.1.6.RELEASE.jar
WEB-INF/lib/spring-context-4.1.6.RELEASE.jar
WEB-INF/lib/spring-core-4.1.6.RELEASE.jar
WEB-INF/lib/spring-expression-4.1.6.RELEASE.jar
WEB-INF/lib/spring-jdbc-4.1.6.RELEASE.jar
WEB-INF/lib/spring-orm-4.1.6.RELEASE.jar
WEB-INF/lib/spring-tx-4.1.6.RELEASE.jar
WEB-INF/lib/spring-web-4.1.6.RELEASE.jar
WEB-INF/lib/spring-webmvc-4.1.6.RELEASE.jar


<h1>sql</h1>
CREATE TABLE `danger` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(45) DEFAULT NULL,
  `possiblity` varchar(45) DEFAULT NULL,
  `effect` varchar(45) DEFAULT NULL,
  `threshold` varchar(45) DEFAULT NULL,
  `poster` varchar(45) DEFAULT NULL,
  `tracer` varchar(45) DEFAULT NULL,
  `conditiondescription` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `identity` varchar(45) DEFAULT NULL,
  `pswd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

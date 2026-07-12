# Require4Testing

## Build

```bash
mvn clean package
```

## Deploy with Tomcat

For local testing apache tomcat v 10.1.23 was used.
Deployed on localhost, port 8080.
The app is then accessed on `/require4testing-0.1-SNAPSHOT/index.xhtml`

## Persistence

This app is using a local mysql database called `require4testing` with the tables `Requirements`, `Testcases` and `Requirements_Testcases`.

### Requirements

```
CREATE TABLE `Requirements` (
  `id` int NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `content` text,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
);
```

### Testcases

```mysql
CREATE TABLE `Testcases` (
  `tester` varchar(255) DEFAULT NULL,
  `description` text,
  `testSteps` text,
  `expectedResult` text,
  `lastTestResult` text,
  `testedRequirement_id` int DEFAULT NULL,
  `id` int NOT NULL,
  `nextExecutionDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_testcases_requirement` (`testedRequirement_id`),
  CONSTRAINT `fk_testcases_requirement` FOREIGN KEY (`testedRequirement_id`) REFERENCES `Requirements` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
);
```

### Requirements_Testcases

```
CREATE TABLE `Requirements_Testcases` (
  `requirement_id` int NOT NULL,
  `testcase_id` int NOT NULL,
  PRIMARY KEY (`requirement_id`,`testcase_id`),
  KEY `testcase_id` (`testcase_id`),
  CONSTRAINT `Requirements_Testcases_ibfk_1` FOREIGN KEY (`requirement_id`) REFERENCES `Requirements` (`id`),
  CONSTRAINT `Requirements_Testcases_ibfk_2` FOREIGN KEY (`testcase_id`) REFERENCES `Testcases` (`id`)
);
```
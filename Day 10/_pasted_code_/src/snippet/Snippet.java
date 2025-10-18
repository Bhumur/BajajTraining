spring:
	datasource:
		url: jdbc:mysql://localhost:3306/test
		username: root
		password: root

logging:
  level:
    org.springframework.jdbc.core: DEBUG
    org.springframework.jdbc.datasource: DEBUG
    org.springframework.jdbc.core.StatementCreatorUtils: TRACE
    com.zaxxer.hikari: DEBUG 
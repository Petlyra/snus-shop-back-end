package paley.yuri.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty("liquibase.manual")
@RequiredArgsConstructor
public class LiquibaseConfig {
  private final DataSource dataSource;

  @Bean
  public LiquibaseProperties liquibaseProperties() {
    return new LiquibaseProperties();
  }

  @Bean
  @DependsOn(value = "entityManagerFactory")
  public SpringLiquibase liquibase() {
    LiquibaseProperties liquibaseProperties = liquibaseProperties();
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog(liquibaseProperties.getChangeLog());
    liquibase.setContexts(liquibaseProperties.getContexts());
    liquibase.setDataSource(getDataSource(liquibaseProperties));
    liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
    liquibase.setDropFirst(liquibaseProperties.isDropFirst());
    liquibase.setShouldRun(true);
    liquibase.setLabels(liquibaseProperties.getLabels());
    liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
    return liquibase;
  }

  private DataSource getDataSource(LiquibaseProperties liquibaseProperties) {
    if (liquibaseProperties.getUrl() == null) {
      return this.dataSource;
    }
    return DataSourceBuilder.create()
        .url(liquibaseProperties.getUrl())
        .username(liquibaseProperties.getUser())
        .password(liquibaseProperties.getPassword())
        .build();
  }
}

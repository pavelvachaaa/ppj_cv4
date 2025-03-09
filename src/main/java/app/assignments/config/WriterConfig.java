package app.assignments.config;

import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WriterConfig {

    @Bean(name = "stdoutWriter")
    public StdoutWriter stdoutWriter() {
        return new StdoutWriter();
    }

    @Bean(name = "listWriter", initMethod = "init")
    @Scope("singleton")
    public ListWriter listWriter() {
        return new ListWriter();
    }
}
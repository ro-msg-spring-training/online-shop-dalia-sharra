package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyConfiguration {
    @Value("${strategy}")
    private String strategy;

    @Bean
    public Strategy getStrategy()
    {
        if(strategy.equals("abundant"))
            return new MostAbundantStrategy();
        else
            return new SingleLocationStrategy();
    }
}

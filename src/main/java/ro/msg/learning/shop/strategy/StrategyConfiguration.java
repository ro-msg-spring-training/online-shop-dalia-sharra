package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyConfiguration {
    @Value("${strategy}")
    private StrategyType strategy;

    @Bean
    public Strategy getStrategy()
    {
        if(strategy == StrategyType.SINGLE_STRATEGY)
            return new SingleLocationStrategy();
        else
            return new MostAbundantStrategy();
    }
}

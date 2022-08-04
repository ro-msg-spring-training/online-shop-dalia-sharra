package ro.msg.learning.shop.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;
import ro.msg.learning.shop.strategy.SingleLocationStrategy;
import ro.msg.learning.shop.strategy.Strategy;

@TestConfiguration
@Import({SingleLocationStrategy.class, MostAbundantStrategy.class})
public class LocationStrategyConfiguration {

    @Bean
    //@Primary
    public Strategy singleStrategy()
    {
        return new SingleLocationStrategy();
    }

    @Bean(name = "mostAbundantStrategy")
    public Strategy mostAbundantStrategy()
    {
        return new MostAbundantStrategy();
    }
}

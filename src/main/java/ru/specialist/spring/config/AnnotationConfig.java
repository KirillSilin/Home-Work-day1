package ru.specialist.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.specialist.spring.bean.*;

import java.util.List;

@Configuration
@ComponentScan("ru.specialist.spring.bean")
public class AnnotationConfig {

    @Bean
    public List<RAM> ramList(){
        return List.of(kingstonRam(), sonyRAM(), kingstonRam());
    }

    @Bean
    public List<Storage> storageList(){

        return List.of(seagateStorage(), wdStorage(), seagateStorage());
    }

    @Bean
    @Scope("prototype")
    public RAM kingstonRam(){
        return new KingstonRAM();
    }

    @Bean
    @Scope("prototype")
    public RAM sonyRAM(){
        return new SonyRAM();
    }

//    Screen и Storage
    @Bean
    public Screen dellScreen() { return new DellScreen(); }

    @Bean
    public Screen phillipsScreen() { return new PhillipsScreen(); }

    @Bean
    @Scope("prototype")
    public Storage seagateStorage() { return new SeagateStorage(); }

    @Bean
    @Scope("prototype")
    public Storage wdStorage() { return new WDStorage(); }
}

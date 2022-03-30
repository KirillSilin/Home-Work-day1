package ru.specialist.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.specialist.spring.bean.*;

import java.util.List;

@Configuration
public class JavaConfig {

    @Bean("myComputer")
    public Computer computer(){
        Computer computer = new Computer();
        computer.setCpu(intelCpu());
        computer.setRamList(List.of(sonyRAM(), kingstonRam(), sonyRAM()));
        computer.setScreen(dellScreen());
        computer.setStorageList(List.of(seagateStorage(), seagateStorage(),wdStorage(), wdStorage()));
        return computer;
    }

    @Bean
    public CPU amdCpu(){
        return new AmdCPU();
    }

    @Bean
    public CPU intelCpu(){
        return new IntelCPU();
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

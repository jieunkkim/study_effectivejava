package me.study.effetivejava.item05.springspellchecker;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Config.class)
public class Config {
}

package com.example.demo;

import com.example.demo.builder.Computer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Computer computer = new Computer.Builder("intel-23md", "samsung-5200mhz")
                .includegpu("nvidia-rtx4700")
                .includeStorage(1200)
                .isBluetoothEnabled(false)
                .build();

        Computer computer2 = new Computer.Builder("intel-23md", "samsung-5200mhz")
                .includegpu("nvidia-rtx4700")
                .includeStorage(120)
                .isBluetoothEnabled(false)
                .build();

        System.out.println(computer);
        System.out.println(computer2);
    }


}

package com.example.demo.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Computer {

    // required parameters
    private final String cpu;
    private final String ram;

    // optional parameters
    private final int storage;
    private final String gpu;
    private final boolean isBluetoothEnabled;

    private static final Logger log = LoggerFactory.getLogger(Computer.class);

    public static class Builder {
        // required parameters

        private String cpu;
        private String ram;

        // optional parameters
        private int storage = 256;
        private String gpu = "Integrated";
        private boolean isBluetoothEnabled = false;


        public Builder(String cpu, String ram) {
            super();
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder includeStorage(int storage) {
            this.storage = storage;
            if (storage < 200) {
                log.warn("kalitesiz musteri tespiti : {}",storage);
            }
            return this;
        }

        public Builder includegpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder isBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }

    private Computer(Builder builder) {
        cpu = builder.cpu;
        ram = builder.ram;
        gpu = builder.gpu;
        storage = builder.storage;
        isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", ram=" + ram + ", storage=" + storage + ", gpu=" + gpu
                + ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
    }
}

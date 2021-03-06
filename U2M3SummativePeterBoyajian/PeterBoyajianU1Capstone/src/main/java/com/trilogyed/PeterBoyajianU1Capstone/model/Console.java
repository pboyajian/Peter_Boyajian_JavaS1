package com.trilogyed.PeterBoyajianU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class Console extends Item{
    @NotEmpty(message = "Console model cannot be empty.")
    private String model;
    @NotEmpty(message = "Console manufacturer cannot be empty.")
    private String manufacturer;
    @NotEmpty(message = "Console memoryAmount cannot be empty.")
    private String memoryAmount;
    @NotEmpty(message = "Console processor cannot be empty.")
    private String processor;

    public Console() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return model.equals(console.model) &&
                manufacturer.equals(console.manufacturer) &&
                Objects.equals(memoryAmount, console.memoryAmount) &&
                Objects.equals(processor, console.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufacturer, memoryAmount, processor);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

}

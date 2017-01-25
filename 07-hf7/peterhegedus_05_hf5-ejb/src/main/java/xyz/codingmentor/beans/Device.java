package xyz.codingmentor.beans;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.constraint.DeviceEntityManufacturerAnnotation;
import xyz.codingmentor.constraint.Validable;

/**
 *
 * @author Péter
 */
@DeviceEntityManufacturerAnnotation
@Validable
public class Device {

    @NotNull
    @Size(min = 36, max = 36)
    private String id;
    @NotNull
    private Manufacturer manufacturer;
    @NotNull
    @Size(min = 3)
    private String type;
    @NotNull
    @Min(1)
    private Integer price;
    @NotNull
    private Color color;
    @NotNull
    @Min(0)
    private Integer count;

    public Device() {
        //Empty constructor needed for JSON read
    }

    public Device(Manufacturer manufacturer, String type, Integer price, Color color, Integer count) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.color = color;
        this.count = count;
    }

    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public Color getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.manufacturer);
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = 83 * hash + Objects.hashCode(this.price);
        hash = 83 * hash + Objects.hashCode(this.color);
        hash = 83 * hash + Objects.hashCode(this.count);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Device other = (Device) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.manufacturer != other.manufacturer) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        return true;
    }

}

package xyz.codingmentor.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.constraint.DeviceEntityManufacturerAnnotation;

/**
 *
 * @author Péter
 */
@DeviceEntityManufacturerAnnotation
public class Device {

    @NotNull
    @Size(min=36, max=36)
    private String id;
    @NotNull
    private Manufacturer manufacturer;
    @NotNull
    @Size(min=3)
    private String type;
    @NotNull
    @Min(1)
    private Integer price;
    @NotNull
    private Color color;
    @NotNull
    @Min(0)
    private Integer count;
    
    public Device(){
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

    @JsonIgnore
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
    
    
    
    public void setId(String id){
        this.id=id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
}

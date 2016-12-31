package xyz.codingmentor.beans;

import java.util.UUID;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.constraint.DeviceEntityAnnotation;

/**
 *
 * @author Péter
 */
@DeviceEntityAnnotation
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

    public Device(Manufacturer manufacturer, String type, Integer price, Color color, Integer count) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.color = color;
        this.count = count;
        this.id=UUID.randomUUID().toString();
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
    
    public void setId(String id){
        this.id=id;
    }
}

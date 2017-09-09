package com.flpkrt.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides(value = {@AttributeOverride(name = "name",column = @Column(name="dimunit")),
        @AttributeOverride(name = "symbol",column = @Column(name="dimunitsym"))})
public class Measurement extends MetricSystem{

    private long length;
    private long breadth ;
    private long height ;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getBreadth() {
        return breadth;
    }

    public void setBreadth(long breadth) {
        this.breadth = breadth;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "length=" + length +
                ", breadth=" + breadth +
                ", height=" + height +
                '}';
    }
}

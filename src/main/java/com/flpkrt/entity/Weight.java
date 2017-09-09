package com.flpkrt.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides(value = {@AttributeOverride(name = "name",column = @Column(name="weightunit")),
                    @AttributeOverride(name = "symbol",column = @Column(name="weightunitsym"))})
public class Weight extends  MetricSystem{
    private long  weight;

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weight=" + weight +
                '}';
    }
}

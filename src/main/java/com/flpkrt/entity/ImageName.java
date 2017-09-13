package com.flpkrt.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ImageName {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String ext;
}

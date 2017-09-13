package com.flpkrt.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ImageName {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String ext;

    public String getName() {
        return name;
    }

    public ImageName setName(String name) {
        this.name = name;
        return this;
    }

    public String getExt() {
        return ext;
    }

    public ImageName setExt(String ext) {
        this.ext = ext;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageName imageName = (ImageName) o;

        if (!name.equals(imageName.name)) return false;
        return ext.equals(imageName.ext);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + ext.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ImageName{" +
                "name='" + name + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}

package com.flpkrt.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Image {
    private String imagename;
    private int length;
    private int bredth;


    public String getImagename() {
        return imagename;
    }

    public Image setImagename(String imagename) {
        this.imagename = imagename;
        return this;
    }

    public int getLength() {
        return length;
    }

    public Image setLength(int length) {
        this.length = length;
        return this;
    }

    public int getBredth() {
        return bredth;
    }

    public Image setBredth(int bredth) {
        this.bredth = bredth;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (length != image.length) return false;
        if (bredth != image.bredth) return false;
        return imagename.equals(image.imagename);
    }

    @Override
    public int hashCode() {
        int result = imagename.hashCode();
        result = 31 * result + length;
        result = 31 * result + bredth;
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imagen='" + imagename + '\'' +
                ", length=" + length +
                ", bredth=" + bredth +
                '}';
    }
}

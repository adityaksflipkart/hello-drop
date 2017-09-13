package com.flpkrt.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Image {

    private String filename;
    private String imagen;
    private int length;
    private int bredth;

    public String getFilename() {
        return filename;
    }

    public Image setFilename(String filename) {
        this.filename = filename;
        return this;
    }

    public String getImagen() {
        return imagen;
    }

    public Image setImagen(String imagename) {
        this.imagen = imagename;
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
        if (!filename.equals(image.filename)) return false;
        return imagen.equals(image.imagen);
    }

    @Override
    public int hashCode() {
        int result = filename.hashCode();
        result = 31 * result + imagen.hashCode();
        result = 31 * result + length;
        result = 31 * result + bredth;
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "filename='" + filename + '\'' +
                ", imagen='" + imagen + '\'' +
                ", length=" + length +
                ", bredth=" + bredth +
                '}';
    }
}

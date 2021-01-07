package com.computerShop.model;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idImages;
    private String pathImage1;
    private String pathImage2;
    private String pathImage3;
    private String pathImage4;
    private String pathImage5;
    private String pathImage6;

    public Images(Long idImages, String pathImage1, String pathImage2, String pathImage3, String pathImage4, String pathImage5, String pathImage6) {
        this.idImages = idImages;
        this.pathImage1 = pathImage1;
        this.pathImage2 = pathImage2;
        this.pathImage3 = pathImage3;
        this.pathImage4 = pathImage4;
        this.pathImage5 = pathImage5;
        this.pathImage6 = pathImage6;
    }

    public Images() {
    }

    public Long getIdImages() {
        return idImages;
    }

    public void setIdImages(Long idImages) {
        this.idImages = idImages;
    }

    public String getPathImage1() {
        return pathImage1;
    }

    public void setPathImage1(String pathImage1) {
        this.pathImage1 = pathImage1;
    }

    public String getPathImage2() {
        return pathImage2;
    }

    public void setPathImage2(String pathImage2) {
        this.pathImage2 = pathImage2;
    }

    public String getPathImage3() {
        return pathImage3;
    }

    public void setPathImage3(String pathImage3) {
        this.pathImage3 = pathImage3;
    }

    public String getPathImage4() {
        return pathImage4;
    }

    public void setPathImage4(String pathImage4) {
        this.pathImage4 = pathImage4;
    }

    public String getPathImage5() {
        return pathImage5;
    }

    public void setPathImage5(String pathImage5) {
        this.pathImage5 = pathImage5;
    }

    public String getPathImage6() {
        return pathImage6;
    }

    public void setPathImage6(String pathImage6) {
        this.pathImage6 = pathImage6;
    }
}

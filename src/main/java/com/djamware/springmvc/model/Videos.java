package com.djamware.springmvc.model;

//import javax.persistence.Entity;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Videos {

    @Id
    
    private BigInteger id;

    private String VTitle;

    private String VDesc;

    
    public String url;

    private String prodImage;

    

    public Videos() {
    }

    public Videos(String VTitle, String VDesc, String prodImage,String url) {
        this.VTitle = VTitle;
        this.VDesc = VDesc;
        this.prodImage = prodImage;
        this.url=url;
        
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getVTitle() {
        return VTitle;
    }

    public void setVTitle(String VTitle) {
        this.VTitle = VTitle;
    }

    public String getVDesc() {
        return VDesc;
    }

    public void setVDesc(String VDesc) {
        this.VDesc = VDesc;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }
    public String getURL() {
        return this.url;
    }
    public void setURL(String url) {
        this.url = url;
    }

}
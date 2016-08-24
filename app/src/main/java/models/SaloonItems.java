package models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by charl on 20/08/2016.
 */
public class SaloonItems {

    private String saloonName;
    private String saloonService;
    private String saloonLocation;
    private String saloonId;
    private String saloonDescription;
    private String saloonTel;
    private String saloonEmail;
    private String saloonLat;
    private String saloonLon;

    private String saloonLogo;
    private String SaloonImage;
    // private Drawable mBitamap;


//    public SaloonItems(String saloonName, String saloonService, String saloonLocation){
//        this.saloonName = saloonName;
//        this.saloonService = saloonService;
//        this.saloonLocation = saloonLocation;
//        //this.mBitamap = mBitamap;
//    }

    public String getSaloonService() {
        return saloonService;
    }

    public String getSaloonName() {
        return saloonName;
    }

    public String getSaloonLocation() {
        return saloonLocation;
    }

    public String getSaloonId() {
        return saloonId;
    }

    public void setSaloonId(String saloonId) {
        this.saloonId = saloonId;
    }

    public String getSaloonImage() {
        return SaloonImage;
    }

    public void setSaloonImage(String saloonImage) {
        SaloonImage = saloonImage;
    }

    public void setSaloonName(String saloonName) {
        this.saloonName = saloonName;
    }

    public void setSaloonService(String saloonService) {
        this.saloonService = saloonService;
    }

    public void setSaloonLocation(String saloonLocation) {
        this.saloonLocation = saloonLocation;
    }

    public String getSaloonLogo() {
        return saloonLogo;
    }

    public void setSaloonLogo(String saloonLogo) {
        this.saloonLogo = saloonLogo;
    }

    public String getSaloonDescription() {
        return saloonDescription;
    }

    public void setSaloonDescription(String saloonDescription) {
        this.saloonDescription = saloonDescription;
    }

    public String getSaloonTel() {
        return saloonTel;
    }

    public void setSaloonTel(String saloonTel) {
        this.saloonTel = saloonTel;
    }

    public String getSaloonEmail() {
        return saloonEmail;
    }

    public void setSaloonEmail(String saloonEmail) {
        this.saloonEmail = saloonEmail;
    }

    public String getSaloonLat() {
        return saloonLat;
    }

    public void setSaloonLat(String saloonLat) {
        this.saloonLat = saloonLat;
    }

    public String getSaloonLon() {
        return saloonLon;
    }

    public void setSaloonLon(String saloonLon) {
        this.saloonLon = saloonLon;
    }

}

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

//    public Drawable getmBitamap() {
//        return mBitamap;
//    }
//
//    public void setmBitamap(Drawable mBitamap) {
//        this.mBitamap = mBitamap;
//    }

}

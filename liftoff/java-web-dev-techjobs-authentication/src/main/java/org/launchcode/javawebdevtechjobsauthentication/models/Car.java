package org.launchcode.javawebdevtechjobsauthentication.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String carModel;

    @NotNull
    @Size(min=3, max=20)
    private String carMake;

    @NotNull
    @Range(min=4, max=99999)
    private int carYear;

    @NotNull
    @Size(min=17, max=17)
    private String vin;

    @NotNull
    @Range(min=1, max=99999999)
    private int mileage;

    @NotNull
    @Range(min=1, max=9999999)
    private int daysUntilExpiration; //days until expiration

    @NotNull
    @Size(min=1, max=6)
    private String plate;

    public Car() {
    }

    // Initialize the id and value fields.
    public Car(String aCarModel, int aCarYear, String aVin, int aMileage, int aDaysUntilExpiration, String aPlate, String aCarMake ) {
        super();
        this.carModel = aCarModel;
        this.carMake = aCarMake;
        this.carYear = aCarYear;
        this.vin = aVin;
        this.mileage = aMileage;
        this.daysUntilExpiration = aDaysUntilExpiration;
        this.plate = aPlate;

    }

    // Getters and setters.

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDaysUntilExpiration() {
        return daysUntilExpiration;
    }

    public void setDaysUntilExpiration(int daysUntilExpiration) {
        this.daysUntilExpiration = daysUntilExpiration;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }


    //@Override
   // public String toString() {
    //    return name;
   // }
}

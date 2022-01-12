package org.launchcode.javawebdevtechjobsauthentication.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String driverFirstName;

    @NotNull
    @Size(min=3, max=50)
    private String driverLastName;

    @NotNull
    @Size(min=3, max=50)
    private String carExpMonth;



    @NotNull
    private int carExpYear;

    @NotNull
    @Size(min=3, max=20)
    private String carModel;

    @NotNull
    @Size(min=3, max=20)
    private String carMake;

    @NotNull
    @Range(min=1886, max=2023)
    private int carYear;

    @NotNull
    @Size(min=6, max=17)
    private String vin;

    @NotNull
    @Range(min=1, max=999999)
    private int mileage;

    //@NotNull
    //@Range(min=1, max=9999999)
    //private int daysUntilExpiration; //days until expiration

    @NotNull
    @Size(min=1, max=6)
    private String plate;

    private String combo;

    public Car() {
    }

    // Initialize the id and value fields.
    public Car(String aCarExpMonth, int aCarExpYear,  String aDriverFirstName,String aDriverLastName, String aCarModel,String aCarMake, int aCarYear, String aVin, int aMileage, int aDaysUntilExpiration, String aPlate, String aCombo ) {
        super();
        this.driverFirstName = aDriverFirstName;
        this.driverLastName = aDriverLastName;
        this.carExpMonth = aCarExpMonth;
        this.carExpYear = aCarExpYear;
        this.carModel = aCarModel;
        this.carMake = aCarMake;
        this.carYear = aCarYear;
        this.vin = aVin;
        this.mileage = aMileage;
        //this.daysUntilExpiration = aDaysUntilExpiration;
        this.plate = aPlate;
        this.combo = aCombo;
        this.combo = aDriverFirstName + aDriverLastName+ aCarMake + aCarModel  + aCarYear + aVin + aPlate;


    }

    // Getters and setters.


    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

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

    public String getCarExpMonth() {
        return carExpMonth;
    }

    public void setCarExpMonth(String carExpMonth) {
        this.carExpMonth = carExpMonth;
    }



    public int getCarExpYear() {
        return carExpYear;
    }

    public void setCarExpYear(int carExpYear) {
        this.carExpYear = carExpYear;
    }



    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }
// @Override
   // public String toString() {
    //    return name;
    //}

}

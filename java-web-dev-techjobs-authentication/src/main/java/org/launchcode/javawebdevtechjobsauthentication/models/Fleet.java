package org.launchcode.javawebdevtechjobsauthentication.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Fleet extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String fleetName; //name of the fleet being created by the user

    @NotNull
    @Size(min=3, max=50)
    private String fleetCreatedBy; //This is to be the current logged-in user

    @NotNull
    @Size(min=3, max=50)
    private String fleetDateCreated; //this is to be the current date

//cars in fleet

    @Size(min=3, max=50)
    private String car1;

    @Size(min=3, max=50)
    private String car2;

    @Size(min=3, max=50)
    private String car3;

    @Size(min=3, max=50)
    private String car4;



    public Fleet() {
    }

    // Initialize the id and value fields.
    public Fleet(String aCar1,String aCar2,String aCar3,String aCar4
                 ,String aFleetName, String aFleetCreatedBy, String aFleetDateCreated ) {
        super();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        this.fleetDateCreated = timeStamp;
        this.fleetCreatedBy = "*USERNAME*";
        this.fleetName = aFleetName;
        this.car1 = aCar1;
        this.car2 = aCar2;
        this.car3 = aCar3;
        this.car4 = aCar4;





    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public String getFleetCreatedBy() {
        return fleetCreatedBy;
    }

    public void setFleetCreatedBy(String fleetCreatedBy) {
        this.fleetCreatedBy = fleetCreatedBy;
    }

    public String getFleetDateCreated() {
        return fleetDateCreated;
    }

    public void setFleetDateCreated(String fleetDateCreated) {
        this.fleetDateCreated = fleetDateCreated;
    }

    public String getCar1() {
        return car1;
    }

    public void setCar1(String car1) {
        this.car1 = car1;
    }

    public String getCar2() {
        return car2;
    }

    public void setCar2(String car2) {
        this.car2 = car2;
    }

    public String getCar3() {
        return car3;
    }

    public void setCar3(String car3) {
        this.car3 = car3;
    }

    public String getCar4() {
        return car4;
    }

    public void setCar4(String car4) {
        this.car4 = car4;
    }






// Getters and setters.



// @Override
   // public String toString() {
    //    return name;
    //}

}

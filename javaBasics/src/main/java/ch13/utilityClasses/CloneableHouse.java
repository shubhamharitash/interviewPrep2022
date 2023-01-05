package ch13.utilityClasses;

import java.util.Date;

public class CloneableHouse implements Cloneable{
    private String houseName;
    private Date date;// for primitive type its reference is copied so that needs to be handled in clone

    public CloneableHouse(String houseName) {
        this.houseName = houseName;
        this.date = new Date();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public CloneableHouse clone() {
        try {
            CloneableHouse house = (CloneableHouse) super.clone();
            house.date = (Date) (date.clone());
            return house;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "CloneableHouse{" +
                "houseName='" + houseName + '\'' +
                '}';
    }
}

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * This is POJO class corresponding to server response (JSON).
 */
package com.karcompany.productsearch.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Seller implements Parcelable
{

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("power_seller_status")
    @Expose
    private String powerSellerStatus;
    @SerializedName("car_dealer")
    @Expose
    private boolean carDealer;
    @SerializedName("real_estate_agency")
    @Expose
    private boolean realEstateAgency;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    public final static Creator<Seller> CREATOR = new Creator<Seller>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Seller createFromParcel(Parcel in) {
            Seller instance = new Seller();
            instance.id = ((long) in.readValue((long.class.getClassLoader())));
            instance.powerSellerStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.carDealer = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.realEstateAgency = ((boolean) in.readValue((boolean.class.getClassLoader())));
            in.readList(instance.tags, (Object.class.getClassLoader()));
            return instance;
        }

        public Seller[] newArray(int size) {
            return (new Seller[size]);
        }

    }
    ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPowerSellerStatus() {
        return powerSellerStatus;
    }

    public void setPowerSellerStatus(String powerSellerStatus) {
        this.powerSellerStatus = powerSellerStatus;
    }

    public boolean isCarDealer() {
        return carDealer;
    }

    public void setCarDealer(boolean carDealer) {
        this.carDealer = carDealer;
    }

    public boolean isRealEstateAgency() {
        return realEstateAgency;
    }

    public void setRealEstateAgency(boolean realEstateAgency) {
        this.realEstateAgency = realEstateAgency;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(powerSellerStatus).append(carDealer).append(realEstateAgency).append(tags).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Seller) == false) {
            return false;
        }
        Seller rhs = ((Seller) other);
        return new EqualsBuilder().append(id, rhs.id).append(powerSellerStatus, rhs.powerSellerStatus).append(carDealer, rhs.carDealer).append(realEstateAgency, rhs.realEstateAgency).append(tags, rhs.tags).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(powerSellerStatus);
        dest.writeValue(carDealer);
        dest.writeValue(realEstateAgency);
        dest.writeList(tags);
    }

    public int describeContents() {
        return  0;
    }

}

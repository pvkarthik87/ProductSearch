/**
 * Created by pvkarthik on 2017-01-23.
 *
 * This is POJO class corresponding to server response (JSON).
 */
package com.karcompany.productsearch.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Shipping implements Parcelable
{

    @SerializedName("free_shipping")
    @Expose
    private boolean freeShipping;
    @SerializedName("mode")
    @Expose
    private String mode;
    public final static Creator<Shipping> CREATOR = new Creator<Shipping>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shipping createFromParcel(Parcel in) {
            Shipping instance = new Shipping();
            instance.freeShipping = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.mode = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Shipping[] newArray(int size) {
            return (new Shipping[size]);
        }

    }
    ;

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(freeShipping).append(mode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Shipping) == false) {
            return false;
        }
        Shipping rhs = ((Shipping) other);
        return new EqualsBuilder().append(freeShipping, rhs.freeShipping).append(mode, rhs.mode).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(freeShipping);
        dest.writeValue(mode);
    }

    public int describeContents() {
        return  0;
    }

}

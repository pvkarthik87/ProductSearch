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

public class Installments implements Parcelable
{

    @SerializedName("quantity")
    @Expose
    private long quantity;
    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    public final static Creator<Installments> CREATOR = new Creator<Installments>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Installments createFromParcel(Parcel in) {
            Installments instance = new Installments();
            instance.quantity = ((long) in.readValue((long.class.getClassLoader())));
            instance.amount = ((double) in.readValue((double.class.getClassLoader())));
            instance.currencyId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Installments[] newArray(int size) {
            return (new Installments[size]);
        }

    }
    ;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(quantity).append(amount).append(currencyId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Installments) == false) {
            return false;
        }
        Installments rhs = ((Installments) other);
        return new EqualsBuilder().append(quantity, rhs.quantity).append(amount, rhs.amount).append(currencyId, rhs.currencyId).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(quantity);
        dest.writeValue(amount);
        dest.writeValue(currencyId);
    }

    public int describeContents() {
        return  0;
    }

}

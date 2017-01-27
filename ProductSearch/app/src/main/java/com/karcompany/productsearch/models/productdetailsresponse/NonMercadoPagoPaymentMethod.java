
package com.karcompany.productsearch.models.productdetailsresponse;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NonMercadoPagoPaymentMethod implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    public final static Creator<NonMercadoPagoPaymentMethod> CREATOR = new Creator<NonMercadoPagoPaymentMethod>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NonMercadoPagoPaymentMethod createFromParcel(Parcel in) {
            NonMercadoPagoPaymentMethod instance = new NonMercadoPagoPaymentMethod();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public NonMercadoPagoPaymentMethod[] newArray(int size) {
            return (new NonMercadoPagoPaymentMethod[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(description).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NonMercadoPagoPaymentMethod) == false) {
            return false;
        }
        NonMercadoPagoPaymentMethod rhs = ((NonMercadoPagoPaymentMethod) other);
        return new EqualsBuilder().append(id, rhs.id).append(description, rhs.description).append(type, rhs.type).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(description);
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}

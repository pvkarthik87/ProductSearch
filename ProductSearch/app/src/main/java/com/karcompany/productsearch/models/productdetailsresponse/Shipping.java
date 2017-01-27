
package com.karcompany.productsearch.models.productdetailsresponse;

import java.util.List;
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

    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("local_pick_up")
    @Expose
    private boolean localPickUp;
    @SerializedName("free_shipping")
    @Expose
    private boolean freeShipping;
    @SerializedName("methods")
    @Expose
    private List<Object> methods = null;
    @SerializedName("dimensions")
    @Expose
    private Object dimensions;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    public final static Creator<Shipping> CREATOR = new Creator<Shipping>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shipping createFromParcel(Parcel in) {
            Shipping instance = new Shipping();
            instance.mode = ((String) in.readValue((String.class.getClassLoader())));
            instance.localPickUp = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.freeShipping = ((boolean) in.readValue((boolean.class.getClassLoader())));
            in.readList(instance.methods, (Object.class.getClassLoader()));
            instance.dimensions = ((Object) in.readValue((Object.class.getClassLoader())));
            in.readList(instance.tags, (Object.class.getClassLoader()));
            return instance;
        }

        public Shipping[] newArray(int size) {
            return (new Shipping[size]);
        }

    }
    ;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isLocalPickUp() {
        return localPickUp;
    }

    public void setLocalPickUp(boolean localPickUp) {
        this.localPickUp = localPickUp;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public List<Object> getMethods() {
        return methods;
    }

    public void setMethods(List<Object> methods) {
        this.methods = methods;
    }

    public Object getDimensions() {
        return dimensions;
    }

    public void setDimensions(Object dimensions) {
        this.dimensions = dimensions;
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
        return new HashCodeBuilder().append(mode).append(localPickUp).append(freeShipping).append(methods).append(dimensions).append(tags).toHashCode();
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
        return new EqualsBuilder().append(mode, rhs.mode).append(localPickUp, rhs.localPickUp).append(freeShipping, rhs.freeShipping).append(methods, rhs.methods).append(dimensions, rhs.dimensions).append(tags, rhs.tags).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mode);
        dest.writeValue(localPickUp);
        dest.writeValue(freeShipping);
        dest.writeList(methods);
        dest.writeValue(dimensions);
        dest.writeList(tags);
    }

    public int describeContents() {
        return  0;
    }

}

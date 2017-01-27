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

public class AvailableFilter implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("values")
    @Expose
    private List<Value_> values = null;
    public final static Creator<AvailableFilter> CREATOR = new Creator<AvailableFilter>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AvailableFilter createFromParcel(Parcel in) {
            AvailableFilter instance = new AvailableFilter();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.values, (com.karcompany.productsearch.models.Value_.class.getClassLoader()));
            return instance;
        }

        public AvailableFilter[] newArray(int size) {
            return (new AvailableFilter[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Value_> getValues() {
        return values;
    }

    public void setValues(List<Value_> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(type).append(values).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AvailableFilter) == false) {
            return false;
        }
        AvailableFilter rhs = ((AvailableFilter) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(type, rhs.type).append(values, rhs.values).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeList(values);
    }

    public int describeContents() {
        return  0;
    }

}

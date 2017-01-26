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

public class Paging implements Parcelable
{

    @SerializedName("total")
    @Expose
    private long total;
    @SerializedName("offset")
    @Expose
    private long offset;
    @SerializedName("limit")
    @Expose
    private long limit;
    public final static Creator<Paging> CREATOR = new Creator<Paging>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Paging createFromParcel(Parcel in) {
            Paging instance = new Paging();
            instance.total = ((long) in.readValue((long.class.getClassLoader())));
            instance.offset = ((long) in.readValue((long.class.getClassLoader())));
            instance.limit = ((long) in.readValue((long.class.getClassLoader())));
            return instance;
        }

        public Paging[] newArray(int size) {
            return (new Paging[size]);
        }

    }
    ;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(offset).append(limit).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Paging) == false) {
            return false;
        }
        Paging rhs = ((Paging) other);
        return new EqualsBuilder().append(total, rhs.total).append(offset, rhs.offset).append(limit, rhs.limit).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(offset);
        dest.writeValue(limit);
    }

    public int describeContents() {
        return  0;
    }

}

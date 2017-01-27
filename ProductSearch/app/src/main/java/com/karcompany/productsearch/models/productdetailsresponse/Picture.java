
package com.karcompany.productsearch.models.productdetailsresponse;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Picture implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("secure_url")
    @Expose
    private String secureUrl;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("max_size")
    @Expose
    private String maxSize;
    @SerializedName("quality")
    @Expose
    private String quality;
    public final static Creator<Picture> CREATOR = new Creator<Picture>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Picture createFromParcel(Parcel in) {
            Picture instance = new Picture();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.secureUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.size = ((String) in.readValue((String.class.getClassLoader())));
            instance.maxSize = ((String) in.readValue((String.class.getClassLoader())));
            instance.quality = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Picture[] newArray(int size) {
            return (new Picture[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(url).append(secureUrl).append(size).append(maxSize).append(quality).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Picture) == false) {
            return false;
        }
        Picture rhs = ((Picture) other);
        return new EqualsBuilder().append(id, rhs.id).append(url, rhs.url).append(secureUrl, rhs.secureUrl).append(size, rhs.size).append(maxSize, rhs.maxSize).append(quality, rhs.quality).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(secureUrl);
        dest.writeValue(size);
        dest.writeValue(maxSize);
        dest.writeValue(quality);
    }

    public int describeContents() {
        return  0;
    }

}

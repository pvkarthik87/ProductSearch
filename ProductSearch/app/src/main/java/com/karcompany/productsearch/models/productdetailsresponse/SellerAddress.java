
package com.karcompany.productsearch.models.productdetailsresponse;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SellerAddress implements Parcelable
{

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("address_line")
    @Expose
    private String addressLine;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("search_location")
    @Expose
    private SearchLocation searchLocation;
    public final static Creator<SellerAddress> CREATOR = new Creator<SellerAddress>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SellerAddress createFromParcel(Parcel in) {
            SellerAddress instance = new SellerAddress();
            instance.id = ((long) in.readValue((long.class.getClassLoader())));
            instance.comment = ((String) in.readValue((String.class.getClassLoader())));
            instance.addressLine = ((String) in.readValue((String.class.getClassLoader())));
            instance.zipCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.city = ((City) in.readValue((City.class.getClassLoader())));
            instance.state = ((State) in.readValue((State.class.getClassLoader())));
            instance.country = ((Country) in.readValue((Country.class.getClassLoader())));
            instance.latitude = ((String) in.readValue((String.class.getClassLoader())));
            instance.longitude = ((String) in.readValue((String.class.getClassLoader())));
            instance.searchLocation = ((SearchLocation) in.readValue((SearchLocation.class.getClassLoader())));
            return instance;
        }

        public SellerAddress[] newArray(int size) {
            return (new SellerAddress[size]);
        }

    }
    ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public SearchLocation getSearchLocation() {
        return searchLocation;
    }

    public void setSearchLocation(SearchLocation searchLocation) {
        this.searchLocation = searchLocation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(comment).append(addressLine).append(zipCode).append(city).append(state).append(country).append(latitude).append(longitude).append(searchLocation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SellerAddress) == false) {
            return false;
        }
        SellerAddress rhs = ((SellerAddress) other);
        return new EqualsBuilder().append(id, rhs.id).append(comment, rhs.comment).append(addressLine, rhs.addressLine).append(zipCode, rhs.zipCode).append(city, rhs.city).append(state, rhs.state).append(country, rhs.country).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(searchLocation, rhs.searchLocation).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(comment);
        dest.writeValue(addressLine);
        dest.writeValue(zipCode);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(country);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(searchLocation);
    }

    public int describeContents() {
        return  0;
    }

}

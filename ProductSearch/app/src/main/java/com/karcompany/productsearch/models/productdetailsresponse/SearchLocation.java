
package com.karcompany.productsearch.models.productdetailsresponse;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SearchLocation implements Parcelable
{

    @SerializedName("neighborhood")
    @Expose
    private Neighborhood neighborhood;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("state")
    @Expose
    private State state;
    public final static Creator<SearchLocation> CREATOR = new Creator<SearchLocation>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchLocation createFromParcel(Parcel in) {
            SearchLocation instance = new SearchLocation();
            instance.neighborhood = ((Neighborhood) in.readValue((Neighborhood.class.getClassLoader())));
            instance.city = ((City) in.readValue((City.class.getClassLoader())));
            instance.state = ((State) in.readValue((State.class.getClassLoader())));
            return instance;
        }

        public SearchLocation[] newArray(int size) {
            return (new SearchLocation[size]);
        }

    }
    ;

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(neighborhood).append(city).append(state).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchLocation) == false) {
            return false;
        }
        SearchLocation rhs = ((SearchLocation) other);
        return new EqualsBuilder().append(neighborhood, rhs.neighborhood).append(city, rhs.city).append(state, rhs.state).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(neighborhood);
        dest.writeValue(city);
        dest.writeValue(state);
    }

    public int describeContents() {
        return  0;
    }

}

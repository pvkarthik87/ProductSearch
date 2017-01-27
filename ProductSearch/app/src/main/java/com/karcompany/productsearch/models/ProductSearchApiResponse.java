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

public class ProductSearchApiResponse implements Parcelable
{

    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("secondary_results")
    @Expose
    private List<Object> secondaryResults = null;
    @SerializedName("related_results")
    @Expose
    private List<Object> relatedResults = null;
    @SerializedName("sort")
    @Expose
    private Sort sort;
    @SerializedName("available_sorts")
    @Expose
    private List<AvailableSort> availableSorts = null;
    @SerializedName("filters")
    @Expose
    private List<Filter> filters = null;
    @SerializedName("available_filters")
    @Expose
    private List<AvailableFilter> availableFilters = null;
    public final static Creator<ProductSearchApiResponse> CREATOR = new Creator<ProductSearchApiResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductSearchApiResponse createFromParcel(Parcel in) {
            ProductSearchApiResponse instance = new ProductSearchApiResponse();
            instance.siteId = ((String) in.readValue((String.class.getClassLoader())));
            instance.query = ((String) in.readValue((String.class.getClassLoader())));
            instance.paging = ((Paging) in.readValue((Paging.class.getClassLoader())));
            in.readList(instance.results, (com.karcompany.productsearch.models.Result.class.getClassLoader()));
            in.readList(instance.secondaryResults, (Object.class.getClassLoader()));
            in.readList(instance.relatedResults, (Object.class.getClassLoader()));
            instance.sort = ((Sort) in.readValue((Sort.class.getClassLoader())));
            in.readList(instance.availableSorts, (AvailableSort.class.getClassLoader()));
            in.readList(instance.filters, (Filter.class.getClassLoader()));
            in.readList(instance.availableFilters, (AvailableFilter.class.getClassLoader()));
            return instance;
        }

        public ProductSearchApiResponse[] newArray(int size) {
            return (new ProductSearchApiResponse[size]);
        }

    }
    ;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Object> getSecondaryResults() {
        return secondaryResults;
    }

    public void setSecondaryResults(List<Object> secondaryResults) {
        this.secondaryResults = secondaryResults;
    }

    public List<Object> getRelatedResults() {
        return relatedResults;
    }

    public void setRelatedResults(List<Object> relatedResults) {
        this.relatedResults = relatedResults;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<AvailableSort> getAvailableSorts() {
        return availableSorts;
    }

    public void setAvailableSorts(List<AvailableSort> availableSorts) {
        this.availableSorts = availableSorts;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<AvailableFilter> getAvailableFilters() {
        return availableFilters;
    }

    public void setAvailableFilters(List<AvailableFilter> availableFilters) {
        this.availableFilters = availableFilters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(siteId).append(query).append(paging).append(results).append(secondaryResults).append(relatedResults).append(sort).append(availableSorts).append(filters).append(availableFilters).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductSearchApiResponse) == false) {
            return false;
        }
        ProductSearchApiResponse rhs = ((ProductSearchApiResponse) other);
        return new EqualsBuilder().append(siteId, rhs.siteId).append(query, rhs.query).append(paging, rhs.paging).append(results, rhs.results).append(secondaryResults, rhs.secondaryResults).append(relatedResults, rhs.relatedResults).append(sort, rhs.sort).append(availableSorts, rhs.availableSorts).append(filters, rhs.filters).append(availableFilters, rhs.availableFilters).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(siteId);
        dest.writeValue(query);
        dest.writeValue(paging);
        dest.writeList(results);
        dest.writeList(secondaryResults);
        dest.writeList(relatedResults);
        dest.writeValue(sort);
        dest.writeList(availableSorts);
        dest.writeList(filters);
        dest.writeList(availableFilters);
    }

    public int describeContents() {
        return  0;
    }

}

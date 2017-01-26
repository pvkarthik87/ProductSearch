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

public class Result implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private Object subtitle;
    @SerializedName("seller")
    @Expose
    private Seller seller;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("available_quantity")
    @Expose
    private long availableQuantity;
    @SerializedName("sold_quantity")
    @Expose
    private long soldQuantity;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("listing_type_id")
    @Expose
    private String listingTypeId;
    @SerializedName("stop_time")
    @Expose
    private String stopTime;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("accepts_mercadopago")
    @Expose
    private boolean acceptsMercadopago;
    @SerializedName("installments")
    @Expose
    private Installments installments;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;
    @SerializedName("seller_address")
    @Expose
    private SellerAddress sellerAddress;
    @SerializedName("attributes")
    @Expose
    private List<Object> attributes = null;
    @SerializedName("original_price")
    @Expose
    private Object originalPrice;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("official_store_id")
    @Expose
    private Object officialStoreId;
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.siteId = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.subtitle = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.seller = ((Seller) in.readValue((Seller.class.getClassLoader())));
            instance.price = ((double) in.readValue((double.class.getClassLoader())));
            instance.currencyId = ((String) in.readValue((String.class.getClassLoader())));
            instance.availableQuantity = ((long) in.readValue((long.class.getClassLoader())));
            instance.soldQuantity = ((long) in.readValue((long.class.getClassLoader())));
            instance.buyingMode = ((String) in.readValue((String.class.getClassLoader())));
            instance.listingTypeId = ((String) in.readValue((String.class.getClassLoader())));
            instance.stopTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.condition = ((String) in.readValue((String.class.getClassLoader())));
            instance.permalink = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
            instance.acceptsMercadopago = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.installments = ((Installments) in.readValue((Installments.class.getClassLoader())));
            instance.address = ((Address) in.readValue((Address.class.getClassLoader())));
            instance.shipping = ((Shipping) in.readValue((Shipping.class.getClassLoader())));
            instance.sellerAddress = ((SellerAddress) in.readValue((SellerAddress.class.getClassLoader())));
            in.readList(instance.attributes, (Object.class.getClassLoader()));
            instance.originalPrice = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.categoryId = ((String) in.readValue((String.class.getClassLoader())));
            instance.officialStoreId = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Object subtitle) {
        this.subtitle = subtitle;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public Object getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Object originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Object getOfficialStoreId() {
        return officialStoreId;
    }

    public void setOfficialStoreId(Object officialStoreId) {
        this.officialStoreId = officialStoreId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(siteId).append(title).append(subtitle).append(seller).append(price).append(currencyId).append(availableQuantity).append(soldQuantity).append(buyingMode).append(listingTypeId).append(stopTime).append(condition).append(permalink).append(thumbnail).append(acceptsMercadopago).append(installments).append(address).append(shipping).append(sellerAddress).append(attributes).append(originalPrice).append(categoryId).append(officialStoreId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder().append(id, rhs.id).append(siteId, rhs.siteId).append(title, rhs.title).append(subtitle, rhs.subtitle).append(seller, rhs.seller).append(price, rhs.price).append(currencyId, rhs.currencyId).append(availableQuantity, rhs.availableQuantity).append(soldQuantity, rhs.soldQuantity).append(buyingMode, rhs.buyingMode).append(listingTypeId, rhs.listingTypeId).append(stopTime, rhs.stopTime).append(condition, rhs.condition).append(permalink, rhs.permalink).append(thumbnail, rhs.thumbnail).append(acceptsMercadopago, rhs.acceptsMercadopago).append(installments, rhs.installments).append(address, rhs.address).append(shipping, rhs.shipping).append(sellerAddress, rhs.sellerAddress).append(attributes, rhs.attributes).append(originalPrice, rhs.originalPrice).append(categoryId, rhs.categoryId).append(officialStoreId, rhs.officialStoreId).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(siteId);
        dest.writeValue(title);
        dest.writeValue(subtitle);
        dest.writeValue(seller);
        dest.writeValue(price);
        dest.writeValue(currencyId);
        dest.writeValue(availableQuantity);
        dest.writeValue(soldQuantity);
        dest.writeValue(buyingMode);
        dest.writeValue(listingTypeId);
        dest.writeValue(stopTime);
        dest.writeValue(condition);
        dest.writeValue(permalink);
        dest.writeValue(thumbnail);
        dest.writeValue(acceptsMercadopago);
        dest.writeValue(installments);
        dest.writeValue(address);
        dest.writeValue(shipping);
        dest.writeValue(sellerAddress);
        dest.writeList(attributes);
        dest.writeValue(originalPrice);
        dest.writeValue(categoryId);
        dest.writeValue(officialStoreId);
    }

    public int describeContents() {
        return  0;
    }

}

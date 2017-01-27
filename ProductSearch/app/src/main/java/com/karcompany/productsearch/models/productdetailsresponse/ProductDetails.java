
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

public class ProductDetails implements Parcelable
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
    @SerializedName("seller_id")
    @Expose
    private long sellerId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("official_store_id")
    @Expose
    private Object officialStoreId;
    @SerializedName("price")
    @Expose
    private long price;
    @SerializedName("base_price")
    @Expose
    private long basePrice;
    @SerializedName("original_price")
    @Expose
    private Object originalPrice;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("initial_quantity")
    @Expose
    private long initialQuantity;
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
    @SerializedName("start_time")
    @Expose
    private String startTime;
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
    @SerializedName("secure_thumbnail")
    @Expose
    private String secureThumbnail;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("video_id")
    @Expose
    private Object videoId;
    @SerializedName("descriptions")
    @Expose
    private List<Description> descriptions = null;
    @SerializedName("accepts_mercadopago")
    @Expose
    private boolean acceptsMercadopago;
    @SerializedName("non_mercado_pago_payment_methods")
    @Expose
    private List<NonMercadoPagoPaymentMethod> nonMercadoPagoPaymentMethods = null;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;
    @SerializedName("international_delivery_mode")
    @Expose
    private String internationalDeliveryMode;
    @SerializedName("seller_address")
    @Expose
    private SellerAddress sellerAddress;
    @SerializedName("seller_contact")
    @Expose
    private Object sellerContact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("geolocation")
    @Expose
    private Geolocation geolocation;
    @SerializedName("coverage_areas")
    @Expose
    private List<Object> coverageAreas = null;
    @SerializedName("attributes")
    @Expose
    private List<Object> attributes = null;
    @SerializedName("warnings")
    @Expose
    private List<Object> warnings = null;
    @SerializedName("listing_source")
    @Expose
    private String listingSource;
    @SerializedName("variations")
    @Expose
    private List<Object> variations = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sub_status")
    @Expose
    private List<String> subStatus = null;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("warranty")
    @Expose
    private String warranty;
    @SerializedName("catalog_product_id")
    @Expose
    private Object catalogProductId;
    @SerializedName("domain_id")
    @Expose
    private Object domainId;
    @SerializedName("parent_item_id")
    @Expose
    private String parentItemId;
    @SerializedName("differential_pricing")
    @Expose
    private Object differentialPricing;
    @SerializedName("deal_ids")
    @Expose
    private List<Object> dealIds = null;
    @SerializedName("automatic_relist")
    @Expose
    private boolean automaticRelist;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    public final static Creator<ProductDetails> CREATOR = new Creator<ProductDetails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductDetails createFromParcel(Parcel in) {
            ProductDetails instance = new ProductDetails();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.siteId = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.subtitle = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.sellerId = ((long) in.readValue((long.class.getClassLoader())));
            instance.categoryId = ((String) in.readValue((String.class.getClassLoader())));
            instance.officialStoreId = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.price = ((long) in.readValue((long.class.getClassLoader())));
            instance.basePrice = ((long) in.readValue((long.class.getClassLoader())));
            instance.originalPrice = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.currencyId = ((String) in.readValue((String.class.getClassLoader())));
            instance.initialQuantity = ((long) in.readValue((long.class.getClassLoader())));
            instance.availableQuantity = ((long) in.readValue((long.class.getClassLoader())));
            instance.soldQuantity = ((long) in.readValue((long.class.getClassLoader())));
            instance.buyingMode = ((String) in.readValue((String.class.getClassLoader())));
            instance.listingTypeId = ((String) in.readValue((String.class.getClassLoader())));
            instance.startTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.stopTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.condition = ((String) in.readValue((String.class.getClassLoader())));
            instance.permalink = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
            instance.secureThumbnail = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.pictures, (Picture.class.getClassLoader()));
            instance.videoId = ((Object) in.readValue((Object.class.getClassLoader())));
            in.readList(instance.descriptions, (Description.class.getClassLoader()));
            instance.acceptsMercadopago = ((boolean) in.readValue((boolean.class.getClassLoader())));
            in.readList(instance.nonMercadoPagoPaymentMethods, (com.karcompany.productsearch.models.productdetailsresponse.NonMercadoPagoPaymentMethod.class.getClassLoader()));
            instance.shipping = ((Shipping) in.readValue((Shipping.class.getClassLoader())));
            instance.internationalDeliveryMode = ((String) in.readValue((String.class.getClassLoader())));
            instance.sellerAddress = ((SellerAddress) in.readValue((SellerAddress.class.getClassLoader())));
            instance.sellerContact = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            instance.geolocation = ((Geolocation) in.readValue((Geolocation.class.getClassLoader())));
            in.readList(instance.coverageAreas, (Object.class.getClassLoader()));
            in.readList(instance.attributes, (Object.class.getClassLoader()));
            in.readList(instance.warnings, (Object.class.getClassLoader()));
            instance.listingSource = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.variations, (Object.class.getClassLoader()));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.subStatus, (String.class.getClassLoader()));
            in.readList(instance.tags, (String.class.getClassLoader()));
            instance.warranty = ((String) in.readValue((String.class.getClassLoader())));
            instance.catalogProductId = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.domainId = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.parentItemId = ((String) in.readValue((String.class.getClassLoader())));
            instance.differentialPricing = ((Object) in.readValue((Object.class.getClassLoader())));
            in.readList(instance.dealIds, (Object.class.getClassLoader()));
            instance.automaticRelist = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.dateCreated = ((String) in.readValue((String.class.getClassLoader())));
            instance.lastUpdated = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ProductDetails[] newArray(int size) {
            return (new ProductDetails[size]);
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

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public Object getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Object originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(long initialQuantity) {
        this.initialQuantity = initialQuantity;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Object getVideoId() {
        return videoId;
    }

    public void setVideoId(Object videoId) {
        this.videoId = videoId;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    public List<NonMercadoPagoPaymentMethod> getNonMercadoPagoPaymentMethods() {
        return nonMercadoPagoPaymentMethods;
    }

    public void setNonMercadoPagoPaymentMethods(List<NonMercadoPagoPaymentMethod> nonMercadoPagoPaymentMethods) {
        this.nonMercadoPagoPaymentMethods = nonMercadoPagoPaymentMethods;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getInternationalDeliveryMode() {
        return internationalDeliveryMode;
    }

    public void setInternationalDeliveryMode(String internationalDeliveryMode) {
        this.internationalDeliveryMode = internationalDeliveryMode;
    }

    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public Object getSellerContact() {
        return sellerContact;
    }

    public void setSellerContact(Object sellerContact) {
        this.sellerContact = sellerContact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public List<Object> getCoverageAreas() {
        return coverageAreas;
    }

    public void setCoverageAreas(List<Object> coverageAreas) {
        this.coverageAreas = coverageAreas;
    }

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public String getListingSource() {
        return listingSource;
    }

    public void setListingSource(String listingSource) {
        this.listingSource = listingSource;
    }

    public List<Object> getVariations() {
        return variations;
    }

    public void setVariations(List<Object> variations) {
        this.variations = variations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(List<String> subStatus) {
        this.subStatus = subStatus;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Object getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(Object catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

    public Object getDomainId() {
        return domainId;
    }

    public void setDomainId(Object domainId) {
        this.domainId = domainId;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Object getDifferentialPricing() {
        return differentialPricing;
    }

    public void setDifferentialPricing(Object differentialPricing) {
        this.differentialPricing = differentialPricing;
    }

    public List<Object> getDealIds() {
        return dealIds;
    }

    public void setDealIds(List<Object> dealIds) {
        this.dealIds = dealIds;
    }

    public boolean isAutomaticRelist() {
        return automaticRelist;
    }

    public void setAutomaticRelist(boolean automaticRelist) {
        this.automaticRelist = automaticRelist;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(siteId).append(title).append(subtitle).append(sellerId).append(categoryId).append(officialStoreId).append(price).append(basePrice).append(originalPrice).append(currencyId).append(initialQuantity).append(availableQuantity).append(soldQuantity).append(buyingMode).append(listingTypeId).append(startTime).append(stopTime).append(condition).append(permalink).append(thumbnail).append(secureThumbnail).append(pictures).append(videoId).append(descriptions).append(acceptsMercadopago).append(nonMercadoPagoPaymentMethods).append(shipping).append(internationalDeliveryMode).append(sellerAddress).append(sellerContact).append(location).append(geolocation).append(coverageAreas).append(attributes).append(warnings).append(listingSource).append(variations).append(status).append(subStatus).append(tags).append(warranty).append(catalogProductId).append(domainId).append(parentItemId).append(differentialPricing).append(dealIds).append(automaticRelist).append(dateCreated).append(lastUpdated).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductDetails) == false) {
            return false;
        }
        ProductDetails rhs = ((ProductDetails) other);
        return new EqualsBuilder().append(id, rhs.id).append(siteId, rhs.siteId).append(title, rhs.title).append(subtitle, rhs.subtitle).append(sellerId, rhs.sellerId).append(categoryId, rhs.categoryId).append(officialStoreId, rhs.officialStoreId).append(price, rhs.price).append(basePrice, rhs.basePrice).append(originalPrice, rhs.originalPrice).append(currencyId, rhs.currencyId).append(initialQuantity, rhs.initialQuantity).append(availableQuantity, rhs.availableQuantity).append(soldQuantity, rhs.soldQuantity).append(buyingMode, rhs.buyingMode).append(listingTypeId, rhs.listingTypeId).append(startTime, rhs.startTime).append(stopTime, rhs.stopTime).append(condition, rhs.condition).append(permalink, rhs.permalink).append(thumbnail, rhs.thumbnail).append(secureThumbnail, rhs.secureThumbnail).append(pictures, rhs.pictures).append(videoId, rhs.videoId).append(descriptions, rhs.descriptions).append(acceptsMercadopago, rhs.acceptsMercadopago).append(nonMercadoPagoPaymentMethods, rhs.nonMercadoPagoPaymentMethods).append(shipping, rhs.shipping).append(internationalDeliveryMode, rhs.internationalDeliveryMode).append(sellerAddress, rhs.sellerAddress).append(sellerContact, rhs.sellerContact).append(location, rhs.location).append(geolocation, rhs.geolocation).append(coverageAreas, rhs.coverageAreas).append(attributes, rhs.attributes).append(warnings, rhs.warnings).append(listingSource, rhs.listingSource).append(variations, rhs.variations).append(status, rhs.status).append(subStatus, rhs.subStatus).append(tags, rhs.tags).append(warranty, rhs.warranty).append(catalogProductId, rhs.catalogProductId).append(domainId, rhs.domainId).append(parentItemId, rhs.parentItemId).append(differentialPricing, rhs.differentialPricing).append(dealIds, rhs.dealIds).append(automaticRelist, rhs.automaticRelist).append(dateCreated, rhs.dateCreated).append(lastUpdated, rhs.lastUpdated).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(siteId);
        dest.writeValue(title);
        dest.writeValue(subtitle);
        dest.writeValue(sellerId);
        dest.writeValue(categoryId);
        dest.writeValue(officialStoreId);
        dest.writeValue(price);
        dest.writeValue(basePrice);
        dest.writeValue(originalPrice);
        dest.writeValue(currencyId);
        dest.writeValue(initialQuantity);
        dest.writeValue(availableQuantity);
        dest.writeValue(soldQuantity);
        dest.writeValue(buyingMode);
        dest.writeValue(listingTypeId);
        dest.writeValue(startTime);
        dest.writeValue(stopTime);
        dest.writeValue(condition);
        dest.writeValue(permalink);
        dest.writeValue(thumbnail);
        dest.writeValue(secureThumbnail);
        dest.writeList(pictures);
        dest.writeValue(videoId);
        dest.writeList(descriptions);
        dest.writeValue(acceptsMercadopago);
        dest.writeList(nonMercadoPagoPaymentMethods);
        dest.writeValue(shipping);
        dest.writeValue(internationalDeliveryMode);
        dest.writeValue(sellerAddress);
        dest.writeValue(sellerContact);
        dest.writeValue(location);
        dest.writeValue(geolocation);
        dest.writeList(coverageAreas);
        dest.writeList(attributes);
        dest.writeList(warnings);
        dest.writeValue(listingSource);
        dest.writeList(variations);
        dest.writeValue(status);
        dest.writeList(subStatus);
        dest.writeList(tags);
        dest.writeValue(warranty);
        dest.writeValue(catalogProductId);
        dest.writeValue(domainId);
        dest.writeValue(parentItemId);
        dest.writeValue(differentialPricing);
        dest.writeList(dealIds);
        dest.writeValue(automaticRelist);
        dest.writeValue(dateCreated);
        dest.writeValue(lastUpdated);
    }

    public int describeContents() {
        return  0;
    }

}

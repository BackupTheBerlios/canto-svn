/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import li.rajenlab.common.domain.AbstractEntity;

import org.springframework.util.StringUtils;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Product extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 191783787483121220L;
    
    private String productId_;
    private Set<ProductCategory> categories_;
    private Map<String,String> metadata_;
    private Set<ProductSegment> segments_;
    
    /**
     * @return the categories
     */
    public Set<ProductCategory> getCategories() {
        return this.categories_;
    }
    /**
     * @param categories the categories to set
     */
    public void setCategories(Set<ProductCategory> categories) {
        this.categories_ = categories;
    }
    
    
    public synchronized void  addCategory(ProductCategory category){
        if (getCategories()!=null){
            this.categories_ = new HashSet<ProductCategory>();
        }
        categories_.add(category);
    }
    
    public synchronized void removeCategory(ProductCategory category){
        if (getCategories()!=null){
            this.categories_.remove(category);
        }
    }
    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return this.metadata_;
    }
    /**
     * @param metadata the metadata to set
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata_ = metadata;
    }
    
    /**
     * Adds metadata to the Product.
     * 
     * @param name the name of the metadata.
     * @param value the value of the metadata.
     */
    public synchronized void addMetadata( String name, String value ) {
        if ( getMetadata() == null ) {
            setMetadata( new HashMap<String,String>() );
        }
        getMetadata().put(name,value);
    }
    
    /**
     * Adds metadata to the Product but only if the metadata is not set already.
     * 
     * @param name the name of the metadata.
     * @param value the value of the metadata.
     */
    public synchronized void addMetadataIfMissing( String name, String value ) {
        if ( getMetadata() == null ) {
            setMetadata( new HashMap<String,String>() );
        }
        if ( getMetadataValue(name) != null && !StringUtils.hasText(getMetadataValue(name))) {
            getMetadata().put(name,value);
        }
    }
    
    /**
     * Adds metadata to the Product. If the value is already set, the new value is appended 
     * to the current value (separated by a comma).
     * 
     * @param name the name of the metadata.
     * @param value the value of the metadata.
     */
    public synchronized void mergeMetadataTokenized( String name, String value, String token ) {
        if ( getMetadata() == null ) {
            setMetadata( new HashMap<String,String>() );
        }
        String metaDataValue = getMetadataValue(name);
        if (StringUtils.hasText(metaDataValue)) {
            StringTokenizer st = new StringTokenizer(metaDataValue, token);
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(value)){
                    // not necessary to add a value twice
                    return;
                }
            }

            // value not present but other content -> append value
            metaDataValue = metaDataValue + token + value;

        } else {
            // metadata value not set before
            metaDataValue = value;
        }
        getMetadata().put(name,StringUtils.trimAllWhitespace(metaDataValue));
        
    }
    
    /**
     * Gets metadata value from the Product of a certain key.
     * 
     * @param name the name of the metadata.
     */
    public synchronized String getMetadataValue (String name) {
        return (getMetadata() != null ? getMetadata().get(name) : null);
    }

    /**
     * Removes metadata from the Product.
     * 
     * @param name the name of the metadata.
     */
    public synchronized void removeMetadata( String name ) {
        if ( getMetadata() != null ) {
            getMetadata().remove(name);
        }
    }
    /**
     * @return the productId
     */
    public String getProductId() {
        return this.productId_;
    }
    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId_ = productId;
    }
    /**
     * @return the segments
     */
    public Set<ProductSegment> getSegments() {
        return this.segments_;
    }
    /**
     * @param segments the segments to set
     */
    public void setSegments(Set<ProductSegment> segments) {
        this.segments_ = segments;
    }

    

}

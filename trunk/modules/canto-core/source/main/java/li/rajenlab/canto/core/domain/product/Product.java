/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import li.rajenlab.common.domain.AbstractLocaleEntity;
import li.rajenlab.common.domain.attribute.AttributeValue;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Product extends AbstractLocaleEntity {
    
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5761978391460071959L;
    private ProductType type_;
    private Set<ProductCategory> categories_;
    private List<AttributeValue> attributes_;
    private Set<Product> parts_;
    private ProductStatus status_;
    
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
    
    public synchronized void addCategory(ProductCategory category){
        if (getCategories()==null){
            categories_ = new HashSet<ProductCategory>();
        }
        categories_.add(category);
    }
    
    public synchronized void removeCategory(ProductCategory category){
        if (getCategories()!=null){
            categories_.remove(category);
        }
    }
    
    /**
     * @return the type
     */
    public ProductType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(ProductType type) {
        this.type_ = type;
    }
    /**
     * @return the attributes
     */
    public List<AttributeValue> getAttributes() {
        return this.attributes_;
    }
    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(List<AttributeValue> attributes) {
        this.attributes_ = attributes;
    }

    public synchronized void addAttribute(AttributeValue attribute){
        if (getAttributes()==null){
            attributes_ = new Vector<AttributeValue>();
        }
        attributes_.add(attribute);
    }
   
    public synchronized void removeAttribute(AttributeValue attribute){
        if (getAttributes()!=null){
            attributes_.remove(attribute);
        }
    }
    /**
     * @return the parts
     */
    public Set<Product> getParts() {
        return this.parts_;
    }
    /**
     * @param parts the parts to set
     */
    public void setParts(Set<Product> parts) {
        this.parts_ = parts;
    }
    
    public synchronized void addPart(Product product){
       if (getParts()==null){
           parts_ = new HashSet<Product>();
       }
       parts_.add(product);
    }
    
    public synchronized void removePart(Product product){
        if (getParts()!=null){
            parts_.remove(product);
        }
    }
    /**
     * @return the status
     */
    public ProductStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(ProductStatus status) {
        this.status_ = status;
    }

}

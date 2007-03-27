/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.product;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.employee.Employee;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductCatalogItem extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8075279286206108567L;
    private String productUrl_;
    private float listPrice_;
    private float unitPrice_;
    private int quantityInStock_;
    private float costOfProduct_;
    private Manufacturer manufacturer_;
    private String manufacturerPartNumber_;
    private String vendorPartNumber_;
    private String assetNumber_;
    private float weight_;
    private ProductCatalogType type_;
    private ProductCatalog catalog_;
    private Employee supportContact_;
    private ProductSupportTerm supportTerm_;
    private Opportunity opportunity_;
    
    /**
     * @return the assetNumber
     */
    public String getAssetNumber() {
        return this.assetNumber_;
    }
    /**
     * @param assetNumber the assetNumber to set
     */
    public void setAssetNumber(String assetNumber) {
        this.assetNumber_ = assetNumber;
    }
    /**
     * @return the catalog
     */
    public ProductCatalog getCatalog() {
        return this.catalog_;
    }
    /**
     * @param catalog the catalog to set
     */
    public void setCatalog(ProductCatalog catalog) {
        this.catalog_ = catalog;
    }
    /**
     * @return the costOfProduct
     */
    public float getCostOfProduct() {
        return this.costOfProduct_;
    }
    /**
     * @param costOfProduct the costOfProduct to set
     */
    public void setCostOfProduct(float costOfProduct) {
        this.costOfProduct_ = costOfProduct;
    }
    /**
     * @return the listPrice
     */
    public float getListPrice() {
        return this.listPrice_;
    }
    /**
     * @param listPrice the listPrice to set
     */
    public void setListPrice(float listPrice) {
        this.listPrice_ = listPrice;
    }
    /**
     * @return the manufacturer
     */
    public Manufacturer getManufacturer() {
        return this.manufacturer_;
    }
    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer_ = manufacturer;
    }
    /**
     * @return the manufacturerPartNumber
     */
    public String getManufacturerPartNumber() {
        return this.manufacturerPartNumber_;
    }
    /**
     * @param manufacturerPartNumber the manufacturerPartNumber to set
     */
    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber_ = manufacturerPartNumber;
    }
    /**
     * @return the productUrl
     */
    public String getProductUrl() {
        return this.productUrl_;
    }
    /**
     * @param productUrl the productUrl to set
     */
    public void setProductUrl(String productUrl) {
        this.productUrl_ = productUrl;
    }
    /**
     * @return the quantityInStock
     */
    public int getQuantityInStock() {
        return this.quantityInStock_;
    }
    /**
     * @param quantityInStock the quantityInStock to set
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock_ = quantityInStock;
    }
    /**
     * @return the supportContact
     */
    public Employee getSupportContact() {
        return this.supportContact_;
    }
    /**
     * @param supportContact the supportContact to set
     */
    public void setSupportContact(Employee supportContact) {
        this.supportContact_ = supportContact;
    }
    /**
     * @return the supportTerm
     */
    public ProductSupportTerm getSupportTerm() {
        return this.supportTerm_;
    }
    /**
     * @param supportTerm the supportTerm to set
     */
    public void setSupportTerm(ProductSupportTerm supportTerm) {
        this.supportTerm_ = supportTerm;
    }
    /**
     * @return the type
     */
    public ProductCatalogType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(ProductCatalogType type) {
        this.type_ = type;
    }
    /**
     * @return the unitPrice
     */
    public float getUnitPrice() {
        return this.unitPrice_;
    }
    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(float unitPrice) {
        this.unitPrice_ = unitPrice;
    }
    /**
     * @return the vendorPartNumber
     */
    public String getVendorPartNumber() {
        return this.vendorPartNumber_;
    }
    /**
     * @param vendorPartNumber the vendorPartNumber to set
     */
    public void setVendorPartNumber(String vendorPartNumber) {
        this.vendorPartNumber_ = vendorPartNumber;
    }
    /**
     * @return the weight
     */
    public float getWeight() {
        return this.weight_;
    }
    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight_ = weight;
    }
    /**
     * @return the opportunity
     */
    public Opportunity getOpportunity() {
        return this.opportunity_;
    }
    /**
     * @param opportunity the opportunity to set
     */
    public void setOpportunity(Opportunity opportunity) {
        this.opportunity_ = opportunity;
    }
    
    
    

}

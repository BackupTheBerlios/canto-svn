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

import li.rajenlab.common.domain.AbstractLocaleEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductCategory extends AbstractLocaleEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4513532946902369435L;
    
    private ProductCategory parent_;

    /**
     * @return the parent
     */
    public ProductCategory getParent() {
        return this.parent_;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(ProductCategory parent) {
        this.parent_ = parent;
    }
    
    

}

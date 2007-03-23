/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.document;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum DocumentType implements StringValuedEnum {
    
    PDF("PDF"),
    FREEMARKER("FREEMARKER"),
    VELOCITY("VELOCITY"),
    MSOFFICE_WORD("MS-OFFICE_WORD"),
    IMAGE_JPG("IMAGE_JPG");

    private String templateType_;
    
    private DocumentType(String templateType){
        this.templateType_ = templateType;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return templateType_;
    }

}

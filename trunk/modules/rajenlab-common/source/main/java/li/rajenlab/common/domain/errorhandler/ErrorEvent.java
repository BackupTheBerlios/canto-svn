/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:48 $
 * $LastChangedDate:2007-03-07 13:51:41 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/rajenlab-common/source/main/java/li/rajenlab/common/dao/BaseDao.java $
 ******************************************************************************/

package li.rajenlab.common.domain.errorhandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import li.rajenlab.common.domain.AbstractEntity;


/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ErrorEvent extends AbstractEntity {
    
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------
    public static final int LONG_FIELD = 4000;
    public static final int SHORT_FIELD = 255;

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    private static final long serialVersionUID = 1980754983510134337L;
    
    private Date timestamp_;
    private String module_;
    private String category_;
    private String subcategory_;
    private String reference_;
    private String detail_;
    private List<ErrorData> data_;
    private String stacktrace_;

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    public void addErrorData(String name, String value) {
        ErrorData data = new ErrorData();
        data.setName(name);
        data.setValue(value);
        addErrorData(data);
    }

    public void addErrorData(ErrorData data) {
        getData().add(data);
    }
    
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    /**
     * @return Returns the category.
     */
    public String getCategory() {
        return category_;
    }
    /**
     * @param category The category to set.
     */
    public void setCategory(String category) {
        category_ = StringUtil.cutLength(category, SHORT_FIELD);
    }
    /**
     * @return Returns the detail.
     */
    public String getDetail() {
        return detail_;
    }
    /**
     * @param detail The detail to set.
     */
    public void setDetail(String detail) {
        detail_ = StringUtil.cutLength(detail, LONG_FIELD);;
    }
    /**
     * @return Returns the module.
     */
    public String getModule() {
        return module_;
    }
    /**
     * @param module The module to set.
     */
    public void setModule(String module) {
        module_ = StringUtil.cutLength(module, SHORT_FIELD);
    }
    /**
     * @return Returns the reference.
     */
    public String getReference() {
        return reference_;
    }
    /**
     * @param reference The reference to set.
     */
    public void setReference(String reference) {
        reference_ = StringUtil.cutLength(reference, SHORT_FIELD);
    }
    /**
     * @return Returns the stacktrace.
     */
    public String getStacktrace() {
        return stacktrace_;
    }
    /**
     * @param stacktrace The stacktrace to set.
     */
    public void setStacktrace(String stacktrace) {
        stacktrace_ = stacktrace;
    }
    /**
     * @return Returns the subcategory.
     */
    public String getSubcategory() {
        return subcategory_;
    }
    /**
     * @param subcategory The subcategory to set.
     */
    public void setSubcategory(String subcategory) {
        subcategory_ = StringUtil.cutLength(subcategory, SHORT_FIELD);
    }
    /**
     * @return Returns the timestamp.
     */
    public Date getTimestamp() {
        return timestamp_;
    }
    /**
     * @param timestamp The timestamp to set.
     */
    public void setTimestamp(Date timestamp) {
        timestamp_ = timestamp;
    }

    /**
     * @return Returns the data.
     */
    public List<ErrorData> getData() {
        if (data_ == null) {
            data_ = new ArrayList<ErrorData>();
        }
        return data_;
    }

    /**
     * @param data The data to set.
     */
    public void setData(List<ErrorData> data) {
        data_ = data;
    }

}

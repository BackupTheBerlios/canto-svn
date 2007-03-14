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

/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ErrorData {
    
    public static final int NAME_LENGTH = 255;
    public static final int VALUE_LENGTH = 4000;
    
    private String name_;
    private String value_;
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name_;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        name_ = StringUtil.cutLength(name, NAME_LENGTH) ;
    }
    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value_;
    }
    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        value_ = StringUtil.cutLength(value, VALUE_LENGTH);
    }

}

/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.dao.hibernate;

import static li.rajenlab.common.lang.StringValuedEnumReflect.getNameFromValue;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import li.rajenlab.common.lang.StringValuedEnum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class StringValuedEnumType <T extends Enum & StringValuedEnum> implements EnhancedUserType,
        ParameterizedType {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(StringValuedEnumType.class);

    /**
     * Enum class for this particular user type.
     */
    private Class<T> enumClass_;
    

    /**
     * Value to use if null.
     */
    private String defaultValue_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------


    
    /** Creates a new instance of StringValuedEnumType */
    public StringValuedEnumType() {
    }
    
    /**
     * 
     * @see org.hibernate.usertype.ParameterizedType#setParameterValues(java.util.Properties)
     */
    @SuppressWarnings("unchecked")
    public void setParameterValues(Properties parameters) {
        String enumClassName = parameters.getProperty("enum");
        try {
            enumClass_ = (Class<T>) Class.forName(enumClassName).asSubclass(Enum.class).
                    asSubclass(StringValuedEnum.class); //Validates the class but does not eliminate the cast
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("Enum class not found", cnfe);
        }

        setDefaultValue(parameters.getProperty("defaultValue"));
    }

    public String getDefaultValue() {
        return defaultValue_;
    }
    
    public void setDefaultValue(String defaultValue) {
        this.defaultValue_ = defaultValue;
    }
    
    /**
     * The class returned by <tt>nullSafeGet()</tt>.
     * @return Class
     */
    public Class returnedClass() {
        return enumClass_;
    }

    /**
     * 
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }
    
    /**
     * 
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    public boolean isMutable() {
        return false;
    }

    /**
     * Retrieve an instance of the mapped class from a JDBC resultset. Implementors
     * should handle possibility of null values.
     *
     * @param rs a JDBC result set
     * @param names the column names
     * @param owner the containing entity
     * @return Object
     * @throws HibernateException
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
            throws HibernateException, SQLException {
        String value = rs.getString( names[0] );
        if (value==null) {
            value = getDefaultValue();
            if (value==null){ //no default value
                return null;
            }
        }
        String name = getNameFromValue(enumClass_, value);
        Object res = name == null ? null : Enum.valueOf(enumClass_, name);

        return res;
    }
 
    /**
     * Write an instance of the mapped class to a prepared statement. Implementors
     * should handle possibility of null values. A multi-column type should be written
     * to parameters starting from <tt>index</tt>.
     *
     * @param st a JDBC prepared statement
     * @param value the object to write
     * @param index statement parameter index
     * @throws HibernateException
     * @throws SQLException
     */   
    @SuppressWarnings("unchecked")
    public void nullSafeSet(PreparedStatement st, Object value, int index)
    throws HibernateException, SQLException {
        if (value==null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            st.setString( index, ((T) value).getValue() );
        }
    }
    
    /**
     * 
     * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
     */
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }
    
    /**
     * 
     * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
     */
    public Serializable disassemble(Object value) throws HibernateException {
        return (Enum) value;
    }
        
    /**
     * 
     * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
     */
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    /**
     * 
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
     */
    public boolean equals(Object x, Object y) throws HibernateException {
        return x==y;
    }
    
    /**
     * 
     * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
     */
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    /**
     * 
     * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

    /**
     * 
     * @see org.hibernate.usertype.EnhancedUserType#objectToSQLString(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public String objectToSQLString(Object value) {
        return '\'' + ((T) value).getValue() + '\'';
    }
    
    /**
     * 
     * @see org.hibernate.usertype.EnhancedUserType#toXMLString(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public String toXMLString(Object value) {
        return ((T) value).getValue();
    }

    /**
     * 
     * @see org.hibernate.usertype.EnhancedUserType#fromXMLString(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public Object fromXMLString(String xmlValue) {
        String name = getNameFromValue(enumClass_, xmlValue);
        return Enum.valueOf(enumClass_, name);
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

   

}

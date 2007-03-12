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

package li.rajenlab.common.service.xml.oxm.castor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import li.rajenlab.common.service.xml.oxm.MarshallingException;
import li.rajenlab.common.service.xml.oxm.UnmarshallingException;
import li.rajenlab.common.service.xml.oxm.ValidationException;
import li.rajenlab.common.service.xml.oxm.XmlMappingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.Validator;



/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class CastorMarshaller implements 
    li.rajenlab.common.service.xml.oxm.Marshaller,
    li.rajenlab.common.service.xml.oxm.Unmarshaller {

    // -------------------------------------------------------------------------
    // PUBLIC CONSTANTS
    // -------------------------------------------------------------------------
    public static final String DEFAULT_ENCODING = "UTF-8"; 

    // -------------------------------------------------------------------------
    // PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    // -------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(CastorMarshaller.class);

    private String encoding_ = DEFAULT_ENCODING;
    private boolean validation_ = false;
    private Class targetClass_;

    // -------------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------------
    public CastorMarshaller() {
        super();
    }
    
    public CastorMarshaller(Class targetClass) {
        this.targetClass_ = targetClass;
    }

    // -------------------------------------------------------------------------
    // PUBLIC METHODS
    // -------------------------------------------------------------------------
    public byte[] marshal(Object source) throws XmlMappingException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Writer writer;
        try {
            writer = new OutputStreamWriter(bos, getEncoding());
        } catch (UnsupportedEncodingException e1) {
            String desc = "unsupported encoding [" + getEncoding() + "]";
            if (log.isErrorEnabled()) {
                log.error(desc, e1);
            }
            throw new MarshallingException(desc, e1);
        }

        try {
            if (log.isDebugEnabled()) {
                log.debug("validation [" + isValidation() + "]");
            }

            // Marshal the valuebag object
            Marshaller mrslr = new Marshaller(writer);
            mrslr.setValidation(isValidation());
            mrslr.setEncoding(getEncoding());
            mrslr.marshal(source);
        } catch (org.exolab.castor.xml.MarshalException e) {
            String desc = "Exception during marshalling of the valuebag";
            if (log.isErrorEnabled()) {
                log.error(desc, e);
            }
            throw new MarshallingException(desc, e);
        } catch (org.exolab.castor.xml.ValidationException e) {
            String desc = "Exception during marshalling of the valuebag";
            if (log.isErrorEnabled()) {
                log.error(desc, e);
            }
            throw new ValidationException(desc, e);
        } catch (IOException e) {
            String desc = "IO  Exception when creating a marshaller";
            if (log.isErrorEnabled()) {
                log.error(desc, e);
            }
            throw new MarshallingException(desc, e);
        }

        return bos.toByteArray();
    }

    public Object unmarshal(byte[] xml) throws XmlMappingException {
        
        if (getTargetClass() == null) {
            throw new IllegalStateException("targetClass is undefined");
        }
        
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(xml);
            Reader reader = new InputStreamReader(bis, getEncoding());
            Unmarshaller umrslr = new Unmarshaller(getTargetClass());
            umrslr.setValidation(isValidation());
            umrslr.setIgnoreExtraElements(true);
            umrslr.setIgnoreExtraAttributes(true);
            Object result = umrslr.unmarshal(reader);
            if (isValidation()) {
                if (log.isDebugEnabled()) {
                    log.debug("validate the response against the schema now");
                }
                Validator val = new Validator();
                val.validate(result);
            }
            return result;

        } catch (org.exolab.castor.xml.MarshalException e) {
            String msg = "Error during unmarshalling";
            if (log.isErrorEnabled()) {
                log.error(msg, e);
            }
            throw new UnmarshallingException(msg, e);
        } catch (UnsupportedEncodingException e) {
            String msg = "Unsupported encoding [" + getEncoding()
                 + "]during unmarshalling";
            if (log.isErrorEnabled()) {
                log.error(msg, e);
            }
            throw new UnmarshallingException(msg, e);
        } catch (org.exolab.castor.xml.ValidationException e) {
            String msg = "Invalid XML. cannot unmarshal message";
            if (log.isErrorEnabled()) {
                log.error(msg, e);
            }
            throw new ValidationException(msg, e);
        }    }
    
    // -------------------------------------------------------------------------
    // PROTECTED METHODS
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // PRIVATE METHODS
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // PUBLIC ACCESSORS (GETTERS / SETTERS)
    // -------------------------------------------------------------------------

    /**
     * @return Returns the encoding.
     */
    public String getEncoding() {
        return encoding_;
    }

    /**
     * @param encoding The encoding to set.
     */
    public void setEncoding(String encoding) {
        encoding_ = encoding;
    }

    /**
     * @return Returns the validation.
     */
    public boolean isValidation() {
        return validation_;
    }

    /**
     * @param validation The validation to set.
     */
    public void setValidation(boolean validation) {
        validation_ = validation;
    }

    /**
     * @return Returns the targetClass.
     */
    public Class getTargetClass() {
        return targetClass_;
    }

    /**
     * @param targetClass The targetClass to set.
     */
    public void setTargetClass(Class targetClass) {
        targetClass_ = targetClass;
    }


}

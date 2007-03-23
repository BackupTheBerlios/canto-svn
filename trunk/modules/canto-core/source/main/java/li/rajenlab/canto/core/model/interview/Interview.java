/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.interview;

import java.io.Serializable;
import java.util.Date;

import li.rajenlab.canto.core.model.job.application.JobApplication;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Interview implements Serializable {
    
    
    private JobApplication application_;
    private Date interviewDate_;
    private String note_;
    private boolean interviewDone_;
    
    

}

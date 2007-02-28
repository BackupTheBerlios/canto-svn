/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.core.domain.contact;

import li.rajenlab.core.domain.common.AbstractEntity;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Contact extends AbstractEntity {
    
    private String firstName_;
    private String lastName_;
    private String companyName_;
    private ContactType type_;
    private Address     address_;

}

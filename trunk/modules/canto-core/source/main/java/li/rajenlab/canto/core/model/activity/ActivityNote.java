/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity;

import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.document.Document;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ActivityNote extends BeanEntity {
    
   
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5823347889479728452L;
    private List<Document> documents_;
    private String notes_;
    
    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return this.documents_;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents_ = documents;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return this.notes_;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes_ = notes;
    }
    
    

}

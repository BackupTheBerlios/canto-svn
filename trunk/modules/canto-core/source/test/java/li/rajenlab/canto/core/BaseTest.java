/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:43 $
 * $LastChangedDate:2007-03-07 13:22:46 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-core/source/test/java/li/rajenlab/canto/core/BaseTest.java $
 ******************************************************************************/

package li.rajenlab.canto.core;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id:BaseTest.java 43 2007-03-07 13:22:46 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public class BaseTest extends
        AbstractTransactionalDataSourceSpringContextTests {

    /**
     * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#getConfigLocations()
     */
    @Override
    protected String[] getConfigLocations() {
        return new String[] {
                "classpath*:/li/rajenlab/canto/core/unmanaged-canto-context.xml"
        };
    }
    
    /**
     * @see org.springframework.test.AbstractTransactionalDataSourceSpringContextTests#onSetUpBeforeTransaction()
     */
    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
    	setDefaultRollback(false);
    	startNewTransaction();
    	try {
    		doPreTest();
    	} catch ( Exception e ) {
    		logger.warn("onSetupBeforeTransaction failed", e );
    		throw e;
    	} finally {
    		endTransaction();
    		setDefaultRollback(true);
    	}
    }

    /**
     * Perform transactional tests which will be committed!
     * 
     * @throws Exception
     */
    protected void doPreTest() throws Exception {
    }
    
    /**
     * Perform transactional test cleanup which will be committed!
     * 
     * @throws Exception
     */
    protected void doPostTest() throws Exception {
    }

    /**
     * @see org.springframework.test.AbstractTransactionalDataSourceSpringContextTests#onTearDownAfterTransaction()
     */
    @Override
    protected void onTearDownAfterTransaction() throws Exception {
    	setDefaultRollback(false);
    	startNewTransaction();
        try {
        	doPostTest();
        } finally {
        	endTransaction();
        	setDefaultRollback(true);
        }
    }
    
    /**
     * Commit current transaction and start a new transaction.
     *
     */
    protected void doCommit() {
        setComplete();
    	endTransaction();
    	startNewTransaction();
    }
    
    protected String[] concatStrings( String[] array1, String[] array2 ){
    	String[] combined = new String[array1.length+array2.length];
    	for( int i = 0; i < array1.length; i++ ) {
    		combined[i] = array1[i];
    	}
    	for( int i = 0; i < array2.length; i++ ) {
    		combined[array1.length + i] = array2[i];
    	}
    	return combined;
    }
    
    
}

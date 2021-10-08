package base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import stepDefinitions.AbstractTest;

public class AbstractAssertion<T extends FunctionalLibrary>extends AbstractTest {
    protected static final Log logger = LogFactory.getLog(AbstractAssertion.class);

    protected T functionalLibrary;

    public T endAssertion() {
        return functionalLibrary;
    }

    public void setPage(T funtionalLibrary) {
        this.functionalLibrary = funtionalLibrary;
    }
}

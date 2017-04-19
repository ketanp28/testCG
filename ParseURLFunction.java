
package blackberry.utils;

import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import blackberry.utils.URL.URLObject;

public final class ParseURLFunction extends ScriptableFunctionBase {

    public static final String NAME = "parseURL";


    public Object execute( Object thiz, Object[] args ) throws Exception {
        return new URLObject( args[ 0 ].toString() );
    }


    protected FunctionSignature[] getFunctionSignatures() {
        FunctionSignature fs = new FunctionSignature( 1 );
        fs.addParam( String.class, true );
        return new FunctionSignature[] { fs };
    }
}


package blackberry.push;

import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;


class ClosePushListenerFunction extends ScriptableFunctionBase {


    protected Object execute2( Object thiz, Object[] args ) throws Exception {
        if( args != null && args.length > 0 ) {
            int port = ( (Integer) args[ 0 ] ).intValue();
            PushService.getInstance().closePushChannel( port );
        } else {
            PushService.getInstance().closePushChannel();
        }
        return UNDEFINED;
    }


    protected FunctionSignature[] getFunctionSignatures() {
        FunctionSignature fs = new FunctionSignature( 1 );
        fs.addParam( Integer.class, false );
        return new FunctionSignature[] { fs };
    }
}

package blackberry.push;

import net.rim.device.api.script.ScriptableFunction;
import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import blackberry.identity.transport.TransportObject;


class OpenPushListenerFunction extends ScriptableFunctionBase {


    protected Object execute( Object thiz, Object[] args ) throws Exception {
        int maxQueueCap = -1;
        if( args.length > 3 ) {
            maxQueueCap = ( (Integer) args[ 3 ] ).intValue();
        }

        PushService.getInstance().openPushChannel( ( (Integer) args[ 1 ] ).intValue(), (ScriptableFunction) args[ 0 ],
                maxQueueCap );
        return UNDEFINED;
    }


    protected void validateArgs( Object[] args ) {
        super.validateArgs( args );

        int port = ( (Integer) args[ 1 ] ).intValue();
        if( port < 0 ) {
            throw new IllegalArgumentException( "Invalid port." );
        } else if( !PushService.isValidPort( port ) ) {
            throw new IllegalArgumentException( "Reserved port" );
        }
    }

 
    protected FunctionSignature[] getFunctionSignatures() {
        FunctionSignature fs = new FunctionSignature( 4 );
        fs.addParam( ScriptableFunction.class, true );
        fs.addParam( Integer.class, true );
        fs.addParam( TransportObject.class, false );
        fs.addParam( Integer.class, false );
        return new FunctionSignature[] { fs };
    }
}
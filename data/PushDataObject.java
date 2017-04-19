
package blackberry.push.data;

import blackberry.common.push.PushData;
import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import blackberry.core.WidgetBlob;
import net.rim.device.api.script.Scriptable;


public class PushDataObject extends Scriptable {


    public static final int ACCEPT = 0;
    public static final int DECLINE_USERDCR = 1;
    public static final int DECLINE_USERDCU = 2;
    public static final int DECLINE_USERPND = 3;
    public static final int DECLINE_USERREQ = 4;
    public static final int DECLINE_USERRFS = 5;

    private static final String DECLINE_USERDCR_VALUE = "DECLINE_USERDCR";
    private static final String DECLINE_USERDCU_VALUE = "DECLINE_USERDCU";
    private static final String DECLINE_USERPND_VALUE = "DECLINE_USERPND";
    private static final String DECLINE_USERREQ_VALUE = "DECLINE_USERREQ";
    private static final String DECLINE_USERRFS_VALUE = "DECLINE_USERRFS";
    private static final String ACCEPT_VALUE = "ACCEPT";


    private static final String PROPERTY_IS_CHANNEL_ENCRYPTED = "isChannelEncrypted";
    private static final String PROPERTY_PAYLOAD = "payload";

    private static final String FUNCTION_GET_HEADER_FIELD = "getHeaderField";
    private static final String FUNCTION_GET_REQUEST_URI = "getRequestURI";
    private static final String FUNCTION_GET_SOURCE = "getSource";

    private PushData _pushData;

    public PushDataObject( PushData pushData ) {
        _pushData = pushData;
    }

    public Object getField( String name ) throws Exception {
        if( name.equals( ACCEPT_VALUE ) ) {
            return new Integer( ACCEPT );
        } else if( name.equals( DECLINE_USERDCR_VALUE ) ) {
            return new Integer( DECLINE_USERDCR );
        } else if( name.equals( DECLINE_USERDCU_VALUE ) ) {
            return new Integer( DECLINE_USERDCU );
        } else if( name.equals( DECLINE_USERPND_VALUE ) ) {
            return new Integer( DECLINE_USERPND );
        }

        return super.getField( name );
    }


    private Object parsePayload( byte[] payload ) {
        return new WidgetBlob( payload );
    }

    private class GetHeaderFieldFunction extends ScriptableFunctionBase {

        protected Object execute( Object thiz, Object[] args ) throws Exception {
            if( args[ 0 ] instanceof Integer ) {
                return _pushData.getHeaderField( ( (Integer) args[ 0 ] ).intValue() );
            } else if( args[ 0 ] instanceof String ) {
                return _pushData.getHeaderField( (String) args[ 0 ] );
            }
            return UNDEFINED;
        }

        
    }


    private class GetRequestURIFunction extends ScriptableFunctionBase {

        protected Object execute( Object thiz, Object[] args ) throws Exception {
            return _pushData.getRequestURI();
        }
    }


    private class GetSourceFunction extends ScriptableFunctionBase {

        protected Object execute( Object thiz, Object[] args ) throws Exception {
            return _pushData.getSource();
        }
    }
}

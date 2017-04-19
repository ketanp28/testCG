
package blackberry.utils;

import net.rim.device.api.system.DeviceInfo;

import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;

import blackberry.common.util.StringUtilities;
import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import blackberry.core.WidgetBlob;


public final class DocumentToBlobFunction extends ScriptableFunctionBase {

    public static final String NAME = "documentToBlob";
    public static final String DEFAULT_ENCODING = "UTF-16BE";


    public Object execute( Object thiz, Object[] args ) throws Exception {
        String versionString = DeviceInfo.getSoftwareVersion();
        if( versionString.length() == 0 ) { 
            return UNDEFINED;
        } else {
            int versionNumber = Integer.parseInt( ( StringUtilities.split( versionString, "." ) )[ 0 ] );
            if( versionNumber > 5 ) { 
                return UNDEFINED;
            } else {
                Document dom = (Document) args[ 0 ];
                String domStr = ( (DOMImplementationLS) dom.getImplementation() ).createLSSerializer().writeToString( dom );
                String encoding = ( dom.getInputEncoding() == null ) ? DEFAULT_ENCODING : dom.getInputEncoding();
                byte[] data = domStr.getBytes( encoding );
                return new WidgetBlob( data );
            }
        }
    }


    
}
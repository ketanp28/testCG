
package blackberry.utils;

import net.rim.device.api.io.Base64OutputStream;
import blackberry.core.Blob;
import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;


public final class BlobToStringFunction extends ScriptableFunctionBase {

    public static final String NAME = "blobToString";

    private static final String BASE64_ENCODING = "BASE64";
    private static final String UTF8_ENCODING = "UTF-8";

    public Object execute( Object thiz, Object[] args ) throws Exception {
        byte[] data = ( (Blob) ( args[ 0 ] ) ).getBytes();

        String encoding = null;
        if( args.length == 2 ) {
            encoding = args[ 1 ].toString();
        }

        if( encoding == null ) {
            return new String( data );
        }

        if( encoding.equalsIgnoreCase( BASE64_ENCODING ) ) {
            byte[] encoded = Base64OutputStream.encode( data, 0, data.length, false, false );
            String encodedStr = new String( encoded, UTF8_ENCODING );
            return encodedStr;
        }

        return new String( data, encoding );
    }


    protected FunctionSignature[] getFunctionSignatures() {
        FunctionSignature fs = new FunctionSignature( 2 );
        fs.addParam( Blob.class, true );
        fs.addParam( String.class, false );
        return new FunctionSignature[] { fs };
    }
}
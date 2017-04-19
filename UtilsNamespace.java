
package blackberry.utils;

import java.util.Hashtable;

import net.rim.device.api.script.Scriptable;


public class UtilsNamespace extends Scriptable {

    private Hashtable _fields;


    public UtilsNamespace() {
        super();
        _fields = new Hashtable();
        _fields.put( GenerateUniqueIdFunction.NAME, new GenerateUniqueIdFunction() );
        _fields.put( DocumentToBlobFunction.NAME, new DocumentToBlobFunction() );
        _fields.put( ParseURLFunction.NAME, new ParseURLFunction() );
        
    }


    public Object getField( String name ) throws Exception {
        Object field = _fields.get( name );
        if( field == null ) {
            return super.getField( name );
        }
        return field;
    }
}

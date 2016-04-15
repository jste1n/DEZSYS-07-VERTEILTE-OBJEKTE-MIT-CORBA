package helloworld;


/**
 * Generated from IDL interface "Echo".
 *
 * @author JacORB IDL compiler V 3.7
 * @version generated at Apr 11, 2016 1:32:39 PM
 */

public abstract class EchoPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, helloworld.EchoOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "echoString", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:helloworld/Echo:1.0"};
	public helloworld.Echo _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		helloworld.Echo __r = helloworld.EchoHelper.narrow(__o);
		return __r;
	}
	public helloworld.Echo _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		helloworld.Echo __r = helloworld.EchoHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // echoString
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				java.lang.String tmpResult1 = echoString(_arg0);
_out.write_string( tmpResult1 );
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}

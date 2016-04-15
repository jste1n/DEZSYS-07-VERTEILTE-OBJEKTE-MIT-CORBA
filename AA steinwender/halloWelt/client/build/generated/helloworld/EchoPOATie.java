package helloworld;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Echo".
 *
 * @author JacORB IDL compiler V 3.7
 * @version generated at Apr 11, 2016 1:32:39 PM
 */

public class EchoPOATie
	extends EchoPOA
{
	private EchoOperations _delegate;

	private POA _poa;
	public EchoPOATie(EchoOperations delegate)
	{
		_delegate = delegate;
	}
	public EchoPOATie(EchoOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public EchoOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(EchoOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public java.lang.String echoString(java.lang.String mesg)
	{
		return _delegate.echoString(mesg);
	}

}

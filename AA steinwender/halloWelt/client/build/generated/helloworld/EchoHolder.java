package helloworld;

/**
 * Generated from IDL interface "Echo".
 *
 * @author JacORB IDL compiler V 3.7
 * @version generated at Apr 11, 2016 1:32:39 PM
 */

public final class EchoHolder	implements org.omg.CORBA.portable.Streamable{
	 public Echo value;
	public EchoHolder()
	{
	}
	public EchoHolder (final Echo initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return EchoHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = EchoHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		EchoHelper.write (_out,value);
	}
}

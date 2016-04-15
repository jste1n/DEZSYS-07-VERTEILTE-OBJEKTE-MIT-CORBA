package helloworld;


/**
 * Generated from IDL interface "Echo".
 *
 * @author JacORB IDL compiler V 3.7
 * @version generated at Apr 11, 2016 1:32:39 PM
 */

public abstract class EchoHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(EchoHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:helloworld/Echo:1.0", "Echo");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final helloworld.Echo s)
	{
			any.insert_Object(s);
	}
	public static helloworld.Echo extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:helloworld/Echo:1.0";
	}
	public static Echo read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(helloworld._EchoStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final helloworld.Echo s)
	{
		_out.write_Object(s);
	}
	public static helloworld.Echo narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof helloworld.Echo)
		{
			return (helloworld.Echo)obj;
		}
		else if (obj._is_a("IDL:helloworld/Echo:1.0"))
		{
			helloworld._EchoStub stub;
			stub = new helloworld._EchoStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static helloworld.Echo unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof helloworld.Echo)
		{
			return (helloworld.Echo)obj;
		}
		else
		{
			helloworld._EchoStub stub;
			stub = new helloworld._EchoStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}

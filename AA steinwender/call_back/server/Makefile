CXX            	= /usr/bin/g++
CPPFLAGS      	= -g -c
LDFLAGS       	= -g
OMNI_HOME       = /home/jstone/opt/omniORB
OMNIIDL       	= $(OMNI_HOME)/build/bin/omniidl
LIBS          	=  -lomniORB4 -lomnithread -lomniDynamic4
OBJECTS       	= echo_callbackSK.o cb_server.o
IDL_DIR		= ../idl
IDL_FILE	= $(IDL_DIR)/echo_callback.idl
LD_LIBRARY_PATH =  $(OMNI_HOME)/lib
all server: $(OBJECTS)
	$(CXX) $(LDFLAGS) -o cb_server cb_server.o echo_callbackSK.o $(LIBS)

cb_server.o: cb_server.cc
	$(CXX) $(CPPFLAGS) cb_server.cc -I.

echo_callbackSK.o: echo_callbackSK.cc echo_callback.hh
	$(CXX) $(CPPFLAGS) echo_callbackSK.cc -I.

echo_callbackSK.cc: $(IDL_FILE)
	$(OMNIIDL) -bcxx $(IDL_FILE)

run: cb_server
	# Start Naming service with command 'omniNames -start -always' as root
	./cb_server -ORBInitRef NameService=corbaname::localhost

clean clean-up:
	rm -rf *.o
	rm -rf *.hh
	rm -rf *SK.cc
	rm -rf cb_server

package backend;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ZaehlerContainer {
	
	private static ZaehlerContainer myInstance = null;
	
	public static ZaehlerContainer getInstance()
	{
		if( myInstance == null )
		{
			myInstance = new ZaehlerContainer();
		}
		
		return myInstance;
	}
	
	protected Map<Long, Zaehler> container;
	
	protected AtomicLong idGen;
	
	private ZaehlerContainer()
	{
		this.container = new HashMap<Long, Zaehler>();
		this.idGen = new AtomicLong();
	}
	
	public long save( Zaehler zaehler )
	{
		final long nextId = this.idGen.getAndIncrement();
		
		zaehler.setId(nextId);
		this.container.put(nextId, zaehler);
		
		return nextId;
	}
	
	public Collection<Zaehler> values()
	{
		return this.container.values();
	}
	
	
	public Zaehler load( long id )
	{
		return this.container.get(id);
	}
}

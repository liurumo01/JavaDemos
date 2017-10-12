package designpattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker
{
	private List<Memento> menentoList = new ArrayList<Memento>();
	
	public void add(Memento state)
	{
		menentoList.add(state);
	}
	
	public Memento get(int index)
	{
		return menentoList.get(index);
	}
}

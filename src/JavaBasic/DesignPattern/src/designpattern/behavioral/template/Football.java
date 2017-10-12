package designpattern.behavioral.template;

public class Football extends Game
{
	void endPlay()
	{
		System.out.println("Football Game Finished!");
	}
	
	void initialize()
	{
		System.out.println("Football Game Initialized! Start playing.");
	}
	
	void startPlay()
	{
		System.out.println("Football Game Started! Enjoy the game!");
	}
}

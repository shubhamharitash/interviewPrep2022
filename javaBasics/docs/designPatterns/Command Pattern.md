#### Definition
The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations.

![[Command Pattern-1674334306818.jpeg]]

#### Using Null Object
![[Command Pattern-1674335790394.jpeg]]
Even null has its uses 😄

#### Notes
[Aditya's Notebook](https://1drv.ms/u/s!Atzh_D_Amn0niEHmYaJ9mPf4shhh?e=3Iauga)

#### Undo Button In RemoteControl
Before moving to complex commands, lets first add undo button in light command

**Step 1**
```java
public interface Command{
	public void execute();
	public void undo();
}
```

**Step 2**
```java
public class LightOnCommand implements Command{
	Light light;
	public LightOnCommand(Light light){
		this.light = light;
	}
	public void execute(){
		light.on();
	}
	public void undo(){
		light.off();
		/*
		Since execute() -> light on
			  undo() -> light off
		because undo() is meant to reverse the last applied effect.
		*/
	}
}
```

**Step 3**
```java
public class RemoteControlWithUndo{
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	public RemoteControlWithUndo(){
		Arrays.fill(onCommands, noCommand);
		Arrays.fill(offCommands, noCommand);
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCommand, Command offCommand){
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonPressed(int slot){
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
	public void offButtonPressed(int slot){
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	public void undoButtonPressed(){
		undoCommand.undo();
	}
	public static toString(){
		// toString code
	}
}
```

###### Handling undo in Ceiling Fan
CeilingFan code
![[Command Pattern-1674380789245.jpeg]]

**For constructing relevant commands**
HelperFunctionsForCommand
```java
public class CeilingFanUtility{
	public static void undoSpeed(int prevSpeed, CeilingFan ceilingFan){
		if(prevSpeed == CeilingFan.HIGH)
			ceilingFan.high();
		else if(prevSpeed == CeilingFan.MEDIUM)
			ceilingFan.medium();
		else if(prevSpeed == CeilingFan.LOW)
			ceilingFan.low();
		else if(prevSpeed == CeilingFan.OFF)
			ceilingFan.off();
	}
}
```

CeilingFanLowCommand
```java
public class CeilingFanLowCommand implements Command{
	CeilingFan ceilingFan;
	int prevSpeed;
	
	public CeilingFanLowCommand(CeilingFan ceilingFan){
		this.ceilingFan = ceilingFan;
	}

	public void execute(){
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.low();
	}

	public void undo(){
		CeilingFanUtility.undoSpeed(prevSpeed, ceilingFan);
	}
}
```

#### Using MacroCommand

Here, we can also create a command which is capable of calling other commands

```java
public class MacroCommand implements Command{
	Command[] commands;
	public MacroCommand(Command[] commands){
		this.commands = commands;
	}

	public void execute(){
		Intstream.range(0, commands.length).forEach(
			e -> {
				commands[e].execute();
			}
		)
	}

	public void undo(){
		for(int i= command.length-1; i>=0; i--){
			commands[i].execute();
		}
	}
}
```

Code to use this macrocommand
```java
public static void main(){
	// creating all devices reqd
	Light light = new Light("Living Room");
	TV tv = new TV("Living Room");
	Stereo stereo = new Stereo("Living Room");
	Hottub hottun = new Hottub();

	LightOnCommand lightOn = new LightOnCommand(light);
	StereoOnCommand stereoOn = new StereoOnCommand(stereo);
	TVOnCommand tvOn = new TVOnCommand(tv);
	HottubOnCommand hottubOn = new HottubOnCommand(hottub);

	/*
	Similiar commands for off
	*/

	// creating Macrocommands
	Commands[] onCommands = {lightOn, stereoOn, tvOn, hottubOn};
	Commands[] offCommands = {lightOff, stereoOff, tvOff, hottubOff};

	// Set remoteControl
	Remote remoteControl = new RemoteControl();
	remoteControl.setCommand(0, new MacroCommand(onCommands), new MacroCommand(oddCommands) );

	// Testing remote
	System.out.println(remoteControl);
	remoteControl.onButtonWasPushed(0);
	remoteControl.offButtonWasPushed(0);
}
```

#### Reducing Command Classes in CommandPattern
Using Command Pattern, we create a lot of small classes(Concrete implementations of command to provide required functionality)

###### Is this really required?
Nope. With lambda expressions we can simplify things easy.

Let's take light example
```java
public static void main(){
	Light light = new Light("Living Room");
	RemoteControl remoteControl = new RemoteControl();
	remoteControl.setCommand(0, () -> light.on(), () -> light.off());
}
```

this can further be simplified using method references
```java
public static void main(){
	Light light = new Light("Living Room");
	RemoteControl remoteControl = new RemoteControl();
	remoteControl.setCommand(0, light::on, light::off);
}
```

we can also do multiple things if required
```java
	Command stereoOnWithCD = () -> {
		stereo.on();
		stereo.setCD();
		stereo.setVolume();
	}
	remoteControl.setCommand(0, stereoOnWithCD, stereo::off);
```

###### Refactored code with lambda expression
![[Command Pattern-1674384873627.jpeg]]

![[Command Pattern-1674384892799.jpeg]]

#### Use Cases of Command Pattern
###### Queuing requests
Since our job queue classes are totally decoupled from the objects that are doing computation, we can easily queue up requests and call **execute()** for each request.

###### Logging requests
Sometimes we need to be able to recover from a crash. For that we introduce store() and load() functionality in our Command interface so that we can store the sequence of actions performed, then load and execute them in batch in sequence.

![[Command Pattern-1674385922004.jpeg]]



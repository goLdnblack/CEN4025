package todo;

public class Activity 
{
	String taskName;
	String description;
	
	public Activity() {}

	public Activity(String taskName, String description)
	{
		this.taskName = taskName;
		this.description = description;
	}

	public void setTask(String task)
	{
		this.taskName = task;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String print()
	{
		return (taskName + ": " + description);
	}


}

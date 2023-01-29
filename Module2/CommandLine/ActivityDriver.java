import java.util.Scanner;

public class ActivityDriver 
{
	static ActivityList list = new ActivityList();

	public static void activityManager()
	{
		Scanner sc = new Scanner(System.in);
		String exit = "";
		String activity, description;
		String newActivity, newDesc;
		//sc.nextLine();

		System.out.println("How would you like to name your to do list?");
		list.setListName(sc.nextLine());

		while (!exit.equals("exit"))
		{
			System.out.println("----------------------------\nTo Do Activity List\n" +
			"----------------------------");

			System.out.println("List Name: " + 
			(list.listname == null ? "(Empty list)" : list.listname));

			System.out.println("/// Activities /// ");
			list.show();

			System.out.println("\nSelect number option or enter exit");
			System.out.println("1. Add task\n2. Modify task\n3. Delete task");

			exit = sc.nextLine();

			if (exit.equals("exit"))
			{
				// Program terminates
			}
			else
			{
				int choice = Integer.parseInt(exit);

				switch (choice)
				{
					case 1:
						System.out.println("What is the name of the activity?");
						activity = sc.nextLine();
						System.out.println("What is the description for the activity?");
						description = sc.nextLine();
						list.add(activity, description);
						break;
					case 2:
						System.out.println("Which activity to modify?");
						activity = sc.nextLine();
						System.out.print("New activity name: ");
						newActivity = sc.nextLine();
						System.out.println("New description: ");
						newDesc = sc.nextLine();
						list.modifyTask(activity, newActivity);
						list.modifyDescription(newActivity, newDesc);
						break;
					case 3:
						System.out.println("Which activity to remove?");
						activity = sc.nextLine();
						list.remove(activity);
						break;
					default:
					System.out.println("Invalid choice.\n");
						break;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		activityManager();
	}
}

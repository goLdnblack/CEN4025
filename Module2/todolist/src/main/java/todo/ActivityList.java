package todo;

import java.util.ArrayList;

class ActivityList
{
    // Each list contains activities for that
    // specific list
    String listname;
    ArrayList<Activity> list = new ArrayList<>();

    public ActivityList() {}

    public ActivityList(String listname)
    {
        this.listname = listname;
    }

    public Activity search(String activity)
    {
        for (Activity task : list)
        {
            if (task.taskName.equals(activity))
                return task;
        }

        return null;
    }

    public void setListName(String name)
    {
        this.listname = name;
    }

    public void add(String activity, String description)
    {
        Activity task = new Activity(activity, description);
        list.add(task);
    }

    public void remove(String activity)
    {
        Activity task = search(activity);

        if (task != null)
            list.remove(task);
    }

    public void modifyTask(String original, String activity)
    {
        Activity task = search(original);

        if (task == null)
        {
            System.out.println("No activity found in list.");
        }
        else
        {
            task.setTask(activity);
        }
    }

    public void modifyDescription(String activity, String description)
    {
        Activity task = search(activity);

        if (task == null)
        {
            System.out.println("No activity found in list.");
        }
        else
        {
            task.setDescription(description);
        }
    }

    public void show()
    {
        for (Activity task : list)
        {
            System.out.println(task.print());
        }
    }
}
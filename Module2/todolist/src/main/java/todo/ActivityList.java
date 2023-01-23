package todo;

import java.util.ArrayList;

class ActivityList
{
    ArrayList<String> list = new ArrayList<>();

    public ActivityList() {}

    public void add(String activity)
    {
        list.add(activity);
    }

    public void remove(String activity)
    {
        list.remove(activity);
    }

    public void modify(String original, String activity)
    {
        int i = list.indexOf(original);
        list.set(i, activity);
    }

    public void show()
    {
        int count = 0;
        System.out.println("To Do List");

        for (String a : list)
            System.out.println(++count + ". " + a);
    }
}
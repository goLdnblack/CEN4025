package todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimaryController 
{

    ArrayList<ActivityList> manager = new ArrayList<>();
    ObservableList<String> allActivity = FXCollections.observableArrayList();

    @FXML
    TabPane tabList;

    TextInputDialog tdList = new TextInputDialog("Enter List Name");

    TextInputDialog tdActivity = new TextInputDialog("Enter Activity Name");

    TextInputDialog tdDescription = new TextInputDialog("Enter a description");

    @FXML
    private void switchToSecondary() throws IOException 
    {
        ActivityManager.setRoot("secondary");
    }

    @FXML
    private void newTabList() throws IOException
    {
        Tab tab = new Tab();
        tab.setText(List1.listname);
        tabList.getTabs().add(tab);
    }

    public ActivityList checkList(String list)
    {
        for (ActivityList a : manager)
        {
            if (list.equals(a.listname))
            {
                return a;
            }
        }

        return null;
    }

    private void showList(ActivityList taskList, Tab t)
    {
        allActivity.clear();

        for (Activity a : taskList.list)
        {
            allActivity.add(a.print());
        }

        ListView<String> activities = new ListView<String>();
        activities.setItems(allActivity);
        t.setContent(activities);
    }

    @FXML
    private void newActivity() throws IOException
    {
        String list;
        Optional<String> result = tdList.showAndWait();

        if (result.isPresent())
        {
            
            list = tdList.getEditor().getText();

            ActivityList taskList;

            // Check if the list exists
            // and there are no empty lists
            while ((taskList = checkList(list)) == null 
            && (tabList.getTabs() != null))
            {
                System.out.println("Enter an existing list name");
                result = tdList.showAndWait();
                list = tdList.getEditor().getText();

                if (!result.isPresent())
                    break;
            }

            if (result.isPresent())
            {
                String activity;
                result = tdActivity.showAndWait();
    
                if (result.isPresent())
                {
                    activity = tdActivity.getEditor().getText();
        
                    String desc;
                    result = tdDescription.showAndWait();
    
                    if (result.isPresent())
                    {
                        desc = tdDescription.getEditor().getText();
            
                        for (Tab t : tabList.getTabs())
                        {
                            if(list.equals(t.getText()))
                            {
                                // Add the activity and description
                                taskList.add(activity, desc);
                                
                                // Call function to reprint list
                                //allActivity.add(taskList.search(activity).print());
                                //t.setContent(new CheckBox(taskList.search(activity).print()));
                                
                                showList(taskList, t);
                                
                                //ListView<String> activities = new ListView<String>();
                                //activities.setItems(allActivity);
                                //t.setContent(activities);
                                
                                
                                //System.out.println(t.getContent());
                                //t.setContent(new ListView<String>().);
                                //t.get
                            }
                        }
                    }
                }
            }
        }
    }

    @FXML
    private void getContent()
    {
        System.out.println(tabList.getTabs());
    }

    @FXML
    private void newList() throws IOException
    {
        Tab tab = new Tab();
        Optional<String> result = tdList.showAndWait();

        if (result.isPresent())
        {
            // New List
            manager.add(new ActivityList(tdList.getEditor().getText()));

            tab.setText(tdList.getEditor().getText());
            tabList.getTabs().add(tab);
        }
        else
        {

        }

    }
}

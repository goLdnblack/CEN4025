import java.io.File;
import java.io.IOException;

public class DirectoryTraversal
{

	// Print the data structure recursively
	public static void recurPrintTrie(Node head, String indent, String subfolder)
	{
		// Print the indent level of node

		head.printNode(indent, subfolder);

		// Next level below
		//if (head.folders.size() != 0)
		//	System.out.print("|\n");
		
		for (Node n : head.folders)
		{
			//System.out.print(indent + "");
			recurPrintTrie(n, (indent + "|_"), (subfolder + " |"));
		}
	}

	public static Node buildTrie(String filepath) throws IOException
	{

		// Current directory content
		File dir = new File(filepath);


		// Create node for current folder
		Node n = new Node(dir.getName());

		long size = 0;
		int files = 0;

		File[] f = dir.listFiles();

		// Assign current folder number of files
		// and size of files
		for (File file : f)
		{

			if (file.isDirectory())
			{
				// Call buildTrie with new child node
				n.insertNode(buildTrie(file.getAbsolutePath().toString()));

			}
			else
			{
				// Store file size to total
				size += file.length();
				files++;
			}

		}

		// Finish creating Node
		n.setTotalSize(size);
		n.setFileCount(files);

		return n;
	}

	public static void main(String[] args)
	{
		String userDir = args[0];
		//int userDir = -1;
		
		// Check if file/folder exists
		try
		{
			File file = new File(userDir);
			
			if (!(file.exists()))
			{
				System.out.println("Directory/File does not exist.");
			}
			else
			{
				Node head = buildTrie(userDir);

				recurPrintTrie(head, "", "|");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		// Print folder directory
		// /home/pi/Documents/Valencia2023/Fall/CEN4802
		
		//printTrie();
	}
}

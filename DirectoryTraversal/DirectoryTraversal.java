// Jesus Sanchez-Rivera
// CEN 4025
// Prof Walauskis
// January 16, 2023

import java.io.File;
import java.io.IOException;

public class DirectoryTraversal
{
	// Print the data structure recursively
	public static void printTrie(Node head, StringBuilder indent, StringBuilder subfolder)
	{
		// Call each node's print function
		head.printNode(indent.toString(), subfolder.toString());

		// Next level below
		for (Node n : head.folders)
		{
			// Adjust indent level each time printTrie
			// is called
			printTrie(n, indent.append("|_"), subfolder.append(" |"));
			indent.setLength(indent.length() - 2);
			subfolder.setLength(subfolder.length() - 2);
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

		// Assign folder nodes, file count and
		// file sizes
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
				// Build first node as the head of the
				// data structure
				Node head = buildTrie(userDir);
				
				// Print the data structure with characters
				// to help indent the output
				StringBuilder indent = new StringBuilder("");
				StringBuilder subfolder = new StringBuilder("|");
				printTrie(head, indent, subfolder);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

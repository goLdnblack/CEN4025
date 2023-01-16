import java.util.ArrayList;

class Node
{
	int fileCount;
	long totalSize;
	String folderName;
	ArrayList<Node> folders = new ArrayList<>();

	// Default constructor
	public Node(){ }

	public Node(String folderName)
	{
		this.folderName = folderName;
	}

	public void setFileCount(int count)
	{
		this.fileCount = count;
	}

	public int getFileCount()
	{
		return this.fileCount;
	}

	public void setTotalSize(long size)
	{
		this.totalSize = size;
	}

	public long getTotalSize()
	{
		return this.totalSize;
	}

	public void setFolderName(String name)
	{
		this.folderName = name;
	}

	public String getFolderName()
	{
		return this.folderName;
	}

	public void insertNode(Node n)
	{
		folders.add(n);
	}

	// Print each node's data
	public void printNode(String indent, String subfolder)
	{
		System.out.print(indent + "*Folder*: " + this.folderName +
						"\n" + indent + "File count: " + this.fileCount +
						"\n" + indent + "Combined file size: " + this.totalSize + " kb");
		
		// Formatting
		if (folders.size() == 0)
		{
			System.out.println();
		}
		else
		{
			System.out.println("\n" + subfolder);
		}
	}
}

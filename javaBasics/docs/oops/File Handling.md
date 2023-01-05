##  Resources
[Constructing File and Directory Paths using File and Paths classes](https://www.happycoders.eu/java/how-to-construct-file-and-directory-names-with-file-path-paths/)

## File class
The File class contains the methods for obtaining the properties of a file/directory and for renaming and deleting a file/directory.

The File class contains the methods for obtaining file and directory properties and for renaming and deleting files and directories. However, the File class does not contain the methods for reading and writing file contents.

![[File Handling-1672807931884.jpeg]]
#### Doubts
> How can we directory and file paths, irrespective of OS?
> Ans: using System.getProperty to get some common paths
> 	Example
> 		System.getProperty("user.dir")
> 		System.getProperty("user.home")
> 		System.getProperty("java.io.tmpdir")

![[File Handling-1672811921298.jpeg]]

#### Using Paths
![[File Handling-1672818298706.jpeg]]
###### For nesting
![[File Handling-1672818412634.jpeg]]

###### For constructing relative paths
![[File Handling-1672818726019.jpeg]]
![[File Handling-1672818858411.jpeg]]

#### Text I/O

###### PrintWriter
**PrintWriter** is used to write content to a declared file.
![[File Handling-1672823690175.jpeg]]

![[File Handling-1672823652843.jpeg]]

###### Scanner
![[File Handling-1672823903938.jpeg]]
![[File Handling-1672824171844.jpeg]]
![[File Handling-1672824198414.jpeg]]

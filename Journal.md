# Journal

Phase 1 — The base case is the situation where recursion stops and doesn't call itself again. In my countFilesRecursive() method, my base case is if (item instanceof FileItem) return 1;.
The if statement checks whether the item is a FileItem, and when it is a FileItem, the method returns 1. The general case is the situation where the method continues by looking at smaller pieces of the structure. In my countFilesRecursive() method, it is the int fileCount = 0;, where you start the counter, the for-each loop where you go through the items inside the folder, and the recursive call uses countFilesRecursive() on each child.
The recursive call operates on a smaller part of the structure because each call only looks at one item inside the current folder. Eventually, it reaches a file, which is the base case and stops the recursion.

Phase 2 -
When findLargestFileRecursive() gets a folder that only has empty subfolders, the recursive calls keep going through the folders until there are no files. Since there is no file, the method returns null. Returning null is a good way to show that no file was found. In the general case, the method checks if the result is not null before trying to compare the file sizes. This prevents a NullPointerException because the program does not try to use getSizeInKB() on a null value. If there is a file, it compares the size to the current largest file and updates it if needed.

# Journal

Phase 1 — The base case is the situation where recursion stops and doesn't call itself again. In my countFilesRecursive() method, my base case is if (item instanceof FileItem) return 1;.
The if statement checks whether the item is a FileItem, and when it is a FileItem, the method returns 1. The general case is the situation where the method continues by looking at smaller pieces of the structure. In my countFilesRecursive() method, it is the int fileCount = 0;, where you start the counter, the for-each loop where you go through the items inside the folder, and the recursive call uses countFilesRecursive() on each child.
The recursive call operates on a smaller part of the structure because each call only looks at one item inside the current folder. Eventually, it reaches a file, which is the base case and stops the recursion.

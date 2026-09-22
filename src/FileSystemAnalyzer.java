public class FileSystemAnalyzer {
    public static int countFilesRecursive(FileSystemItem item) {


    if (item instanceof FileItem) 
        return 1;

    int fileCount = 0;

for (FileSystemItem child : ((Folder) item).getItems()) {
    fileCount += countFilesRecursive(child); 
    }
    return fileCount;

}

public static int calculateTotalSizeRecursive(FileSystemItem item) {
    if (item instanceof FileItem)  
        return item.getSizeInKB();

    int totalSize = 0;

    for (FileSystemItem child : ((Folder) item).getItems()) {
        totalSize += calculateTotalSizeRecursive(child);
    
    }
    return totalSize;
}

public static FileItem findLargestFileRecursive(FileSystemItem item) {
    if (item instanceof FileItem)
        return (FileItem) item;

    FileItem largestFile = null;

    for (FileSystemItem child : ((Folder)item).getItems()){
        FileItem childLargFile = findLargestFileRecursive(child);
    if (childLargFile != null && 
    (largestFile == null || childLargFile.getSizeInKB() > largestFile.getSizeInKB())) {
    largestFile = childLargFile;
}
        
    }

    return largestFile;
} 
}
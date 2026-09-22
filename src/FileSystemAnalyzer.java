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

}
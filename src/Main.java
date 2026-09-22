public class Main {
    public static void main(String[] args) {
    
        Folder root = new Folder("Root");
        Folder pictures = new Folder ("Pictures");
        Folder vacation = new Folder ("Vacations");
        FileItem beach = new FileItem("beach.jpg", 500);
        FileItem renfair = new FileItem("renFair.jpg", 600);

        root.addItem(pictures);
        pictures.addItem(vacation);
        vacation.addItem(beach);
        vacation.addItem(renfair);
       
        int fileCount = FileSystemAnalyzer.countFilesRecursive(root);
        System.out.println("Total files: " + fileCount);

        int totalSize = FileSystemAnalyzer.calculateTotalSizeRecursive(root);
        System.out.println("Total Size: " + totalSize);

        FileItem largestFile = FileSystemAnalyzer.findLargestFileRecursive(root);
        System.out.println("Largest File:" + largestFile.getName());
        System.out.println("Largest File Size: " + largestFile.getSizeInKB() + " KB");

    }
}
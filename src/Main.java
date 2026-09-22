import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        Folder root = new Folder("Root");
        Folder pictures = new Folder("Pictures");
        Folder vacation = new Folder("Vacations");
        FileItem beach = new FileItem("beach.jpg", 500);
        FileItem renfair = new FileItem("renFair.jpg", 600);

        root.addItem(pictures);
        pictures.addItem(vacation);
        vacation.addItem(beach);
        vacation.addItem(renfair);
       
        boolean running = true;
        while (running) {
            System.out.println("\n--- File System Inspector---");
            System.out.println("1. Display File System Structure");
            System.out.println("2. Add File to a Folder");
            System.out.println("3. Add Subfolder");
            System.out.println("4. Run Recursive Audit");
            System.out.println("5. Run Iterative Audit & Verification");
            System.out.println("6. Exit");
        
            System.out.print("Enter your choice: ");

            int choice;

            try {
             choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
             System.out.println("Invalid choice. Please enter a number from 1-6.");
              continue; 
                } 
            
            switch (choice) {
                case 1: 
                printHierarchy(root, "");
                break;

                case 2:
                System.out.print("Enter file name: ");
                String fileName = scanner.nextLine();

                System.out.print("Enter file size in KB: ");
                
                int fileSize;

                try {
                    fileSize = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid file size. Please enter a number.");
                    break;
                }

                if (fileSize < 0) {
                System.out.println("File size cannot be negative.");
                break;
                }

                System.out.print("Enter target folder name: ");
                String targetFolderName = scanner.nextLine();

                Folder targetFolder = findFolder(root, targetFolderName);

                 if (targetFolder == null) {
                 System.out.println("Folder not found.");
                break;
                 }
                targetFolder.addItem(new FileItem(fileName, fileSize));
                System.out.println("File added successfully.");
                break;
                
                case 3:
                System.out.print("Enter new subfolder name: ");
                String newFolderName = scanner.nextLine();

                System.out.print("Enter target parent folder name: ");
                String parentFolderName = scanner.nextLine();

                Folder parentFolder = findFolder(root, parentFolderName);

                if (parentFolder == null) {
                System.out.println("Folder not found.");
                break;
                }

                parentFolder.addItem(new Folder(newFolderName));
                System.out.println("Subfolder added successfully.");
                    break;
                    
                case 4:
                int fileCount = FileSystemAnalyzer.countFilesRecursive(root);
                System.out.println("Total files: " + fileCount);

                int totalSize = FileSystemAnalyzer.calculateTotalSizeRecursive(root);
                System.out.println("Total Size: " + totalSize + " KB");

                FileItem largestFile = FileSystemAnalyzer.findLargestFileRecursive(root);

                if (largestFile != null) {
                System.out.println("Largest File: " + largestFile.getName());
                System.out.println("Largest File Size: " + largestFile.getSizeInKB() + " KB");
                } else {
                System.out.println("No files found.");
                    }
                    break;

                case 5:
                int recursiveCount = FileSystemAnalyzer.countFilesRecursive(root);
                int iterativeCount = FileSystemAnalyzer.countFilesIterative(root);

                System.out.println("Iterative total files: " + iterativeCount);

                if (recursiveCount == iterativeCount) {
                System.out.println("Both methods return the same file count.");
                } else {
                System.out.println("File counts do not match.");
                }
                    break;

                case 6:
                     running = false;
                     System.out.println("Exiting.....");
                     break;

                default:
                    System.out.println("Invalid choice. Please enter 1-6.");
                    

            }

        }
    }
        public static void printHierarchy(FileSystemItem item, String indent) {
    if (item instanceof Folder) {
        Folder folder = (Folder) item;
        System.out.println(indent + folder.getName() + "/");

        for (FileSystemItem child : folder.getItems()) {
            printHierarchy(child, indent + "  ");
        }
    } else {
        System.out.println(indent + item.getName() + " (" + item.getSizeInKB() + " KB)");
    }
}
public static Folder findFolder(Folder current, String targetName) {
    if (current.getName().equalsIgnoreCase(targetName)) {
        return current;
    }

    for (FileSystemItem child : current.getItems()) {
        if (child instanceof Folder) {
            Folder found = findFolder((Folder) child, targetName);

            if (found != null) {
                return found;
            }
        }
    }

    return null;
}
}

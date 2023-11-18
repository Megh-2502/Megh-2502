import java.io.*;
import java.util.*;

class Resume {
    private String name;
    private String email;
    private String phoneNumber;
    private String dob;
    private String institute;
    private String yearofPassing;
    private String course;
    private Long experience;
    private ArrayList<String> skills;
    private ArrayList<String> project;
    private String summary;

    public Resume() {

    }

    public Resume(String name, String email, String phoneNumber, String dob, String institute, String yearofPassing,
            String course, Long experience, ArrayList<String> skills, ArrayList<String> project, String summary) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.institute = institute;
        this.yearofPassing = yearofPassing;
        this.course = course;
        this.experience = experience;
        this.skills = skills;
        this.project = project;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getYearofPassing() {
        return yearofPassing;
    }

    public void setYearofPassing(String yearofPassing) {
        this.yearofPassing = yearofPassing;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getexperience() {
        return experience;
    }

    public void setexperience(Long experience) {
        this.experience = experience;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public ArrayList<String> getProject() {
        return project;
    }

    public void setProject(ArrayList<String> project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}

class ResumeFileHandler {
    public String filePath;

    public ResumeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void saveResumesToFile(Resume resume) throws IOException {
        // FileHandler filesResume=new FileHandler();
        try {
            File f = createnewfile(resume.getName() + ".txt");
            // filesResume.saveResumes(resume,resume.getName()+".txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(resume.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = resume.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(resume.getName() + "\n");
            writer.write(resume.getEmail() + "\n");
            writer.write(resume.getPhoneNumber() + '\n');
            writer.write(resume.getCourse() + '\n');
            writer.write(resume.getInstitute() + '\n');
            writer.write(resume.getYearofPassing() + '\n');
            writer.write('\n');
            writer.write("Skills:");
            for (String skill : resume.getSkills()) {
                writer.write(skill + ",");
            }
            writer.write('\n');
            writer.write("Projects:");
            for (String projects : resume.getProject()) {
                writer.write(projects + ",");
            }
            writer.write('\n');
            writer.write("Summary" + '\n');
            writer.write(resume.getSummary() + '\n');
        }
    }

    File createnewfile(String string) {
        return null;
    }

    public ArrayList<String> getAllResumeNames() {
        ArrayList<String> resumeNames = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return resumeNames;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resumeNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resumeNames;
    }

    public void loadResumes(String filePath) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        }

    }

    void deletefile(String path) {
        try {
            File myObj = new File(path);
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the folder.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting the file: " + e.getMessage());
        }
    }

    public ArrayList<Resume> resumes = ResumeManager.resumes;
    /*
     * public void displayAllResumes() {
     * System.out.println("-----existing resumes in AL-----");
     * for (Resume resume : resumes) {
     * System.out.println(resume.getName());
     * }
     * }
     */
}

class ResumeManager {
    public static ArrayList<Resume> resumes = new ArrayList<>();
    private ResumeFileHandler fileHandler;

    public ResumeManager(ResumeFileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void addResumeToAL(Resume resume) {
        resumes.add(resume);
        try {
            fileHandler.saveResumesToFile(resume);
        } catch (IOException e) {
        }
    }

    public void deleteResumeFromAL(String name) {
        Resume toRemove = null;
        for (Resume obj : resumes) {
            if (obj.getName().equalsIgnoreCase(name)) {
                toRemove = obj;
                break;
            }
        }

        if (toRemove != null) {
            resumes.remove(toRemove);
            // Update the list of resume names
            ArrayList<String> resumeNames = fileHandler.getAllResumeNames();
            resumeNames.remove(name);
            updatefilePath(resumeNames);
        } else {
            System.out.println("No resume found with the given name.");
        }
    }

    private void updatefilePath(ArrayList<String> resumeNames) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileHandler.filePath))) {
            for (String name : resumeNames) {
                writer.write(name);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateResume(String name, Resume newResume) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getName().equalsIgnoreCase(name)) {
                resumes.set(i, newResume);
                return;
            }
            System.out.println("No resume found with the given name.");
        }

    }

    /*
     * public void displayAllResumes() {
     * System.out.println("-----existing resumes-----");
     * for (Resume resume : resumes) {
     * System.out.println(resume.getName());
     * }
     * }
     */

    public Resume getResumeByName(String name) {
        for (Resume resume : resumes) {
            if (resume.getName().equalsIgnoreCase(name)) {
                System.out.println("resume present!!");
                return resume;
            } else {
                System.out.println("resume not present!!");
            }
        }
        return null;
    }

}

public class Resume06 {
    private static Scanner sc = new Scanner(System.in);
    private static ResumeManager resumeManager;
    private static ResumeFileHandler fileHandler;
    public static String rlist = "resume_list.txt";

    public static void main(String[] args) throws IOException {
        fileHandler = new ResumeFileHandler(rlist);
        resumeManager = new ResumeManager(fileHandler);
        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add a resume");
            System.out.println("2. Delete a resume");
            System.out.println("3. Update a resume");
            System.out.println("4. Display a resume");
            System.out.println("5. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.println("---from resumelist.txt---");
                    dis_list(rlist);
                    addResume();
                    break;
                case 2:
                    System.out.println("---from resumelist.txt---");
                    dis_list(rlist);
                    deleteResume();
                    break;
                case 3:
                    System.out.println("---from resumelist.txt---");
                    dis_list(rlist);
                    updateResume();
                    break;
                case 4:
                    // fileHandler.displayAllResumes();
                    System.out.println("---from resumelist.txt---");
                    dis_list(rlist);
                    System.out.println("Display particluar resume?(yes/no): ");
                    String dis = sc.next();
                    if (!dis.equalsIgnoreCase("yes")) {
                        break;
                    }
                    System.out.println("Enter the name of the person whose resume you want to display:");
                    String nameToDisplay = sc.next() + ".txt";
                    dis_list(nameToDisplay);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }

    private static void addResume() {
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email address:");
        String email = sc.nextLine();
        System.out.print("Enter Phone Number:");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Date of Birth:");
        String dob = sc.nextLine();
        System.out.print("Enter university name :");
        String institute = sc.nextLine();
        System.out.print("Year of Passing: ");
        String yearOfPassing = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        System.out.print("Enter years of experience:");
        Long experience = sc.nextLong();

        ArrayList<String> skills = new ArrayList<>();
        System.out.println("Enter skills (or 'done' to exit):");
        while (true) {
            String skill = sc.nextLine();
            if (skill.equalsIgnoreCase("done")) {
                break;
            }
            skills.add(skill);
        }

        ArrayList<String> projects = new ArrayList<>();
        System.out.println("Enter projects (or 'done' to exit):");
        while (true) {
            String project = sc.nextLine();
            if (project.equalsIgnoreCase("done")) {
                break;
            }
            projects.add(project);
        }

        System.out.println("Summary: ");
        String summary = sc.next();

        Resume resume1 = new Resume(name, email, phoneNumber, dob, institute, yearOfPassing, course, experience, skills,
                projects, summary);
        resumeManager.addResumeToAL(resume1);
        System.out.println("Resume added successfully.");
    }

    private static void deleteResume() {
        System.out.println("Enter name of person whose resume you want to delete: ");
        String delName = sc.nextLine() + ".txt";
        try {
            fileHandler.deletefile(delName);
            resumeManager.deleteResumeFromAL(delName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        del_list(delName);
        System.out.println("Resume deleted successfully.");
    }

    private static void del_list(String fname) {
        try {
            File obj = new File(fname);
            if (obj.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(rlist))) {
                    String line;
                    BufferedWriter writer = new BufferedWriter(new FileWriter(rlist));
                    while ((line = reader.readLine()) != null) {
                        if (!line.equals(fname)) {
                            writer.write(line);
                            writer.flush();
                        }

                    }
                    writer.close();
                    reader.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateResume() throws IOException {
        /*
         * System.out.
         * println("Enter the name of the person whose resume you want to update:");
         * String nameToUpdate = sc.nextLine();
         * String up = nameToUpdate + ".txt";
         * BufferedReader reader1 = new BufferedReader(new FileReader(up));
         * Resume existingResume = resumeManager.getResumeByName(nameToUpdate);
         * String line;
         */
        System.out.println("Enter the name of the person whose email you want to update:");
        String nameToUpdate = sc.nextLine() + ".txt";
        Resume existingResume = resumeManager.getResumeByName(nameToUpdate);
        if (existingResume != null) {
            int upchoice;
            do {
                System.out.println("Choose an option:");
                System.out.println("1. Update name");
                System.out.println("2. Update email");
                System.out.println("3. Update phone number");
                System.out.println("4. Update date of birth");
                System.out.println("5. Update institute");
                System.out.println("6. Update year of passing");
                System.out.println("7. Update course");
                System.out.println("8. Update experience");
                System.out.println("9. Update skills");
                System.out.println("10. Update projects");
                System.out.println("11. Update summary");
                System.out.println("12. Return to main menu");

                upchoice = sc.nextInt();
                sc.nextLine();

                switch (upchoice) {
                    case 1:
                       /* System.out.print("Enter old name: ");
                        String oldName = sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldName)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldName, newName);
                            }
                        }
                        existingResume.setName(newName);
                        */
                        break;
                    case 2:
                        /*System.out.print("Enter old Email: ");
                        String oldEmail = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldEmail)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldEmail, newEmail);
                                System.out.println("CHECK");
                            }
                        }
                        // reader1.close();
                        existingResume.setEmail(newEmail);*/
                        if (existingResume != null) {
                            System.out.print("Enter new email: ");
                            String newEmail = sc.nextLine();
                            existingResume.setEmail(newEmail);
                    
                            // Read all lines from the file, updating the email line
                            BufferedReader reader1 = new BufferedReader(new FileReader(nameToUpdate));
                            ArrayList<String> updatedLines = new ArrayList<>();
                            String line;
                            while ((line = reader1.readLine()) != null) {
                                if (line.contains("Email:")) {
                                    line = "Email: " + existingResume.getEmail();
                                }
                                updatedLines.add(line);
                            }
                            reader1.close();
                    
                            // Write the updated lines back to the file, overwriting the old data
                            BufferedWriter writer = new BufferedWriter(new FileWriter(nameToUpdate));
                            for (String updatedLine : updatedLines) {
                                writer.write(updatedLine);
                                writer.newLine();
                            }
                            writer.close();
                    
                            // Update the resume in the manager after the email change
                            resumeManager.updateResume(nameToUpdate, existingResume);
                            System.out.println("Email updated successfully.");
                        } else {
                            System.out.println("Resume not found.");
                        }
                    
                    
                        break;
                    case 3:
                        /*System.out.print("Enter old phone number: ");
                        String oldPhoneNumber = sc.nextLine();
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldPhoneNumber)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldPhoneNumber, newPhoneNumber);
                            }
                        }
                        existingResume.setPhoneNumber(newPhoneNumber);*/
                        break;
                    case 4:
                        /*System.out.print("Enter old date of birth: ");
                        String oldDob = sc.nextLine();
                        System.out.print("Enter new date of birth: ");
                        String newDob = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldDob)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldDob, newDob);
                            }
                        }
                        existingResume.setDob(newDob);*/
                        break;
                    case 5:
                        /*System.out.print("Enter old institute: ");
                        String oldInstitute = sc.nextLine();
                        System.out.print("Enter new institute: ");
                        String newInstitute = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldInstitute)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldInstitute, newInstitute);
                            }
                        }
                        existingResume.setInstitute(newInstitute);*/
                        break;
                    case 6:
                        /*System.out.print("Enter old year of passing: ");
                        String oldYearOfPassing = sc.nextLine();
                        System.out.print("Enter new year of passing: ");
                        String newYearOfPassing = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldYearOfPassing)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldYearOfPassing, newYearOfPassing);
                            }
                        }
                        existingResume.setYearofPassing(newYearOfPassing);*/
                        break;
                    case 7:
                        /*System.out.print("Enter old course: ");
                        String oldCourse = sc.nextLine();
                        System.out.print("Enter new course: ");
                        String newCourse = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldCourse)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldCourse, newCourse);
                            }
                        }
                        existingResume.setCourse(newCourse);*/
                        break;
                    case 8:
                        /*System.out.print("Enter old years of experience: ");
                        String oldExperience = sc.nextLine();
                        System.out.print("Enter new years of experience: ");
                        String newExperience = sc.nextLine();
                        while ((line = reader1.readLine()) != null) {
                            // Check if the line contains the old value that you want to replace.
                            if (line.contains(oldExperience)) {
                                // Replace the old value with the new value.
                                line = line.replace(oldExperience, newExperience);
                            }
                        }
                        Long newExperience1 = Long.parseLong(newExperience);
                        existingResume.setexperience(newExperience1);*/
                        break;
                    case 9:
                        /*ArrayList<String> newSkills = new ArrayList<>();
                        System.out.println("Enter new skills (or 'done' to exit):");
                        while (true) {
                            String skill = sc.nextLine();
                            if (skill.equalsIgnoreCase("done")) {
                                break;
                            }
                            newSkills.add(skill);
                        }
                        existingResume.setSkills(newSkills);*/
                        break;
                    case 10:
                        ArrayList<String> newProjects = new ArrayList<>();
                        System.out.println("Enter new projects (or 'done' to exit):");
                        while (true) {
                            String project = sc.nextLine();
                            if (project.equalsIgnoreCase("done")) {
                                break;
                            }
                            newProjects.add(project);
                        }
                        existingResume.setProject(newProjects);
                        break;
                    case 11:
                        System.out.print("Enter new summary: ");
                        String newSummary = sc.nextLine();
                        existingResume.setSummary(newSummary);
                        break;
                    case 12:
                        resumeManager.updateResume(nameToUpdate, existingResume);
                        return; // Return to the main menu
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (upchoice != 12);
        }else

    {
        System.out.println("Resume not found.");
    }
    }

    private static void dis_list(String fname) {
        try {
            File obj = new File(fname);
            if (obj.exists()) {
                System.out.println("File " + fname + " exists as follows: ");
                fileHandler.loadResumes(fname);
            } else {
                System.out.println("File " + fname + " doesn't exist!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * private static void displayResume(){
     * System.out.println();
     * System.out.
     * println("Enter the name of the person whose resume you want to display:");
     * String nameToDisplay = sc.nextLine();
     * Resume resumeToDisplay = resumeManager.getResumeByName(nameToDisplay);
     * if (resumeToDisplay != null) {
     * System.out.println("------------ Resume ------------");
     * System.out.println("Name: " + resumeToDisplay.getName());
     * System.out.println("Email: " + resumeToDisplay.getEmail());
     * System.out.println("Phone Number: " + resumeToDisplay.getPhoneNumber());
     * System.out.println("Date of Birth: " + resumeToDisplay.getDob());
     * System.out.println("Summary: " + resumeToDisplay.getSummary());
     * System.out.println("Years of Experience: " +
     * resumeToDisplay.getexperience());
     * System.out.println("Institute: " + resumeToDisplay.getInstitute());
     * System.out.println("Year of Passing: " + resumeToDisplay.getYearofPassing());
     * System.out.println("Course: " + resumeToDisplay.getCourse());
     * 
     * System.out.println("------ Skills ------");
     * for (String skill : resumeToDisplay.getSkills()) {
     * System.out.println(skill);
     * }
     * System.out.println("------ Projects ------");
     * for (String project : resumeToDisplay.getProject()) {
     * System.out.println(project);
     * }
     * } else {
     * System.out.println("No resume found for the given name.");
     * }
     * }
     */

}

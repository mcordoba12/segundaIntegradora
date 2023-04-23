package model;
public class GreenSQA {

    private Project[] projects;
    private String html = "";

    public GreenSQA() {
        projects = new Project[10];
    }

    /**
     * Creates a new project with the given information and adds it to the project list.
     * @param nameProject the project's name
     * @param nameClient the project's name
     * @param dateStart the start date of the project in the format "dd/mm/yyyy"
     * @param dateEnd  the start date of the project in the format "dd/mm/yyyy".
     * @param budget  the project budget
     * @param nameManager  the name of the project manager
     * @param pManager  the project manager's phone number
     * @param dIn  an array with the start dates of each stage in "dd/mm/yyyy" format
     * @param dEnd an array with the end dates of each step in "dd/mm/yyyy" format
     * @return a string indicating whether the project was registered or not.
     */
    public String createProject(String nameProject, String nameClient, String dateStart, String dateEnd, double budget,
            String nameManager, String pManager, String[] dIn, String[] dEnd) {
        String menssage = "";
        boolean flag = false;
        String[] x = dateStart.split("/");
        String[] y = dateEnd.split("/");
        Project obj = new Project(nameProject, nameClient,
                new Date(Integer.valueOf(x[0]), Integer.valueOf(x[1]), Integer.valueOf(x[2])),
                new Date(Integer.valueOf(y[0]), Integer.valueOf(y[1]), Integer.valueOf(y[2])), budget, nameManager,
                pManager);
        boolean existe = validateC(obj);
        if (existe) {
            menssage = "el proyecto ya existe";
        } else {
            for (int i = 0; i < projects.length && flag == false; i++) {
                if (projects[i] == null) {
                    projects[i] = obj;
                    createStage(obj, dIn, dEnd);
                    flag = true;
                }
            }

            if (flag == true) {
                menssage = "Registered.";
            } else {
                menssage = "No registration, because The list is full";
            }
        }
        return menssage;
    }

    /**
     * Validates whether a project already exists. 
     * @param newProject the new project to validate.
     *  @returns true if the project already exists, false otherwise.
     */
    public boolean validateC(Project newProject) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null && projects[i].getNameProject().equalsIgnoreCase(newProject.getNameProject())) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Creates the stages of a project based on the provided start and end dates of dateIn and dateEnd respectively.
     * @param projectName the name of the project whose stages are being created.
     * @param dateIn an array containing the start dates of each stage.
     * @param dateEnd an array containing the end dates of each stage.
     */

    public void createStage(Project projectName, String[] dateIn, String[] dateEnd) {
        for (int i = 0; i < TypeStage.values().length; i++) {
            String[] x = dateIn[i].split("/");
            String[] y = dateEnd[i].split("/");
            DateStage date = new DateStage(
                    new Date(Integer.valueOf(x[0]), Integer.valueOf(x[1]), Integer.valueOf(x[2])),
                    new Date(Integer.valueOf(y[0]), Integer.valueOf(y[1]), Integer.valueOf(y[2])));
            projectName.getStages()[i] = new Stage(TypeStage.values()[i], date);
            

        }
    }

    /**
     * Returns a string representation of all projects and their stages with capsules.
     * @return A string with project names, stages and capsules.
     */

    public String viewProjects() {
        String x = "";
        for (int i = 0; i < projects.length; i++) {
            x += projects[i].getNameProject() + "\n    ";
            for (int j = 0; j < projects[i].getStages().length; j++) {
                Stage y = projects[i].getStages()[j];
                x += y.getStagesType().name() + "\n    ";
                for (int k = 0; k < y.getCapProject().length; k++) {
                    Capsule cap = y.getCapProject()[k];
                    x += cap.getId() + " " + cap.getDescription() + " " + cap.getLearnedLessons() + "\n";
                }
            }
        }
        return x;
    }

    /**
     * Find and return the active stage of a specific project.
     * @param projectName the name of the project for which you want to find the active stage.
     * @return the active stage of the project or null if not found.
     */
    public Stage findActiveStage(String projectName) {
        Stage x = null;

        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null && projects[i].getNameProject().equalsIgnoreCase(projectName)) {
                for (int j = 0; j < projects[i].getStages().length; j++) {
                    if (projects[i].getStages()[j].isActive()) {
                        x = projects[i].getStages()[j];
                    }
                }
            }
        }
        return x;
    }

    /**
     * Register a new capsule in the active phase of a given project.
     * @param projectName the name of the project in which to register the capsule.
     * @param id the id of the capsule to register
     * @param description the description of the capsul
     * @param type the type of the capsule to be recorded (must be a valid CapsuleType value)
     * @param learning the learning outcomes of the capsule
     * @param nameCollaborator  the name of the collaborator who created the capsule
     * @param cargoCollaborator the position of the collaborator
     * @return a String indicating the result of the registration process
     */

    public String registerCapsule(String projectName, String id, String description, String type, String learning, String nameCollaborator, String cargoCollaborator ) {
        String x = "No register capsule";
        Capsule cap = new Capsule( id, description, CapsuleType.valueOf(type) ,learning, nameCollaborator,cargoCollaborator);
        for (int i = 0; i < projects.length - 1; i++) {
            if (!(projects[i] == null)) {
                Stage stage = findActiveStage(projectName);
                if (!(projects[i] == null) && projects[i].getNameProject().equalsIgnoreCase(projectName)) {
                    if (stage != null) {
                    stage.registerCapsule(cap);
                    x= "registered capsule";
                    }
                }
            }
        }
        return x;
    }

    /**
     * Terminates the current stage of a project with the given stage name and type.
     * @param projectName  the name of the project to end a stage.
     * @param stageType  the type of stage to terminate.
     * @return a String indicating whether the operation was successful or not.
     */
    public String finishStage(String projectName, String stageType) {
        String x = "";
        for (int i = 0; i < projects.length - 1; i++) {
            if (!(projects[i] == null)) {
                Project proj = projects[i];
                if (proj.getNameProject().equalsIgnoreCase(projectName)) {
                    proj.changeStage(stageType);
                    x="finish Stage";
                } else {
                    x = "The project does not exist";
                }
            }
        }
        return x;
    }

    /**
     * Approves a capsule with the specified hashtag for the given project and stage.
     * @param projectName  the name of the project
     * @param name the stage name
     * @param hashtag the hashtag of the capsule 
     * @return a message indicating whether the capsule was approved or not
     */

    public String approvedCap(String projectName, String name, String hashtag){
        String msg_1= "Capsula No Aprovada";
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null && projects[i].getNameProject().equalsIgnoreCase(projectName)) {
                for (int j = 0; j < projects[i].getStages().length; j++) {
                    if (projects[i].getStages()[j].getStagesType().equals(TypeStage.valueOf(name))) {
                        for (int k = 0; k < projects[i].getStages()[j].getCapProject().length; k++) {
                            if (projects[i].getStages()[j].getCapProject()[k].getHashtag().equals(hashtag)){
                                projects[i].getStages()[j].getCapProject()[k].setAproved(true);
                                msg_1="Capsula Aprovada";
                            }
                        }

                    }
                 }
            }   
        }
        return msg_1;
    }

    /**
     * Publish a capsule in a specific project and stage.
     * @param projectName The name of the project where the capsule will be published.
     * @param name The stage type where the capsule will be published.
     * @param url The URL of the capsule to publish.
     * @param id The ID of the capsule to publish.
     * @return A message indicating whether the capsule has been published successfully or not.
     */
    public String publishCapsule(String projectName, String name,String url, String id){
        String msg_2= "Capsula no encontrada";
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null &&projects[i].getNameProject().equalsIgnoreCase(projectName)) {
                for (int j = 0; j < projects[i].getStages().length; j++) {
                        for (int k = 0; k < projects[i].getStages()[j].getCapProject().length; k++) {
                            if (projects[i].getStages()[j].getCapProject()[k].getId().equals(id)){
                                msg_2="Capsula publicada";
                                projects[i].getStages()[j].getCapProject()[k].setUrl(url);
                                projects[i].getStages()[j].getCapProject()[k].setPublished(true);
                            } 
                    }
                 }
            }   
            
        }
        return msg_2;

    }

    /**
     * Calculates the number of capsules of a specific type in all projects and their stages.
     * @param typeIndex The index of the capsule type to be counted.
     * @return The total number of capsules of the specified type
     */
    public int calculateCapsule(int typeIndex){
        int suma=0;

        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                Stage[] x= projects[i].getStages();
                for (int j = 0; j < x.length; j++) {
                    Capsule[] ky= x[j].getCapProject();
                    for (int k = 0; k < ky.length; k++) {
                        if (ky[k] != null) {
                            if (ky[k].getType() == CapsuleType.values()[typeIndex-1]) {
                                suma++;
                                
                            }
                            
                        }
                    }
                }
                
            }
        }
        return suma;
    }

    /**
     * Returns a string with lessons learned from all projects in a specified stage.
     * @param typeStage Integer representing the stage type of the project.
     * @return containing lessons learned from projects in the specified stage.
     */
    public String showlessonsLearned(int typeStage){
        int u = 1;
        String message= "";
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                Stage[] x= projects[i].getStages();
                    Capsule[] ky= x[typeStage-1].getCapProject();
                    for (int k = 0; k < ky.length; k++) {
                        if (ky[k] != null) {
                            message += u + ". " + ky[k].getLearnedLessons() + "\n";
                        }
                    }
                
            }
        }
        return message;
    }


    /**
     * Returns a string showing the available capsule types.
     * @return containing the capsule types.
     */
    public String printTypeCapsule(){
        String mensaje="";
        CapsuleType[] capsule = CapsuleType.values();
        for (int i = 1; i < capsule.length; i++) {
            mensaje += i + ". " + capsule[i] + "\n";
        }
        return mensaje;
    }

    /**
     * Returns a string showing the available stage types.
     * @return containing the stage types.
     */
    public String printTypeStage(){
        String mensaje="";
        TypeStage[] stages = TypeStage.values();
        for (int i = 1; i < stages.length; i++) {
            mensaje += i + ". " + stages[i] + "\n";
        }
        return mensaje;
    }

    /**
     * Returns a string showing the existing projects.
     * @return containing the names of the projects.
     */
    public String printPrjects(){
        String mensaje="";
        for (int i = 0; i < projects.length; i++) {
            if( projects[i] != null){
                mensaje += i + ". " +  projects[i].getNameProject() + "\n";
            }
        }
        return mensaje;
    }

    /**
     * Returns a string showing the project with the most capsules registered.
     * @return containing the name of the project with the most capsules registered.
     */
    public String  projectMostRegisteredCapsules(){
        String message= "";
        int temp=0;
        Project temp1= null;
        for (int i = 0; i < projects.length ; i++) {
            int c = 0;
            if (projects[i] != null) {
                c = countingCapsules();
            }

            if (c > temp) {
                temp1 = projects[i];
                temp = c;
            }
        }
        if (temp1 == null) {
            message= "No hay proyectos";
            return message;
        }

        message= "Es " + temp1.getNameProject();
    
        return message;
    }

    /**Count the total number of capsules registered in all projects.
     * @return  Integer representing the number of capsules registered.
     */
    public int countingCapsules(){
        int numCapsulas = 0;
        for (int i = 0; i < projects.length; i++) {
            if(projects[i] != null){
             for (int j = 0; j < projects[i].getStages().length; j++) {
                Capsule [] y= projects[i].getStages()[j].getCapProject();
                for (int k = 0; k < y.length ; k++) {
                    if (y != null) {
                        numCapsulas++;   
                    }
                }
                }
           }
        }
        return numCapsulas;
    }

    /**
     * Checks if the name of a collaborator is registered in any of the capsules.
     * @param name Name of the collaborator to search for.
     * @return  Boolean value indicating whether the contributor's name was found (true) or not (false).
     */
    public boolean nameCollaboratorCapsule(String name) {
        for (int i = 0; i < projects.length; i++) {
            if(projects[i] != null){
                for (int j = 0; j < projects[i].getStages().length; j++) {
                   Capsule [] y= projects[i].getStages()[j].getCapProject();
                   for (int k = 0; k < y.length ; k++){
                    if (y[k] != null) {
                        if( y[k].getNameCol().equalsIgnoreCase(name)){
                            return true;

                        }
                    }
                   }
                }
            }
        }
        return false;
    }

    /**
     *  Return lessons learned from all capsules containing the indicated hashtag, as long as they have been published and approved.
     * @param hashtag  the hashtag to search for in the capsules.
     * @return a String with all the lessons learned found separated by line breaks.
     */
    public String lessonnlearned(String hashtag){
        String mes= "";
        for (int i = 0; i < projects.length; i++) {
            if(projects[i] != null){
                for (int j = 0; j < projects[i].getStages().length; j++) {
                   Capsule [] y= projects[i].getStages()[j].getCapProject();
                   for (int k = 0; k < y.length ; k++){
                    if (y[k] != null) {
                        if( y[k].getHashtag().equalsIgnoreCase(hashtag)){
                            if(y[k].isPublished() && y[k].isAproved()){
                                mes += y[k].getLearnedLessons()+ "\n";
                            }
                          }
                        }
                   }
                } 
           }   
       } 
      return mes; 
    }

}



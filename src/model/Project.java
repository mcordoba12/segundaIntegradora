package model;
public class Project {
    private String nameProject;
    private String nameClient;
    private Date dateStart;
    private Date dateEnd;
    private double budget;
    private String nameManager;
    private String phoneManager;
    private Stage[] stages = new Stage [6];

    public Project(String nProject, String nClient, Date dStart, Date dEnd, double pre, String nManager, String pManager) {
        nameProject= nProject; 
        nameClient= nClient; 
        dateStart = dStart; 
        dateEnd = dStart;
        budget= pre;
        nameManager= nManager;
        phoneManager = pManager;
    }


    /**
     * Changes the status of a project stage.
     * @param stageType
     * @return una cadena que indica si la etapa se activó o desactivó
     */
    public String changeStage(String stageType){
        String x = "";
        for (int i = 0; i < stages.length; i++) {
            if(stages[i].getStagesType().equals(stageType)){
                Stage st = stages[i];
                if (st.isActive()) {
                    st.setAprovedStage(true);
                    st.setActive(false);
                    if (!st.equals(stages[stages.length-1])){
                        stages[i+1].setActive(true);
                        stages[i+1].setDateStage(null);
                    } x="active stage";
                } else {
                    x="inactive stage";
                }
                
            }
        }
        return x;   
    }


    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(String phoneManager) {
        this.phoneManager = phoneManager;
    }

    public Stage[] getStages() {
        return stages;
    }

    public void setStages(Stage[] stages) {
        this.stages = stages;
    }

    


}

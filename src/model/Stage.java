package model;

public class Stage {
	private TypeStage stagesType;
	private DateStage dateStage;
	private Capsule[] capProject = new Capsule[50];
	private boolean aprovedStage;
	private boolean active;

	public Stage(TypeStage stagesType, DateStage dateStage) {
		this.stagesType = stagesType;
		this.dateStage = dateStage;
	}

	/**
	 * Register a capsule in the current project.
	 * @param cap the capsule to be registered
	 * @return a message indicating whether the capsule was registered or not
	 */
	public String registerCapsule(Capsule cap){
        String msg="";
		for (int i = 0; i < capProject.length; i++) {
			if (capProject[i] == null) {
				capProject[i] = cap;
				msg = "Registered";
			}
		}
		if (msg == "") {
			msg = "No more capsules can be created";
		}
		return msg;
	}
	
	public String searchWord (String word){

		String chain = "";

		for(int i = 0; i< capProject.length; i++){

			if(capProject[i].getDescription() != null){ // Solo para descripcion, falta el de la leccion, sigue la misma logica.
				
				String [] text = capProject[i].getDescription().split(" ");
				
				for (String string : text) {
					
					if(string.equals(word)){

						chain += capProject[i].getId() + "\n";
						break;
					}
					
				}
			}
			//capProject[i];
		}

		return chain;
	}

	public TypeStage getStagesType() {
		return stagesType;
	}
	public void setStagesType(TypeStage stagesType) {
		this.stagesType = stagesType;
	}
	public DateStage getDateStage() {
		return dateStage;
	}
	public void setDateStage(DateStage dateStage) {
		this.dateStage = dateStage;
	}
	public Capsule[] getCapProject() {
		return capProject;
	}
	public void setCapProject(Capsule[] capProject) {
		this.capProject = capProject;
	}
	public boolean isAprovedStage() {
		return aprovedStage;
	}
	public void setAprovedStage(boolean aprovedStage) {
		this.aprovedStage = aprovedStage;
	}
		
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static void add(Capsule obj_1) {
	}


	public String toString() {
		return stagesType.name();
	}
	
}
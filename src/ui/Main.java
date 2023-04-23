package ui;
import java.util.Scanner;
import model.GreenSQA;
public class Main {

   //// controller
      
   private Scanner lector = new Scanner(System.in);
   private static GreenSQA controller = new GreenSQA();

   public static void main(String args[]) {
      Main main = new Main();
      main.menu();
   }


   public void menu() {
      int counter = 0;
      while (counter != 1) {
         System.out.println("----------------------------------");
         System.out.println("              GREENSQA           ");
         System.out.println("----------------------------------");

         System.out.println("Select the option ");
         System.out.println("1. Create a project ");
         System.out.println("2. Completion of a project stage");
         System.out.println("3. Regiser Capsule");
         System.out.println("4. Approve capsule");
         System.out.println("5. Publish capsule");
         System.out.println("6. Information type the capsule");
         System.out.println("7. information lessons learned");
         System.out.println("8. Project with more capsules");
         System.out.println("9. Report if a collaborator has registered a capsule");
         System.out.println("10. Information on lessons learned that are published and approved");
         System.out.println("11. exit");
         System.out.println("----------------------------------");
         int option = lector.nextInt();
         lector.nextLine();

         switch (option) {
            case 1:
              createProject();
               break;

            case 2:
              completionStage();
               break;

            case 3:
              createCapsule();
               break;

            case 4:
              approvedCapsule();
               break;

            case 5:
              post();
               break;

            case 6:
               informationCapsulasType();
                break;

            case 7:
               informationListSessions();
                break;

            case 8:
               maxCapsule();
                break;

            case 9:
               collaboratorCapsulas();
                break;

            case 10:
               lessonsCapsulesAP();
                break;

            case 11:
               counter = 1;
               System.out.println("Thank you for using the program");
               break;

            default:
               System.out.println("Error");
               break;
         }
      }
   }

    /**
     * Creates a new project and prompts the user to enter information about the project.
     * @return void
     */
   public void createProject(){
      String nameProject;
      String nameClient;
      String dateStart;
      String dateEnd;
      double budget;
      String nameManager;
      String cellManager;

      System.out.println("----------------------------------");
      System.out.println("What is the name of the project? ");
      nameProject = lector.nextLine();
      System.out.println("What is the customer's name? ");
      nameClient = lector.nextLine();
      System.out.println("What is the start date? DD/MM/YY ");
      dateStart = lector.nextLine();
      System.out.println("What is the planned end date? DD/MM/YY ");
      dateEnd = lector.nextLine();
      System.out.println("What is the budget for the project? ");
      budget = lector.nextDouble();
      lector.nextLine();
      System.out.println("What is the name of the manager? ");
      nameManager = lector.nextLine();
      System.out.println("What is the manager's phone number? ");
      cellManager = lector.nextLine();
      String[] datesIn = new String[6];
      String[] datesEnd = new String[6];
      for(int i = 0; i<datesEnd.length; i++){
         System.out.println("What is the planned start date in the stage " + (i+1) + "?");
         datesIn[i] = lector.nextLine();
         System.out.println("What is the planned end date in the stage " + (i+1) + "?");
         datesEnd[i] = lector.nextLine();
      }

      System.out.println(controller.createProject(nameProject, nameClient, dateStart, dateEnd, budget, nameManager, cellManager, datesIn, datesEnd));      
   }

   /**
    * Method to create a new capsule and register it in the system.
    * Prompts the user to enter the information needed to create the capsule.
    * @return void
    */
   public void createCapsule(){
      String id;
      String description;
      String type;
      String nameCollaborator;
      String cargoCollaborator;
      String learning;
      String nameProject;


      System.out.println("----------------------------------");
      System.out.println("Enter the id of the capsule");
      id = lector.nextLine();
      System.out.println("Enter a short description for the capsule ");
      description = lector.nextLine();
      System.out.println("Enter the type for the capsule");
      type = lector.nextLine();
      System.out.println("What is the name of the collaborator? ");
      nameCollaborator = lector.nextLine();
      System.out.println("What is the position of the collaborator ");
      cargoCollaborator = lector.nextLine();
      System.out.println("Write the lesson: ");
      learning = lector.nextLine();
      System.out.println("enter a project name:");
      nameProject= lector.nextLine();


      System.out.println(controller.registerCapsule(nameProject, id, description, type, learning, nameCollaborator, cargoCollaborator ));
   }

   /**
    *  Method to complete a stage of a project.
    * @return void
    */

   public void completionStage(){
      String projectName;
      String  stageType ;

      System.out.println("----------------------------------");
      System.out.println("Enter the name project");
      projectName = lector.nextLine();
      System.out.println("Enter the stage of the project ");
      stageType = lector.nextLine();

      System.out.println(controller.finishStage(projectName, stageType));

   }

   /**
    *  Method for approving a project capsule.
    * @return void
    */
   public void approvedCapsule(){
      String projectName;
      String name ;
      String hashtag;

      System.out.println("----------------------------------");
      System.out.println("Enter the name project");
      projectName = lector.nextLine();
      System.out.println("Enter the name Stage ");
      name = lector.nextLine();
      System.out.println("Enter the hashtag");
      hashtag = lector.nextLine();

      System.out.println(controller.approvedCap(projectName, name, hashtag));
   }

   /**
    *  Method for publishing a capsule in a project.
    * @return void
    */

   public void post(){
      String projectName;
      String url;
      String namecap;
      String id;

      System.out.println("----------------------------------");
      System.out.println("Enter the URL");
      url = lector.nextLine();
      System.out.println("Enter the name project");
      projectName = lector.nextLine();
      System.out.println("Enter the name capsule ");
      namecap = lector.nextLine();
      System.out.println("Enter the ID  ");
      id = lector.nextLine();

      System.out.println(controller.publishCapsule(projectName, namecap,url, id)); 
   }

   public void informationCapsulasType(){
      int type;

      System.out.println("----------------------------------");
      System.out.println("What type of capsule do you want to know how many there are?");
      System.out.println(controller.printTypeCapsule());
      type = lector.nextInt();

      System.out.println("Of this type, there are: " + controller.calculateCapsule(type));
   }

   public void informationListSessions(){
      int typeStage;

      System.out.println("----------------------------------");
      System.out.println("At what stage would you like to consult?");
      System.out.println(controller.printTypeStage());
      typeStage = lector.nextInt();

      System.out.println(controller.showlessonsLearned(typeStage));
   }

   public void maxCapsule() {
      controller.projectMostRegisteredCapsules();
   }

   public void collaboratorCapsulas(){
      String name;

      System.out.println("Enter the name of the collaborator");
      name = lector.nextLine();

      System.out.println("----------------------------------");

      if (controller.nameCollaboratorCapsule(name)) {
         System.out.println("Si");
      } else{
         System.out.println("No");
      }
   
   }

   public void lessonsCapsulesAP(){
      String hashtag;

      System.out.println("Enter a word ");
      hashtag = lector.nextLine();

      controller.lessonnlearned(hashtag);
   }

}
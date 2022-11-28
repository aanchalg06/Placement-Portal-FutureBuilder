import java.util.*;
import java.util.ArrayList;

public class FutureBuilder {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        // ArrayList<Placementcell> allplacement=new ArrayList<>();
        ArrayList<Student> allstudent=new ArrayList<>();
        ArrayList<Company> allcompany=new ArrayList<>();
        int option=0;
        do{
            System.out.println("Welcome to FutureBuilder:\n");
            System.out.println("1) Enter the Application");
            System.out.println("2) Exit the Application");
            option=input.nextInt();
            if (option==1){
                int op1=0;
                do{
                    System.out.println("Choose The mode you want to Enter in:-");
                    System.out.println("    1) Enter as Student Mode");
                    System.out.println("    2) Enter as Company Mode");
                    System.out.println("    3) Enter as Placement Cell Mode");
                    System.out.println("    4) Return To Main Application");
                    op1= input.nextInt();
                    if (op1==1){
                            int op2;
                            do{
                                
                                System.out.println("Choose the Student Query to perform-");
                                System.out.println("    1) Enter as a Student(Give Student Name, and Roll No.)");
                                System.out.println("    2) Add students");
                                System.out.println("    3) Back");
                                op2= input.nextInt();
                        
                                if (op2==1){
                                    String name;
                                    int rollno;
                                    name= input.next();
                                    input.nextLine();
                                    rollno= input.nextInt();

                                    int pos=-1;
                                    for(int stu=0;stu<allstudent.size();stu++){
                                        if(allstudent.get(stu).Rollno()==rollno){
                                            pos=stu;
                                        }
                                    }
                                    if(pos==-1){
                                        System.out.println("No You are not regitered!");
                                        break;
                                    }
                                    int op3=0;
                                    do{
                                    System.out.println("Welcome "+name);
                                    System.out.println("    1)  Register For Placement Drive");
                                    System.out.println("    2)  Register For Company");
                                    System.out.println("    3)  Get All available companies");
                                    System.out.println("    4)  Get Current Status");
                                    System.out.println("    5)  Update CGPA");
                                    System.out.println("    6)  Accept offer");
                                    System.out.println("    7)  Reject offer");
                                    System.out.println("    8)  Back");
                                    op3= input.nextInt();
                                    if (op3==1){
                                        if(pos>=0){
                                        

                                                Student student=new Student();
                                                String time1=input.nextLine();
                                                String time2= student.Ctsr;
                                                // System.out.println(Ctcr);
                                                // apply compareTo()
                                                int value = time1.compareTo(time2);
                                        
                                                // // print LocalDateTime
                                                // System.out.println("Int Value:" + value);
                                        
                                                if (value > 0){
                                                    System.out.println("Registration Closed");
                                                }
                                                else if (value == 0){
                                                    System.out.println(allstudent.get(pos).Name()+" "+"Registered for the Placement Drive at IIITD!!!!");
                                                    System.out.println("Your details are:");
                                                    System.out.println("Name: "+allstudent.get(pos).Name());
                                                    System.out.println("RollNo: "+allstudent.get(pos).Rollno());
                                                    System.out.println("CGPA: "+allstudent.get(pos).CGPA());
                                                    System.out.println("Branch: "+allstudent.get(pos).Branch());
                                                    
                                                    allstudent.get(pos).sreg(1);
                                                }
                                                else{
                                                    
                                                    System.out.println(allstudent.get(pos).Name()+" "+"Registered for the Placement Drive at IIITD!!!!");
                                                    System.out.println("Your details are:");
                                                    System.out.println("Name: "+allstudent.get(pos).Name());
                                                    System.out.println("RollNo: "+allstudent.get(pos).Rollno());
                                                    System.out.println("CGPA: "+allstudent.get(pos).CGPA());
                                                    System.out.println("Branch: "+allstudent.get(pos).Branch());
                                                    allstudent.get(pos).sreg(1);
                                                    
                                                }
                                                input.nextLine();
                                        
                                            }
                                            
                                    }
                                    if (op3==2){
                                        
                                            
                                            int len=allcompany.size();
                                            int count=1;                                                
                                            for (int i=0;i<len;i++){
                                                if (allstudent.get(pos).CGPA()>=allcompany.get(i).CGPA() && allstudent.get(pos).offer()<=3*allcompany.get(i).CTC()){
                                                    System.out.println(count+") "+allcompany.get(i).name());
                                                    count++; 
                                                }
                                                   
                                            }
                                            System.out.println("enter name of company: ");
                                            input.nextLine();
                                            String which=input.nextLine();
                                            int loc;
                                            for (int i=0;i<len;i++){
                                                if (allcompany.get(i).name().compareTo(which)==0){
                                                    if (allstudent.get(pos).offer()<3*allcompany.get(i).CTC() && allstudent.get(pos).CGPA()>=allcompany.get(i).CGPA() && allstudent.get(pos).placed()==0){
                                                        allstudent.get(pos).creg(i);
                                                        allcompany.get(i).companyreg(pos);
                                                        loc =i;
                                                        System.out.println("Successfully Registered for "+allcompany.get(loc).role()+" Role at "+allcompany.get(loc).name()+"!!!!");
                                                    }
                                                }
                                            }
                                            
                                    }
                                    if (op3==3){
                                        Company company=new Company();
                                        company.GetAvailableCompany(allcompany);
                                    }
                                    if (op3==4){
                                        Student student =new Student();
                                        student.getstatus(pos,allstudent,allcompany);
                                    }
                                    if (op3==5){
                                        Student student =new Student();
                                        student.updatecgpa(allstudent,pos);
                                    }
                                    if (op3==6){
                                        Student student =new Student();
                                        student.Acceptoffer(pos,allstudent,allcompany);
                                    }
                                    if (op3==7){
                                        Student student =new Student();
                                        student.Rejectoffer(pos,allstudent,allcompany);
                                    }
                                    }while(op3!=8);
                                    
                                    }
                                if (op2==2){

                                    System.out.println("Number of students to add");
                                    int l;
                                    l= input.nextInt();
                                    input.nextLine();
                                    System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
                                    
                                    for (int k=0;k<l;k++){
                                        
                                        String n= input.nextLine();
                                        int r= input.nextInt();
                                        Double cg= input.nextDouble();
                                        input.nextLine();
                                        String b= input.next();
                                        Student student=new Student(n,r,cg,b);
                                        allstudent.add(student);
                                        input.nextLine();
                                    }
                                }
                            }while(op2!=3);
                        }
                    
                    if (op1==2){
                        int op4;
                        do{
                            
                            System.out.println("Choose the Company Query to perform-");
                            System.out.println("    1) Add Company and Details");
                            System.out.println("    2) Choose Company");
                            System.out.println("    3) Get Available Companies");
                            System.out.println("    4) Back");
                            op4= input.nextInt();
                    
                            if (op4==1){
                                String name=input.next();
                                String role=input.next();
                                Double CTC=input.nextDouble();
                                Double CGPA=input.nextDouble();
                                Company company=new Company(name,role,CTC,CGPA);
                                allcompany.add(company);
                                
                            }
                            if (op4==2){
                                Company company=new Company();
                                int len=allcompany.size();
                                for (int i=0;i<len;i++){
                                    System.out.println(i+1+") "+allcompany.get(i).name());
                                }
                                int which;
                                which= input.nextInt();
                                company.availablecompanies(allcompany,which);
                            }
                            if (op4==3){
                                Company company=new Company();
                                company.GetAvailableCompany(allcompany);
                            }
                        }while(op4!=4);

                    }
                    if (op1==3){
                        int op5;
                        do{
                            
                            System.out.println("Welcome to IIITD Placement Cell");
                            System.out.println("    1) Open Student Registrations");
                            System.out.println("    2) Open Company Registrations");
                            System.out.println("    3) Get Number of Student Registrations");
                            System.out.println("    4) Get Number of Company Registrations");
                            System.out.println("    5) Get Number of Offered/Unoffered/Blocked Students");
                            System.out.println("    6) Get Student Details");
                            System.out.println("    7) Get Company Details");
                            System.out.println("    8) Get Average Package");
                            System.out.println("    9) Get Company Process Results");
                            System.out.println("    10) Back");
                            input.nextLine();
                            op5= input.nextInt();
                    
                            if (op5==1){
                                Student student=new Student();
                                student.StudentRegistrations();
                            }
                            if (op5==2){
                                Company company=new Company();
                                company.CompanyRegistrations();
                            }
                            if (op5==3){
                                Placementcell placementcell=new Placementcell();
                                placementcell.NumberofStudentRegistrations(allstudent);
                            }
                            if (op5==4){
                                Placementcell placementcell=new Placementcell();
                                placementcell.NumberofCompanyRegistrations(allcompany);
                            }
                            if (op5==5){
                                Placementcell placementcell=new Placementcell();
                                placementcell.NumberofOffered_Unoffered_BlockedStudents(allstudent);
                            }
                            if (op5==6){
                                Placementcell placementcell=new Placementcell();
                                placementcell.GetStudentDetails(allstudent);
                            }
                            if (op5==7){
                                Placementcell placementcell=new Placementcell();
                                placementcell.GetCompanyDetails(allcompany,allstudent);
                            }
                            if (op5==8){
                                Placementcell placementcell=new Placementcell();
                                placementcell.GetAveragePackage(allcompany,allstudent);
                            }
                            if (op5==9){
                                Placementcell placementcell=new Placementcell();
                                String compname=input.next();
                                placementcell.GetCompanyProcessResults(allcompany,allstudent,compname);
                            }
                            
                        }while(op5!=10);
                              
                    }

                }while(op1!=4);
            }
        }while(option!=2);
        System.out.println("Thanks For Using FutureBuilder!!!!!");
    }
}





///////////////////////////////////////////////////////////////////////////STUDENT////////////////////////////////////////////////////////////////////////////


class Student{
    private String Name;
    private int Rollno;
    private Double CGPA;
    private String Branch;
    private int count=0;

    private int sreg=0; //if sreg 1 then it is registered in placement drive 
    private int creg=-1;//if creg >-1 means (x) is the pos of company which he applied
    private Double offer=0.0;//if offer =0 means blocked or not placed ,offer =1 means accepted offer
    public static String Otsr;
    public static String Ctsr;
    private int placed=0;
    Student(){

    }
    public void timeofstudent(String otsr,String ctsr){
        Otsr=otsr;
        Ctsr=ctsr;

    }
    Student(String name,int rollno,Double CGPA,String Branch){
        this.Name=name;
        this.Rollno=rollno;
        this.CGPA=CGPA;
        this.Branch=Branch;
    }
    public int placed(){
        return this.placed;
    }    
    public int placed(int a){
        return this.placed=a;
    }
    public String Name(){
        return this.Name;
    }
    //returns the Gap between doses
    public int Rollno(){
        return this.Rollno;
    }
    //returns the number of doses
    public Double CGPA(){
        return this.CGPA;
    }
    public String Branch(){
        return this.Branch;
    }
    public int sreg(){
        return this.sreg;
    }    
    public int sreg(int a){
        return this.sreg=a;
    }
    public int creg(int c){
        return this.creg=c;
    }
    public int creg(){
        return this.creg;
    }
    public Double offer(Double a){
        return this.offer=a;
    }
    public Double offer(){
        return this.offer;
    }
    public int count(){
        return this.sreg;
    }    
    public int count(int c){
        return this.count+=1;
    }

    void StudentRegistrations(){
        Scanner input=new Scanner(System.in);
        System.out.println("Fill in the details:-");
        System.out.println("    1) Set the Opening time for student registrations(yyyy/MM/dd HH:mm:ss)");
        System.out.println("    2) Set the Closing time for student registrations(yyyy/MM/dd HH:mm:ss)");

        String Otsr=input.nextLine();
        String Ctsr=input.nextLine();
        timeofstudent(Otsr, Ctsr);

    }
    void getstatus(int chk,ArrayList<Student> allstudent,ArrayList<Company> allcompany){
        int pos=allstudent.get(chk).creg();
        if (allstudent.get(chk).offer()>0){
            System.out.println("offered"+" offer by "+allcompany.get(pos).name()+"!!");
        }
        else if (allstudent.get(chk).offer()==0){
            System.out.println("unoffered");
        }
        else{
            if (allstudent.get(chk).count()==2){
                System.out.println("blocked");
                allstudent.get(chk).sreg(0);
            }
            
        }
        
    }
    void Acceptoffer(int pos,ArrayList<Student> allstudent,ArrayList<Company> allcompany){
        int cpos=allstudent.get(pos).creg();
        System.out.println("Congratulations "+allstudent.get(pos).Name+"!!! You have accepted the offer by "+allcompany.get(cpos).name()+"!!");
        allstudent.get(pos).placed(1);
        allstudent.get(pos).offer(allcompany.get(cpos).CTC());

    }
    void Rejectoffer(int pos,ArrayList<Student> allstudent,ArrayList<Company> allcompany){
        int cpos=allstudent.get(pos).creg();
        System.out.println(allstudent.get(pos).Name+"!!! You have rejected the offer by "+allcompany.get(cpos).name()+"!!");
        allstudent.get(pos).count(2);
        allstudent.get(pos).placed(0);
        allstudent.get(pos).creg(-1);

    }
    void updatecgpa(ArrayList<Student> allstudent,int loc){
        Scanner inp=new Scanner(System.in);
            Double cgpa=inp.nextDouble();
            allstudent.set(loc, new Student(allstudent.get(loc).Name(),allstudent.get(loc).Rollno(),cgpa,allstudent.get(loc).Branch()));
            return;
    }

}




///////////////////////////////////////////////////////////////////////////COMPANY//////////////////////////////////////////////////////////////
class Company {
    private String role;
    private String name;
    private Double CTC;
    private Double CGPA;
    private int reg=0;
    private int companyreg=-1;
    public static String Otcr;
    public static String Ctcr;
    Scanner inp=new Scanner(System.in);
    Company(){

    }
    Company(String name,String role,Double CTC,Double CGPA){
        this.name=name;
        this.role=role;
        this.CTC=CTC;
        this.CGPA=CGPA;
    }    
    public void time(String otcr,String ctcr){
        Ctcr=ctcr;
        Otcr=otcr;
    }
    public String role(){
        return this.role;
    }

    public String name(){
        return this.name;
    }

    public Double CTC(){
        return this.CTC;
    }
    public Double CGPA(){
        return this.CGPA;
    }
    public int reg(int a){
        return this.reg=a;
    }
    public int reg(){
        return this.reg;
    }
    public int companyreg(int a){
        return this.companyreg=a;
    }
    public int companyreg(){
        return this.companyreg;
    }
        void availablecompanies(ArrayList<Company> allcompany,int which){
            int op;

            do{
                System.out.println("Welcome "+allcompany.get(which-1).name());
                System.out.println("    1) Update Role");
                System.out.println("    2) Update Package");
                System.out.println("    3) Update CGPA criteria");
                System.out.println("    4) Register To Institute Drive");
                System.out.println("    5) Back");
                
                op= inp.nextInt();
                if (op==1){
                    updaterole(allcompany,which-1);
                }
                if (op==2){
                    updatepackage(allcompany,which-1);
                }
                if (op==3){
                    updatecgpa(allcompany,which-1);
                }
                if (op==4){
                    RegisterToInstituteDrive(allcompany,which-1);
                }
                
            }while(op!=5);
            return;
        }
        void updaterole(ArrayList<Company> allcompany,int loc){
            String r=inp.next();

            allcompany.set(loc, new Company(allcompany.get(loc).name(),r,allcompany.get(loc).CTC(),allcompany.get(loc).CGPA()));
            return;
        }
        void updatepackage(ArrayList<Company> allcompany,int loc){

            Double pack=inp.nextDouble();
            allcompany.set(loc, new Company(allcompany.get(loc).name(),allcompany.get(loc).role(),pack,allcompany.get(loc).CGPA()));

            return;
        }
        void updatecgpa(ArrayList<Company> allcompany,int loc){

            Double cgpa=inp.nextDouble();
            allcompany.set(loc, new Company(allcompany.get(loc).name(),allcompany.get(loc).role(),allcompany.get(loc).CTC(),cgpa));
            return;
        }
        void RegisterToInstituteDrive(ArrayList<Company> allcompany,int loc){
            Scanner input=new Scanner(System.in);
            Company company=new Company();
            String time1=input.nextLine();
            String time2= company.Ctcr;
            // System.out.println(Ctcr);
            // apply compareTo()
            int value = time1.compareTo(time2);
    
            // // print LocalDateTime
            // System.out.println("Int Value:" + value);
    
            if (value > 0){
                System.out.println("Registration Closed");
            }
            else if (value == 0){
                allcompany.get(loc).reg(1);
            }
            else{
                allcompany.get(loc).reg(1);
            }
            input.nextLine();

        }
        void GetAvailableCompany(ArrayList<Company> allcompany){
            
            System.out.println("List of All available companies is as follows:");
            for (int i=0;i<allcompany.size();i++){
                System.out.println(i+1+")  "+"CompanyName: "+allcompany.get(i).name());
                System.out.println("         Company role offering: "+allcompany.get(i).role());
                System.out.println("         Company Package: "+allcompany.get(i).CTC()+"LPA");
                System.out.println("         Company CGPA criteria: "+allcompany.get(i).CGPA());
                System.out.println(" ");
                }
            }
        void CompanyRegistrations(){
            Scanner input=new Scanner(System.in);
    
            System.out.println("Fill in the details:-");
            System.out.println("    1) Set the Opening time for company registrations(yyyy/MM/dd HH:mm:ss)");
            System.out.println("    2) Set the Closing time for company registrations(yyyy/MM/dd HH:mm:ss)");
            String Otcr=input.nextLine();
            String Ctcr=input.nextLine();
            time(Otcr, Ctcr);

        }
    }




/////////////////////////////////////////////////////Placementcell////////////////////////////////////////////////////////////////
class Placementcell {

        Placementcell(){
            
        }

        void NumberofStudentRegistrations(ArrayList<Student> allstudent){
            int len=allstudent.size();
            int count=0;
            for (int i=0;i<len;i++){
                if (allstudent.get(i).sreg()==1){
                    count++;
                }
            }    
            System.out.println(count);
        }
        void NumberofCompanyRegistrations(ArrayList<Company> allcompany){
            int len = allcompany.size();
            int count=0;
            for (int i=0;i<len;i++){
                if (allcompany.get(i).reg()==1){
                    count++;
                }
            }
            System.out.println(count);
        }
        void GetCompanyDetails(ArrayList<Company> allcompany,ArrayList<Student> allstudent){
            System.out.println("Details of companies is as follows:");
            int len = allcompany.size();
            int count=1;
            for (int i=0;i<len;i++){
                if (allcompany.get(i).reg()==1){
                    System.out.println((count)+")  "+"CompanyName: "+allcompany.get(i).name());
                    System.out.println("         Company role offering: "+allcompany.get(i).role());
                    System.out.println("         Company Package: "+allcompany.get(i).CTC()+"LPA");
                    System.out.println("         Company CGPA criteria: "+allcompany.get(i).CGPA());
                    System.out.println(" ");
                    count++;
                }
            }
        }
        void NumberofOffered_Unoffered_BlockedStudents(ArrayList<Student> allstudent){
            int len= allstudent.size();
            int offered=0;
            int unoffered=0;
            int blocked=0;
            //after getting know who accepted offer.
            for (int i=0;i<len;i++){
                if (allstudent.get(i).placed()==1){
                    System.out.println("    Name: "+allstudent.get(i).Name());
                    System.out.println("    RollNo: "+allstudent.get(i).Rollno());
                    System.out.println("    CGPA: "+allstudent.get(i).CGPA());
                    System.out.println("    Branch: "+allstudent.get(i).Branch());
                    System.out.println(" offered");
                    offered++;
                }
                if (allstudent.get(i).offer()==0){
                    System.out.println("    Name: "+allstudent.get(i).Name());
                    System.out.println("    RollNo: "+allstudent.get(i).Rollno());
                    System.out.println("    CGPA: "+allstudent.get(i).CGPA());
                    System.out.println("    Branch: "+allstudent.get(i).Branch());
                    System.out.println("unoffered");
                    unoffered++;
                }
                if (allstudent.get(i).count()==2){
                    System.out.println("    Name: "+allstudent.get(i).Name());
                    System.out.println("    RollNo: "+allstudent.get(i).Rollno());
                    System.out.println("    CGPA: "+allstudent.get(i).CGPA());
                    System.out.println("    Branch: "+allstudent.get(i).Branch());
                    System.out.println("blocked");
                    blocked++;
                }
            }
            System.out.println("offered is: "+offered);
            System.out.println("unoffered is: "+unoffered);
            System.out.println("blocked id: "+blocked);
        }
        void GetStudentDetails(ArrayList<Student> allstudent){
            System.out.println("Following are the students selected-");
            //after getting know who accepted offer.
            int count=1;
            for (int i=0;i<allstudent.size();i++){
                if (allstudent.get(i).sreg()==1){
                    System.out.println(count+") Name: "+allstudent.get(i).Name());
                    System.out.println("    RollNo: "+allstudent.get(i).Rollno());
                    System.out.println("    CGPA: "+allstudent.get(i).CGPA());
                    System.out.println("    Branch: "+allstudent.get(i).Branch());
                    count++;
                }
            }

        }
        void GetAveragePackage(ArrayList<Company> allcompany,ArrayList<Student> allstudent){
            int len= allstudent.size();
            Double sum=0.0;
            int count=0;
            //after getting know who accepted offer.
            for (int i=0;i<len;i++){
                if (allstudent.get(i).placed()==1){
                    sum+=allstudent.get(i).offer();
                    count++;
                }
            }
            System.out.println("Average package is: "+sum/count);
        }
        void GetCompanyProcessResults(ArrayList<Company> allcompany,ArrayList<Student> allstudent,String cmpname){
            Scanner input=new Scanner(System.in);
            System.out.println("enter name of company: ");
            String which=input.nextLine();
            int len=allcompany.size();
            int loc=0;
            
            for (int i=0;i<len;i++){
                if (allcompany.get(i).name().compareTo(which)==0){
                        loc=i;
                        break;
                    }
                }
                int pos=allcompany.get(loc).companyreg();
                Double off=allcompany.get(loc).CTC();
                if (allstudent.get(pos).offer()>0){
                    if (allstudent.get(pos).offer()>allcompany.get(loc).CTC()){
                        System.out.println("Following are the students selected-");
                        System.out.println(1+") Name: "+allstudent.get(pos).Name());
                        System.out.println("    RollNo: "+allstudent.get(pos).Rollno());
                        System.out.println("    CGPA: "+allstudent.get(pos).CGPA());
                        System.out.println("    Branch: "+allstudent.get(pos).Branch());
                    }
                    else{
                        allstudent.get(pos).offer(off);
                        System.out.println("Following are the students selected-");
                        System.out.println(1+") Name: "+allstudent.get(pos).Name());
                        System.out.println("    RollNo: "+allstudent.get(pos).Rollno());
                        System.out.println("    CGPA: "+allstudent.get(pos).CGPA());
                        System.out.println("    Branch: "+allstudent.get(pos).Branch());
                    }
                }
                else{
                    
                        allstudent.get(pos).offer(off);
                        System.out.println("Following are the students selected-");
                        System.out.println(1+") Name: "+allstudent.get(pos).Name());
                        System.out.println("    RollNo: "+allstudent.get(pos).Rollno());
                        System.out.println("    CGPA: "+allstudent.get(pos).CGPA());
                        System.out.println("    Branch: "+allstudent.get(pos).Branch());
                    
                }

        }
    
    
    }
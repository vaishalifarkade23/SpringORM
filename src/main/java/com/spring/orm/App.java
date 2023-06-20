package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentdao= (StudentDao) context.getBean("studentdao");
       
       //insert
//       Student student= new Student(113,"prachi farkade", "Mumbai");
//       int r=studentdao.insert(student);
//       System.out.println("done" +r);
       
     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
     boolean go= true;
     while(go)
     {
    	 System.out.println("press 1 for add new student");
         System.out.println("press 2 for display all student ");
         System.out.println("press 3  for get detail of single student ");
         System.out.println("press 4 for delete ");
         System.out.println("press 5 for update ");
         System.out.println("press 6 for  exit");
         try
         {
        	int input = Integer.parseInt(br.readLine());
//        	if(input==1)
//        	{
//        		//add new student
//        	}else
//        	{
//        		//display
//        	}
        	
        	switch(input)
        	{
        	case 1:
        		//add new student
        		
        		//taking input from user
        		System.out.println("Enter id");
        		int uid=Integer.parseInt(br.readLine());
        		
        		System.out.println("Enter name");
        		String uname = br.readLine();
        		
        		System.out.println("Enter city");
        		String ucity = br.readLine();
        		
        		//creating student object an seting values
        		Student s= new Student();
        		s.setId(uid);
        		s.setName(uname);
        		s.setCity(ucity);
        		
        		//saving  student object database by calling insert of student dao
        		int res = studentdao.insert(s);
        		System.out.println(res + "added");
        		System.out.println("----------------------------------");
        		System.out.println();
        		break;
        	
             case 2:
     		//display student all
            	 List<Student> allStudents = studentdao.getAllStudents();
            	 for(Student st:allStudents)
            	 {
            		 System.out.println("id:"+st.getId());
            		 
            		 System.out.println("name:"+st.getName());
            		
            		 System.out.println("city:"+st.getCity());
            		 
            		 System.out.println("---------------------");
            		 System.out.println();
            	 }
     		     break;
     	
            case 3:
 		        //get single student
            	int userid=Integer.parseInt(br.readLine());
            	Student student=studentdao.getStudent(userid);
            	System.out.println("id:"+student.getId());
       		    System.out.println("name:"+student.getName());
       	        System.out.println("city:"+student.getCity());
       		 
       		 System.out.println("---------------------");
       		 System.out.println();
 		        break;
 	
            case 4:
	      //delete student
            	int delid=Integer.parseInt(br.readLine());
            	System.out.println("Enter id");
            	studentdao.deleteStudent(delid);
            	System.out.println("deleted");
		     break;
	
            case 5:
            	//update not done yet
            	int upid=Integer.parseInt(br.readLine());
            	System.out.println("enter id");
            	Student student2=new Student();
            	student2.getId();
            	student2.getName();
            	student2.getCity();
            	studentdao.updateStudent(student2);
            	
            	
            	break;
            	
            case 6:
            	//exit
            	go=false;
            	break;
            	
        	}
        	
         }
         catch(Exception e)
         {
        	 System.out.println("invalid input try with another one");
        	 System.out.println(e.getMessage());
         }
     }
    
    
    }
}

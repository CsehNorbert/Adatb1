import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileWriter;  
import java.io.PrintWriter;  
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class raktar {

		int epulet=3;		
		int sor=2;
		int oszlop=10;
		int emelet=4;
		
		int V_epulet=1;		
		int V_sor=1;
		int V_oszlop=1;
		int V_emelet=1;
		
		String buffer="";
		
		String[] termekek= new String[10];
		int[] menny = new int[10];
		
		private File file = null;
		
		private void initFile() {
				try {
				file = new File("E:\\adatb1\\REK.DAT");
			
			} catch (NullPointerException exception_1) {
				exception_1.printStackTrace();
			}
			
			try {
			RandomAccessFile ra = new RandomAccessFile(file, "rw");
			
			BufferedReader br = new BufferedReader(new FileReader("E:\\adatb1\\REK.DAT"));     
			if (br.readLine() == null) {
			    makeBlankFile();
			}			
			br.close();
			ra.close();
			} catch (IOException exception_2) {
				exception_2.printStackTrace();
			}
			
			
		};	
		
			private void makeBlankFile()
			{
				try{FileWriter fw = new FileWriter("E:\\adatb1\\REK.DAT",true);
				PrintWriter pw = new PrintWriter(fw);
			    for(int i = 1; i < epulet+1;i++)
			    {
			    	for(int j = 1; j < sor+1;j++)
				    {
			    		for(int k = 1; k < oszlop+1;k++)
					    {
			    			for(int l = 1; l < emelet+1;l++)
						    {
						    	pw.println( i + "-"+j+"-"+k+"-"+l+"-"+
								    	+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY-"+0+"-"+"EMPTY"
);
						    }
					    }
				    }
			    }
			    pw.close();
			} catch (IOException e) {
			    System.out.println("Error writing File. Could not SAVE");
			    e.printStackTrace();
			}
			};
			
		
		public void letesz_rekeszbe(int darab, String name, int mepulet, int msor, int moszlop, int memelet)
		{
	    	try{
		    	/*if(darab>10){
			    	throw new Exception("letesz");
			    }*/
		    	//if(darab>10){
		    		/*String location = Integer.toString(mepulet)+"-"+Integer.toString(msor)+"-"+Integer.toString(moszlop)+"-"+Integer.toString(emelet)+"-"
		    	+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY";
		    		*/
		    		Scanner scanner = new Scanner(file);
		    		String line="";
		    		    while (scanner.hasNextLine()) {
		    		        line = scanner.nextLine();
		    		        System.out.println(line);
		    		        get_a_line(line);
		    		        
		    		        if(V_epulet==mepulet &&		
		    					V_sor==msor &&
		    					V_oszlop==moszlop &&
		    					V_emelet==memelet) 
		    		        { 
		    		            System.out.println("BENGO");
		    		            if(is_availible())
			    		        { 
			    		            int where =0;
			    		            for(int i = 0; i <10;i++)
			    				    {
			    				    	if(menny[i]==0)
			    						    {
			    				    			where=i;
			    				    			break;
			    						    }
			    				    }
			    		            termekek[where]=name;
			    		            System.out.println(termekek[where]);
			    		    		menny[where]=darab;
			    		    		System.out.println(menny[where]);
			    		    		buffer = buffer + compile_into_line()+System.lineSeparator().toString();
			    		            		
			    		        }
		    		            else
		    		            {
		    		            	buffer = buffer +line+System.lineSeparator().toString();
    						    }
		    		        }else
	    		            {
		    		        	buffer = buffer +line+System.lineSeparator().toString();
						    }
		    		       
		    		    }
		    		    scanner.close();
		    		    replaceWithBuffer(file);
		    		//toString(mepulet.toString);
			    	throw new Exception("letesz");
			    
		    }
	    	catch(Exception letesz){
	    		System.out.println("Only 10 item can be fitted here.");
		    }
			
	    };
		
	    public void kivesz_rekeszbol(int darab, String name, int mepulet, int msor, int moszlop, int memelet)
		{
	    	try{
		    	/*if(darab>10){
			    	throw new Exception("letesz");
			    }*/
		    	//if(darab>10){
		    		/*String location = Integer.toString(mepulet)+"-"+Integer.toString(msor)+"-"+Integer.toString(moszlop)+"-"+Integer.toString(emelet)+"-"
		    	+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY"+0+"-"+"EMPTY";
		    		*/
		    		Scanner scanner = new Scanner(file);
		    		String line="";
		    		    while (scanner.hasNextLine()) {
		    		        line = scanner.nextLine();
		    		        get_a_line(line);
		    		        
		    		        if(V_epulet==mepulet &&		
		    					V_sor==msor &&
		    					V_oszlop==moszlop &&
		    					V_emelet==memelet) 
		    		        { 
		    		            System.out.println("BENGO");
		    		            if(is_there(name,darab))
			    		        { 
			    		            int where =0;
			    		            for(int i =0 ;i<10;i++)
			    		    		{	
			    		    			if(termekek[i].equals(name))
			    		    			{	
			    		        			if(menny[i]>darab || menny[i] ==darab)
			    		        			{	
			    		            			where=i;
			    		            			break;
			    		            		}
			    		        		}
			    		    		}
			    		            if(menny[where]== darab ){
			    		    			menny[where]=0;
				    		        }else {
				    		        	int deleted_so_far=0;
				    		        	int i =0;
				    		        	while(deleted_so_far<darab)
				    		    		{	
				    		        		System.out.println("menny[i]"+menny[i]);
				    		        		System.out.println("deleted_so_far"+deleted_so_far);
				    		        		System.out.println("i"+i);
				    		        		System.out.println("***");
				    		    			if(termekek[i].equals(name))
				    		    			{	
				    		    				if(menny[i]<(darab-deleted_so_far))
					    		    			{	
				    		    					deleted_so_far=deleted_so_far+menny[i];
					    		        			menny[i]=0;
					    		        			termekek[i]="EMPTY";
					    		        		}else{	
				    		    					
				    		    					
				    		    					menny[i]=menny[i]-(darab-deleted_so_far);
				    		    					deleted_so_far=darab;
					    		        		}
					    		        			
				    		        		}
				    		    			if(menny[i]==0 )
						    		        {
					    		    			termekek[i]="EMPTY";
						    		        }
				    		    			i++;
				    		    		}
				    		        	//menny[where]=menny[where]-darab;
				    		        }
				    		        	if(menny[where]==0 )
				    		        {
			    		    			termekek[where]="EMPTY";
				    		        }
			    		    		System.out.println(menny[where]);
			    		    		buffer = buffer + compile_into_line()+System.lineSeparator().toString();
			    		            		
			    		        }
		    		            else
		    		            {
		    		            	buffer = buffer +line+System.lineSeparator().toString();
    						    }
		    		        }else
	    		            {
		    		        	buffer = buffer +line+System.lineSeparator().toString();
						    }
		    		       
		    		    }
		    		    scanner.close();
		    		    replaceWithBuffer(file);
		    		//toString(mepulet.toString);
			    	throw new Exception("letesz");
			    
		    }
	    	catch(Exception letesz){
	    		System.out.println("there aren't enough stuff here.");
		    }
			
	    };
	    
	    public void kilistaz(String name) {
	    	try{	
		int sum=0;
		Scanner scanner = new Scanner(file);
		String line="";
		    while (scanner.hasNextLine()) {
		        line = scanner.nextLine();
		        get_a_line(line);
    		            for(int i =0 ;i<10;i++)
    		    		{	
    		    			if(name.equals(termekek[i]))
    		    			{	
    		        			if(menny[i]!=0)
    		        			{	
    		        				
    		        				System.out.println(menny[i]+" darab van a "+V_epulet+".épület "+V_sor+". sorának "+V_oszlop+". oszlopában, a "+V_emelet + ". emeletén");
    		            			sum=sum+menny[i];
    		            		}
    		        		}
    		    		}
		    }
		    System.out.println(sum+" darab van összesen.");
		    scanner.close();
		    
	    	}
	    	catch(Exception exception_line){
	    		System.out.println(exception_line.getMessage());
	    	}
		
	};	
	    
	    private void replaceWithBuffer(File database){
	    	if (database.delete()) { 
	    	      System.out.println("Deleted the file: " + database.getName());
	    	      
	    	      try{FileWriter fw = new FileWriter("E:\\adatb1\\REK.DAT",false);
					PrintWriter pw = new PrintWriter(fw,true);
					buffer.replaceAll("(?m)^[ \t]*\r?\n", "");
					pw.print(buffer);
				    pw.close();
				    buffer="";
				} catch (IOException e) {
				    System.out.println("Error writing File. Could not SAVE Officer");
				    e.printStackTrace();
				}
	    	      
	    	    } else {
	    	      System.out.println("Failed to delete the file.");
	    	    } 
	    	
	    };
		
	    
	    
	    private String compile_into_line(){
	    		String result = 
	    		String.valueOf(V_epulet)+"-"+
	    				String.valueOf(V_sor)+"-"+
	    				String.valueOf(V_oszlop)+"-"+
	    				String.valueOf(V_emelet);
	    		for(int i =0 ;i<10;i++)
	    		{	
	    			result= result +"-"+ menny[i]+"-"+termekek[i];
	    			System.out.println(menny[i]);
	    			System.out.println(termekek[i]);
	    		}
	    		
	    		return result;
	    };
	    
	    
	    private boolean is_there(String name, int darab){
    		for(int i =0 ;i<10;i++)
    		{	
    			System.out.println(darab);
    			if(termekek[i].equals(name))
    			{	
        			if(menny[i]>darab || menny[i] ==darab)
        			{	
            			return true;
            		}else{	
            			int aval=0;
            			for(int j =0 ;j<10;j++)
                		{	
            				if(termekek[i].equals(name)){	
                    			aval=menny[i]+aval;
                    		}
                		}
            			if(aval==darab || aval > darab){	
                			return true;
                		}
            		}
            			
        		}
    		}
	    	
	    	return false;
	    };
	    
	    private boolean is_availible(){
    		if(is_there_an_empty()){
        		return true;
    	    }else{
        		return false;
    	    }
	    };
	    
	    private boolean is_there_an_empty(){
	    	for(int i = 0; i <10;i++)
		    {
		    	if(menny[i]==0)
				    {
		    			return true;
				    }
		    }
	    	return false;
	    };

	    private void get_a_line(String linestring){
	    	try {
	    		String[] arrOfStr = linestring.split("-", 24);
	    		V_epulet=Integer.parseInt(arrOfStr[0]);
	    		V_sor=Integer.parseInt(arrOfStr[1]);
	    		V_oszlop=Integer.parseInt(arrOfStr[2]);
	    		V_emelet=Integer.parseInt(arrOfStr[3]);
	    		int j = 0;

	    		for(int i =4 ;i<24;i=i+2)
	    		{	
	    			menny[j]=Integer.parseInt(arrOfStr[i]);
	    			termekek[j]=arrOfStr[i+1];
	    			
	    			j++;
	    		}
	    	}
	    	catch(Exception exception_line){
	    		System.out.println(exception_line.getMessage());
	    	}
	    };
	    
	  /*  private int how_many_is_there(String location){
    		if(darab>10  ){
        		return false;
    	    }else{
        		return true;
    	    }
	    };*/
		
		public raktar()
		{
			initFile();
		}

	
}


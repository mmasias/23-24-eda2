
import java.util.ArrayList;
import java.util.Scanner;


public class Library {

    ArrayList<Docs> docs = null;

    public Library(){

        docs = new ArrayList<Docs>();
        showMenu();
    }

    public void showMenu() {
        boolean exit = false;
        Scanner userInput = new Scanner(System.in);
        while (!exit) {
            System.out.println("(1) Create document");
            System.out.println("(2) Edit document");
            System.out.println("(3) Delete document");            
            System.out.println("(4) Search and show document");
            System.out.println("(6) List all documents");
            System.out.println("(-1) Exit");
            String option = userInput.nextLine();
            if (option.compareTo("-1")==0)
                exit=true;
            else
            {
                switch (option){
                    case "1": createDoc(); break;
                    case "2": editDoc();break;
                    case "3": deleteDoc();break;
                    case "4": searchDoc();break; // Fix: Pass the required arguments to the searchDoc() method
                    case "6": showAll();break;
                }               
            }
        }
    }

    private void createDoc(){
        Docs doc=null;
        Scanner userInput = new Scanner(System.in);
        System.out.println("(A,M,B,T) Indicate the type of document you want to create; A is for article, M is for magazine, B is for book and T is for technical paper");
        String type = userInput.nextLine();
        switch (type){
            case "A":
                doc=new Article();
                break;
            case "M":
                doc=new Magaz();
                break;
            case "b":
                doc=new Book();
                break;
            case "T":
                doc=new TecPaper();
                break;
            default:
                doc=new Docs();
                break;
        }              
        this.docs.add(doc);
        System.out.println("Document created and added:"+doc.toString());
    }


    private Docs searchDoc(){

        boolean found=false;
        Docs docres=null;
        ArrayList<Docs> docs=null;
        Scanner userInput = new Scanner(System.in);
        System.out.println("(TYPE,TITLE,YEAR,AUTHORS,KEYWORDS) Indicate the property you want to search the document by:");
        String type = userInput.nextLine();
        System.out.println("Indicate the value you want to search by:");
        String property=userInput.nextLine();
        docs=searchDoc(type,property, null); 
        if (docs!=null)
        {
            while (!found)
            {
                if (docs.size()==1)
                {
                    System.out.println(docs.get(0).toString());
                    found=true;
                    docres=docs.get(0);
                }
                else
                {
                    //There are several documents in the list that meet the criteria. It must be narrowed down
                    System.out.println("There are several documents in the list that meet the criteria. It must be narrowed down");
                    System.out.println("(TYPE,TITLE,YEAR,AUTHORS,KEYWORDS) Indicate the property you want to search the document by:");
                    type = userInput.nextLine();
                    System.out.println("Indicate the value you want to search by:");
                    property=userInput.nextLine();
                    docs=searchDoc(type,property,docs);        
                }
            }
        }
        return docres;
    } 
    
    private void editDoc()
    {
        Docs doc=searchDoc();
        if (doc!=null)
            doc.editDoc();
    }

    private void deleteDoc()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Indicate the type of document you want to delete (A,M,B,T)");
        String Dtype = userInput.nextLine();
        System.out.println("Indicate the title of the document");
        String Dtitle= userInput.nextLine();
        System.out.println("Indicate the year of publication of the document");
        String Dyear=userInput.nextLine();
        this.docs.removeIf(n -> (n.getType().compareTo(Dtype)==0 && n.getTitle().compareTo(Dtitle)==0 && n.getYearpub()==Integer.parseInt(Dyear)));
    
    }

    private ArrayList<Docs> searchDoc(String type, String property, ArrayList<Docs> where) {
        if (where==null){
            where=this.docs;
        }
        ArrayList<Docs> docres=new ArrayList<Docs>();
        for (Docs doc:where)
            switch(type) {
                case "TYPE":               
                        if (doc.getType().compareTo(property)==0)                    
                            docres.add(doc);  
                        break;
                case "TITLE":
                        if (doc.getTitle().compareTo(property)==0)                        
                            docres.add(doc);                
                        break;
                case "YEAR":
                        if (doc.getYearpub()==Integer.parseInt(property))                        
                            docres.add(doc);                
                        break;
                case "AUTHORS":
                        if (doc.checkAuthors(property))                        
                            docres.add(doc);                       
                        break;
                case "KEYWORDS":
                        if (doc.checkKeywords(property))                        
                            docres.add(doc);   
                        break;
            }
        return docres;


    }
   
   
    private void showAll() {
        for(Docs doc: this.docs)
            System.out.println(doc.toString());
    }
    


    public static void main(String[] args) {
        
        Library lib = new Library();
    }

  
}

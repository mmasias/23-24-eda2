package searches;

import java.util.ArrayList;

public class SearchDocument {
    public SearchDocument(String typeOfSearch, String dataToSearch){
        switch (typeOfSearch) {
            case "title":
                searchByTitle(dataToSearch);
                break;
            case "author":
                searchByAuthor(dataToSearch);
                break;
            case "year":
                searchByYear(dataToSearch);
                break;
            case "type":
                searchByType(dataToSearch);
                break;
            case "keyword":
                searchByKeyword(dataToSearch);
                break;
            default:
                break;
        }
    }

    private ArrayList searchByTitle(String title){
        ArrayList<String> result = new ArrayList<>();

        return result;
    }
    private ArrayList searchByAuthor(String author){
        ArrayList<String> result = new ArrayList<>();

        return result;
    }
    private ArrayList searchByYear(String year){
        ArrayList<String> result = new ArrayList<>();

        return result;
    }
    private ArrayList searchByType(String type){
        ArrayList<String> result = new ArrayList<>();

        return result;
    }
    private ArrayList searchByKeyword(String keyword){
        ArrayList<String> result = new ArrayList<>();

        return result;
    }

}

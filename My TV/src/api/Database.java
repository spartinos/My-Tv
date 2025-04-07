package api;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Database {

    ArrayList<Movie> movies;
    ArrayList<Show> shows;

    ArrayList<Person> people;
    HashMap<String, String> Login = new HashMap<>();
    ArrayList<String> genreList ;
    public Database()
    {
        movies = new ArrayList<>();
        shows = new ArrayList<>();
        people = new ArrayList<>();
        movies = readListFromFile("Movies.ser");
        shows = readListFromFile("Shows.ser");
        people = readListFromFile("People.ser");
        Login = readMapFromFile("LoginCredentials.ser");
        initializeGenreList();
    }

    public Database(int k){
        movies = new ArrayList<>();
        shows = new ArrayList<>();
        people = new ArrayList<>();
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }
    public void deleteMovie(Movie movie){movies.remove(movie);}


    public void addShow(Show show)
    {
        shows.add(show);
    }

    public void deleteShow(Show show){shows.remove(show);}

    public void addPerson(Person p){
        people.add(p);
    }

    public void addLogins(String username, String password){
        if(!Login.containsKey(username))
            Login.put(username, password);
        else
            System.out.println("username already exists!");
    }



    private void initializeGenreList()
    {
        genreList= new ArrayList<>();
        genreList.add("Horror");
        genreList.add("Drama");
        genreList.add("Sci-Fi");
        genreList.add("Comedy");
        genreList.add("Action");

    }

    public void saveInFiles(){
        writeListToFile("People.ser", people);
        writeListToFile("Shows.ser", shows);
        writeListToFile("Movies.ser", movies);
        writeMapToFile("LoginCredentials.ser", Login);
    }

    public void writeListToFile(String path, ArrayList list){
        try(ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(path));){
            obj.writeObject(list);
            obj.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Person register(String name,String surname, String username,String password) {
        //username already exists
        if (Login.containsKey(username)) {
            return null;
        }


        User newPerson = new User(name, surname, username, password);
        Login.put(username, password);
        people.add(newPerson);
        return newPerson;

    }

    public void writeMapToFile(String path, HashMap map){
        try(ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(path));){
            obj.writeObject(map);
            obj.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList readListFromFile(String path){
        try(ObjectInputStream obj=new ObjectInputStream(new FileInputStream(path));){
            if (path.equals("People.ser")){
                ArrayList<Person> people = (ArrayList<Person>) obj.readObject();
                obj.close();
                return people;
            } else if (path.equals("Shows.ser")) {
                ArrayList<Show> show = (ArrayList<Show>) obj.readObject();
                obj.close();
                return show;
            }
            ArrayList<Movie> movie = (ArrayList<Movie>) obj.readObject();
            obj.close();
            return movie;
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public HashMap readMapFromFile(String path){
        try(ObjectInputStream obj=new ObjectInputStream(new FileInputStream(path));){
            HashMap<String,String> map= (HashMap<String, String>) obj.readObject();
            obj.close();
            return map;
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Person login(String username, String password){
        for (Person a : people) {
            if (a.getUsername().equals(username)) {
                if (a.getPassword().equals(password)) {
                    return a;
                }
            }
        }
        return null;
    }

    public void showGenres()
    {
        for(String g: genreList)
        {
            System.out.println(g);
        }
    }



    public ArrayList<Production> search()
    {
        ArrayList<Production> results = new ArrayList<>();
        results.addAll(movies);
        results.addAll(shows);

        return results;
    }


    public ArrayList<Production> search(String title, String cast, boolean isAppropriate, String genre, double leastRating)
    {
        ArrayList<Production> searchResults = new ArrayList<>();



        for(Production m: movies)
        {
            if(m.getTitle().equalsIgnoreCase(title) && m.getCast().toLowerCase().contains(cast.toLowerCase()) && m.getAppropriation()==isAppropriate && m.getGenre().equals(genre) && m.getRating()>=(double)leastRating)
            {
                searchResults.add(m);
            }
        }

        for(Production s: shows)
        {
            if(s.getTitle().equalsIgnoreCase(title) && s.getCast().toLowerCase().contains(cast.toLowerCase()) && s.getAppropriation()==isAppropriate && s.getGenre().equals(genre) && s.getRating()>=(double)leastRating)
            {
                searchResults.add(s);
            }
        }


        if(searchResults.isEmpty())
            return null;
        else
            return searchResults;
    }


    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }


}


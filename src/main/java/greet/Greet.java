package greet;

public interface Greet {
    String greet(String name,Language lang);
    String greeted();
    int counter();
    void clear();


}
//    public String greetUser(User user, Language lang){
//        return lang.getGreeting() +" "+ user.getName() + " !";
//    }
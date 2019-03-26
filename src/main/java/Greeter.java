public class Greeter{
     String greet(String userName, String languageString){
         Language language = getLang(languageString);
         switch (language){
             case ENGLISH:
                 return "Hello "+userName+"!";
             case TSONGA:
                 return "Avuxeni "+userName+"!";
             case AFRIKAANS:
                 return "Hallo "+userName+"!";
             default:
                 return "Error!";
         }
    }
    private Language getLang(String langString){
        try {
            return Language.valueOf(langString.toUpperCase());
        }
        catch (NullPointerException | IllegalArgumentException e){
            //return default language
            return Language.ENGLISH;
        }
    }

}




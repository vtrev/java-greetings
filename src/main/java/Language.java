public enum Language {
    ENGLISH("Hello"),TSONGA("Avuxeni"),AFRIKAANS("Hallo");
    private String greeting;
    private Language(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting(){
        return this.greeting;
    }

}

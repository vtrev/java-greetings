package greet;

import lombok.Getter;

@Getter
public class Result {
    private String result;
    private Boolean menuState;

    public Result(String result,boolean menuState){
        this.result = result;
        this.menuState = menuState;
    }
}

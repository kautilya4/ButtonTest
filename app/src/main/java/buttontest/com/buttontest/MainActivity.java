package buttontest.com.buttontest;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("TAG", "count is "+solution("a0Ba"));
        Log.e("TAG", "count is "+solution("a0bb"));


    }

    private static final String PASS_PATTERN = "[a-z][A-Z]|[A-Z]|[A-Z][a-z]";
   // private static final String PASS_PATTERN2 = "[A-Z]";

    public int solution(String S) {
        // write your code in Java SE 8
        int validNumberCount = 0;
        for(int i=0; i<S.length();i++){
            for(int j= i+1; j<=S.length();j++){
                if(isSubStringValidPassword(S.substring(i,j))){
                    validNumberCount++;
                    Log.e("TAG", "valid substring is "+S.substring(i,j));
                }
            }
        }

        if(validNumberCount ==0)
            return -1;
        return validNumberCount;

    }

    public boolean isSubStringValidPassword(String str){
        Log.e("TAG","checking "+str);
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(PASS_PATTERN);
        matcher = pattern.matcher(str) ;
        return  matcher.matches();
    }



}

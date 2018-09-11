package cc.wuhan5.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView ansText1, ansText2, ansText3, ansText4;
    private Button sumbitButton;
    private TextView logText;

    private Number[] numberArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitUI();
        InitNumber();

        sumbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    //初始化UI
    private void InitUI(){
        ansText1 = findViewById(R.id.ansNum1);
        ansText2 = findViewById(R.id.ansNum2);
        ansText3 = findViewById(R.id.ansNum3);
        ansText4 = findViewById(R.id.ansNum4);

        //答案框全部显示为问号
        ansText1.setText("?");
        ansText2.setText("?");
        ansText3.setText("?");
        ansText4.setText("?");

        logText = findViewById(R.id.logText);

        sumbitButton = findViewById(R.id.submitButton);

        addLog("游戏开始！");
    }

    private void InitNumber(){
        numberArray = new Number[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Array 转化为 List
        List numberList = Arrays.asList(numberArray);
        //随机打乱
        Collections.shuffle(numberList);

        Log.v("aa", numberList.get(0).toString());

        addLog("答案数字已生成。");

    }

    //添加提示框信息
    private void addLog(String inputText){
        logText.setText(logText.getText() + "\n" + inputText);
    }
}

package cc.wuhan5.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView ansText1, ansText2, ansText3, ansText4;
    private Button sumbitButton;
    private TextView logText;
    private TextView inputNum;

    private Number[] numberArray;

    private Number[] answerArray;

    private List numberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitUI();
        InitNumber();

        sumbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAnswer().equals("A4B0")){
                    showAnswer();
                    addLog("答对了！");
                }else {
                    addLog(checkAnswer());
                }
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
        logText.setMovementMethod(ScrollingMovementMethod.getInstance());   //设置可以滚动
        inputNum = findViewById(R.id.inputNum);

        sumbitButton = findViewById(R.id.submitButton);

        addLog("游戏开始！");
    }

    private void InitNumber(){
        numberArray = new Number[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Array 转化为 List
        numberList = Arrays.asList(numberArray);
        //随机打乱
        Collections.shuffle(numberList);

        //答案数组
        answerArray = new Number[4];

        //循环放入数据
        for(Integer i = 0; i <= 3; i++){
            answerArray[i] = (Number)numberList.get(i);
        }

        addLog("答案数字已生成。");
        //addLog(numberList.get(0).toString() + numberList.get(1).toString()+ numberList.get(2).toString()+ numberList.get(3).toString());

    }

    private String checkAnswer(){

        //A,B初始化
        Integer A = 0;
        Integer B = 0;

        for(Integer i = 0; i <= 3; i++){
            //位置、值都是对的
            if(String.valueOf(inputNum.getText().charAt(i)).toString().equals(numberList.get(i).toString())){
                A++;
            }else{
                //位置不对，但包含值
                if(inputNum.getText().toString().indexOf(answerArray[i].toString()) != -1){
                    B++;
                }
            }

        }

        //inputNum.setText("");
        return "A" + A.toString() + "B" + B.toString();
    }

    private void showAnswer(){
        ansText1.setText(answerArray[0].toString());
        ansText2.setText(answerArray[1].toString());
        ansText3.setText(answerArray[2].toString());
        ansText4.setText(answerArray[3].toString());
    }

    //添加提示框信息
    private void addLog(String inputText){
        logText.setText(logText.getText() + "\n" + inputText);
    }
}

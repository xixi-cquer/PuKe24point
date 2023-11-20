package com.example.a24dian;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "leo";
    private final cal24 point24 = new cal24();
    private final int[] chooseNums = {0, 0, 0, 0};
    private ImageButton card1 = null;
    private ImageButton card2 = null;
    private ImageButton card3 = null;
    private ImageButton card4 = null;
    private final List<ImageButton> chooseCards = new ArrayList<ImageButton>();
    private final String[] chooseCardsName ={"", "", "", ""};
    private final Stack<Integer> sta = new Stack<Integer>();
    private final Stack<ImageButton> sta2 = new Stack<ImageButton>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        chooseCards.add(card1);
        chooseCards.add(card2);
        chooseCards.add(card3);
        chooseCards.add(card4);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void getTips(View view){

        // 计算24点
        StringBuilder msg = new StringBuilder();
        if(chooseNums[0] == 0 || chooseNums[1] == 0 || chooseNums[2] == 0 || chooseNums[3] == 0){
            msg = new StringBuilder("未选择四张扑克牌。");
        }else{
            List<String> equs = point24.getPoint24Equ(chooseNums);
            if(equs.isEmpty()){
                msg = new StringBuilder("当前选择的四张扑克牌不能计算24点。");
            }else{
                int cnt = equs.size();
                for(int i = 0; i<cnt; i++){
                    msg.append(i+1).append("、").append(equs.get(i)).append("\n");
                }
                msg.append("共有 ").append(cnt).append(" 个表达式");
            }
        }
        // 创建一个 Intent，启动下一个 Activity，并将结果传递过去
        Intent intent = new Intent(this, result.class);
        intent.putExtra("result",msg.toString());
        startActivity(intent);

        // 清空卡牌框
        Drawable Back = getDrawable(R.drawable.back);
        card1.setBackground(Back);
        card2.setBackground(Back);
        card3.setBackground(Back);
        card4.setBackground(Back);

        // 清空数组
        chooseNums[0] = chooseNums[1] = chooseNums[2] = chooseNums[3] = 0;
        chooseCardsName[0] = chooseCardsName[1] = chooseCardsName[2] = chooseCardsName[3] = "";
        sta.clear();
        while(!sta2.empty()){
            ImageView bnt = sta2.pop();
            bnt.setVisibility(View.VISIBLE);
        }


    }


    public void clearCards(View view){
        // 选择区
        @SuppressLint("UseCompatLoadingForDrawables") Drawable Back = getDrawable(R.drawable.back);
        card1.setBackground(Back);
        card2.setBackground(Back);
        card3.setBackground(Back);
        card4.setBackground(Back);

        // 清空数组
        chooseNums[0] = chooseNums[1] = chooseNums[2] = chooseNums[3] = 0;
        chooseCardsName[0] = chooseCardsName[1] = chooseCardsName[2] = chooseCardsName[3] = "";
        sta.clear();
        while(!sta2.empty()){
            ImageView bnt = sta2.pop();
            bnt.setVisibility(View.VISIBLE);
        }
    }



    public int getCardNum(String cardName) {
        int num = 0;
        char c = cardName.charAt(cardName.length() - 1);
        char b = cardName.charAt(cardName.length() - 2);
        if (c == '1') {
            if(b=='1'){
                num = 11;
            }
            else{num = 1;}
        } else if (c == '2') {
            if(b=='1'){
                num = 12;
            }
            else{num = 2;}
        } else if (c == '3') {
            if(b=='1'){
                num = 13;
            }
            else{num = 3;}
        } else if (c == '4') {
            num = 4;
        } else if (c == '5') {
            num = 5;
        } else if (c == '6') {
            num = 6;
        } else if (c == '7') {
            num = 7;
        } else if (c == '8') {
            num = 8;
        } else if (c == '9') {
            num = 9;
        } else if (c == '0') {
            num = 10;
        }
        return num;

    }

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    public void chooseCard(View view) {

        int curCardId = view.getId();

        // 获取当前选取牌的名称
        int id = view.getId();
        String curCardName = "";
        int curCardBackId = 0;
        if (id == R.id.club1) {
            curCardBackId = R.drawable.club1;
            curCardName = "club1";
        } else if (id == R.id.club2) {
            curCardBackId = R.drawable.club2;
            curCardName = "club2";
        } else if (id == R.id.club3) {
            curCardBackId = R.drawable.club3;
            curCardName = "club3";
        } else if (id == R.id.club4) {
            curCardBackId = R.drawable.club4;
            curCardName = "club4";
        } else if (id == R.id.club5) {
            curCardBackId = R.drawable.club5;
            curCardName = "club5";
        } else if (id == R.id.club6) {
            curCardBackId = R.drawable.club6;
            curCardName = "club6";
        } else if (id == R.id.club7) {
            curCardBackId = R.drawable.club7;
            curCardName = "club7";
        } else if (id == R.id.club8) {
            curCardBackId = R.drawable.club8;
            curCardName = "club8";
        } else if (id == R.id.club9) {
            curCardBackId = R.drawable.club9;
            curCardName = "club9";
        } else if (id == R.id.club10) {
            curCardBackId = R.drawable.club10;
            curCardName = "club10";
        } else if (id == R.id.club11) {
            curCardBackId = R.drawable.club11;
            curCardName = "club11";
        } else if (id == R.id.club12) {
            curCardBackId = R.drawable.club12;
            curCardName = "club12";
        } else if (id == R.id.club13) {
            curCardBackId = R.drawable.club13;
            curCardName = "club13";
        } else if (id == R.id.heart1) {
            curCardBackId = R.drawable.heart1;
            curCardName = "heart1";
        } else if (id == R.id.heart2) {
            curCardBackId = R.drawable.heart2;
            curCardName = "heart2";
        } else if (id == R.id.heart3) {
            curCardBackId = R.drawable.heart3;
            curCardName = "heart3";
        } else if (id == R.id.heart4) {
            curCardBackId = R.drawable.heart4;
            curCardName = "heart4";
        } else if (id == R.id.heart5) {
            curCardBackId = R.drawable.heart5;
            curCardName = "heart5";
        } else if (id == R.id.heart6) {
            curCardBackId = R.drawable.heart6;
            curCardName = "heart6";
        } else if (id == R.id.heart7) {
            curCardBackId = R.drawable.heart7;
            curCardName = "heart7";
        } else if (id == R.id.heart8) {
            curCardBackId = R.drawable.heart8;
            curCardName = "heart8";
        } else if (id == R.id.heart9) {
            curCardBackId = R.drawable.heart9;
            curCardName = "heart9";
        } else if (id == R.id.heart10) {
            curCardBackId = R.drawable.heart10;
            curCardName = "heart10";
        } else if (id == R.id.heart11) {
            curCardBackId = R.drawable.heart11;
            curCardName = "heart11";
        } else if (id == R.id.heart12) {
            curCardBackId = R.drawable.heart12;
            curCardName = "heart12";
        } else if (id == R.id.heart13) {
            curCardBackId = R.drawable.heart13;
            curCardName = "heart13";
        } else if (id == R.id.spade1) {
            curCardBackId = R.drawable.spade1;
            curCardName = "spade1";
        } else if (id == R.id.spade2) {
            curCardBackId = R.drawable.spade2;
            curCardName = "spade2";
        } else if (id == R.id.spade3) {
            curCardBackId = R.drawable.spade3;
            curCardName = "spade3";
        } else if (id == R.id.spade4) {
            curCardBackId = R.drawable.spade4;
            curCardName = "spade4";
        } else if (id == R.id.spade5) {
            curCardBackId = R.drawable.spade5;
            curCardName = "spade5";
        } else if (id == R.id.spade6) {
            curCardBackId = R.drawable.spade6;
            curCardName = "spade6";
        } else if (id == R.id.spade7) {
            curCardBackId = R.drawable.spade7;
            curCardName = "spade7";
        } else if (id == R.id.spade8) {
            curCardBackId = R.drawable.spade8;
            curCardName = "spade8";
        } else if (id == R.id.spade9) {
            curCardBackId = R.drawable.spade9;
            curCardName = "spade9";
        } else if (id == R.id.spade10) {
            curCardBackId = R.drawable.spade10;
            curCardName = "spade10";
        } else if (id == R.id.spade11) {
            curCardBackId = R.drawable.spade11;
            curCardName = "spade11";
        } else if (id == R.id.spade12) {
            curCardBackId = R.drawable.spade12;
            curCardName = "spade12";
        } else if (id == R.id.spade13) {
            curCardBackId = R.drawable.spade13;
            curCardName = "spade13";
        } else if (id == R.id.diamond1) {
            curCardBackId = R.drawable.diamond1;
            curCardName = "diamond1";
        } else if (id == R.id.diamond2) {
            curCardBackId = R.drawable.diamond2;
            curCardName = "diamond2";
        } else if (id == R.id.diamond3) {
            curCardBackId = R.drawable.diamond3;
            curCardName = "diamond3";
        } else if (id == R.id.diamond4) {
            curCardBackId = R.drawable.diamond4;
            curCardName = "diamond4";
        } else if (id == R.id.diamond5) {
            curCardBackId = R.drawable.diamond5;
            curCardName = "diamond5";
        } else if (id == R.id.diamond6) {
            curCardBackId = R.drawable.diamond6;
            curCardName = "diamond6";
        } else if (id == R.id.diamond7) {
            curCardBackId = R.drawable.diamond7;
            curCardName = "diamond7";
        } else if (id == R.id.diamond8) {
            curCardBackId = R.drawable.diamond8;
            curCardName = "diamond8";
        } else if (id == R.id.diamond9) {
            curCardBackId = R.drawable.diamond9;
            curCardName = "diamond9";
        } else if (id == R.id.diamond10) {
            curCardBackId = R.drawable.diamond10;
            curCardName = "diamond10";
        } else if (id == R.id.diamond11) {
            curCardBackId = R.drawable.diamond11;
            curCardName = "diamond11";
        } else if (id == R.id.diamond12) {
            curCardBackId = R.drawable.diamond12;
            curCardName = "diamond12";
        } else if (id == R.id.diamond13) {
            curCardBackId = R.drawable.diamond13;
            curCardName = "diamond13";
        } else {
            curCardName = "";
        }

        int curCardNum = getCardNum(curCardName);

        // 判断之前有没有选择该张卡片
        for(int i = 0; i<4; i++){
            if(chooseCardsName[i].equals(curCardName)) return;
        }

        //从四个空格中选择一个
        for(int i = 0; i<4; i++){
            if(chooseNums[i] == 0){
                sta.push(i);
                sta2.push(findViewById(curCardId));
                view.setVisibility(View.INVISIBLE);
                chooseCards.get(i).setBackground(getDrawable(curCardBackId));
                chooseNums[i] = curCardNum;
                chooseCardsName[i] = curCardName;
                break;
            }
        }
    }
}
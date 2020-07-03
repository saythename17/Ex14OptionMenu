package com.icandothisallday2020.ex14optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //방법 1/상수화된 변수(final) 생성
    final int MENU_MY=1;
    final int MENU_GOD=2;

    //LifeCycle Method(Callback Method)
    //:이 액티비티가 생성되면 자동으로 생성되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Menu
        * OptionMenu (ActionBar Menu)*/
    }
    //onCreate() Method 실행
    // ->자동으로 OptionMenu 생성하는 콜백메소드 발동
    //(콜백메소드는 개발자가 임의로 호출하면 운영체제가 꼬임)
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //옵션메뉴에 들어갈 메뉴아이템들을 생성하여 추가
        //방법 1: 메뉴아이템 추가를 Java 언어의 add()메소드로
        menu.add("oh");//자동으로 oh 글씨를 가진 MenuItem 객체 생성&추가
        menu.add(0,1,0,"my");
        //그룹번호,아이템 개별 식별변호,보이는 순서,타이틀 이름
        menu.add(0, 2,0, "god");

        //방법 2: 메뉴항목 설계를 xml 로하고 이를 Java 에서 객체로 만들어 사용
        //res/menu/option.xml 문서를 만들어 그 안에 메뉴항목설계
        //↑xml 문서를 읽어와서 Menu 객체로 만들어주는(부풀리는) 객체(MenuInflater)
        MenuInflater menuInflater=this.getMenuInflater();
        menuInflater.inflate(R.menu.option,menu);

        //Overflow menu :기본적으로 icon 이 보이지 않기에 자바에서 설정
        if(menu instanceof MenuBuilder){
            MenuBuilder menuBuilder=(MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }
    //OptionMenu 의 메뉴항목(MenuItem)을 선택했을때
    // 자동으로 실행되는 콜벡 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //                                           └선택된 메뉴참조
        //선택한 MenuItem 을 파라미터(item)로 전달받음
        //->전달된 item 객테를 식별하여 원하는 작업 수행
        int itemId=item.getItemId();
        switch (itemId){
            //방법1
            case MENU_MY:
                Toast t=Toast.makeText(this,"MY",Toast.LENGTH_SHORT);
                t.show();
                break;
            case MENU_GOD:
                Toast.makeText(this,"God ",Toast.LENGTH_SHORT).show();
                break;
            //방법2
            case R.id.menu_search:
                Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_add:
                Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
